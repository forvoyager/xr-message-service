package com.xr.message.consumer.service.impl;

import org.springframework.transaction.annotation.Transactional;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-20 09:48:00 <br>
 * <b>description</b>: 消息处理器（有事务）<br>
 */
public abstract class TransactionMessageConsumer<T> extends NoTransactionMessageConsumer<T> {

  @Transactional
  @Override
  public boolean onMessage(long message_id, T data) throws Exception {
    return super.onMessage(message_id, data);
  }

}
