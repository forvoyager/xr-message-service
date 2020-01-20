package com.xr.message.consumer.service.impl;

import com.xr.message.consumer.service.IMessageConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-20 09:55:00 <br>
 * <b>description</b>: 消息处理器（无事务）<br>
 */
public abstract class NoTransactionMessageConsumer <T> implements IMessageConsumerService<T> {

  protected Logger logger = LoggerFactory.getLogger(getClass());

}
