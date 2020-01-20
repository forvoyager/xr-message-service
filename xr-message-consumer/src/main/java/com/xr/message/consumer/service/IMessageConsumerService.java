package com.xr.message.consumer.service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:49:00 <br>
 * <b>description</b>: 消息回调接口<br>
 */
public interface IMessageConsumerService<T> {

  /**
   * 有消息时触发操作
   * @param message_id 消息id
   * @param data 消息内容
   * @return true消费成功 false消费失败（抛出异常也是失败）
   * @throws Exception
   */
  boolean onMessage(long message_id, T data) throws Exception;

}
