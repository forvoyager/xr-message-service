package com.xr.message.consumer.service.impl;

import com.xr.base.common.util.Utils;
import com.xr.message.consumer.service.IConsumeRecordService;
import com.xr.message.consumer.service.IMessageConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-20 09:55:00 <br>
 * <b>description</b>: 消息处理器（无事务）<br>
 */
public abstract class NoTransactionMessageConsumer <T> implements IMessageConsumerService<T> {

  protected Logger logger = LoggerFactory.getLogger(getClass());

  @Resource
  private IConsumeRecordService consumeRecordService;

  @Override
  public boolean onMessage(long message_id, T data) throws Exception {
    // 检查消息是否已经处理过了，防止重复消费
    if(consumeRecordService.checkExisted(message_id)){
      Utils.throwsBizException("消息已被成功消费，不可重复处理，消息ID:"+message_id);
    }

    // 处理消息（根据返回结果判断是否成功）
    boolean success = this.process(message_id, data);
    if(success){
      try {
        // 成功了，记录消息消费记录
        consumeRecordService.insert(message_id, data);
      }catch (Exception e){
        // 出错，重试 TODO
      }
    }

    return success;
  }

  protected abstract boolean process(long message_id, T data) throws Exception;
}
