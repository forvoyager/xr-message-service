package com.xr.message.consumer;

import com.xr.message.consumer.annotation.Consumer;
import com.xr.message.consumer.service.IMessageCallbackService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 17:48:00 <br>
 * <b>description</b>: 消费者信息验证处理<br>
 */
@Component
public class ConsumerValidatorProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

    if(bean == null){ return bean; }

    // 获取Consumer注解
    Consumer ann = bean.getClass().getAnnotation(Consumer.class);
    // 获取IMessageCallbackService回调接口
    Class clazz = this.getInterface(bean.getClass(), IMessageCallbackService.class);

    // 没有添加注解和回调接口（非消费者）
    if(ann == null && clazz == null){ return bean; }

    String name = bean.getClass().getName();
    // 消费者必须添加注解 && 实现回调接口
    if(ann == null || clazz == null){
      throw new RuntimeException("消费者："+name+"，需添加@Consumer注解并实现IMessageCallbackService回调接口。");
    }

    // 检查注解参数是否正确
    this.notEmpty(ann.topic(), "消费者："+name+"，topic不能为空。");
    this.notEmpty(ann.tag(), "消费者："+name+"，tag不能为空。");
    this.notEmpty(ann.consumerGroup(), "消费者："+name+"，consumer group不能为空。");

    return bean;
  }

  /**
   * 从bean中获取clazz
   *
   * @param bean
   * @param clazz
   * @return
   */
  private Class getInterface(Class bean, Class clazz){
    // TODO
    return null;
  }

  private void notEmpty(String value, String message){
    if(value == null || value.trim().length() == 0){
      throw new RuntimeException(message);
    }
  }
}
