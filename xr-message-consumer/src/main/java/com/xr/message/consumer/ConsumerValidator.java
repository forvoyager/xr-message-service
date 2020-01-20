package com.xr.message.consumer;

import com.xr.message.consumer.annotation.Consumer;
import com.xr.message.consumer.service.IMessageConsumerService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 17:48:00 <br>
 * <b>description</b>: 消费者信息验证处理<br>
 */
@Component
public class ConsumerValidator implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

    if(bean == null){ return bean; }

    // 获取Consumer注解
    Consumer ann = bean.getClass().getAnnotation(Consumer.class);
    // 是否实现了消费者接口
    boolean isConsumerBean = this.isConsumerBean(bean);

    // 没有添加注解和回调接口（非消费者）
    if(ann == null && !isConsumerBean){ return bean; }

    String name = bean.getClass().getName();
    // 消费者必须添加注解 && 实现回调接口
    if(ann == null || !isConsumerBean){
      throw new RuntimeException("消费者："+name+"，需添加@Consumer注解并继承NoTransactionMessageConsumer/TransactionMessageConsumer。");
    }

    // 检查注解参数是否正确
    this.notEmpty(ann.topic(), "消费者："+name+"，topic不能为空。");
    this.notEmpty(ann.tag(), "消费者："+name+"，tag不能为空。");
    this.notEmpty(ann.group(), "消费者："+name+"，group不能为空。");

    return bean;
  }

  /**
   * 判断是否是合法的consumer bean(继承NoTransactionMessageConsumer 或者 TransactionMessageConsumer)
   *
   * @param bean
   * @return
   */
  private boolean isConsumerBean(Object bean){
    if(bean instanceof IMessageConsumerService){
      return true;
    }
    return false;
  }

  private void notEmpty(String value, String message){
    if(value == null || value.trim().length() == 0){
      throw new RuntimeException(message);
    }
  }
}
