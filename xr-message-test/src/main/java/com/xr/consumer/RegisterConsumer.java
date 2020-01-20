package com.xr.consumer;

import com.xr.message.consumer.annotation.Consumer;
import com.xr.message.consumer.service.impl.NoTransactionMessageConsumer;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-20 15:26:00 <br>
 * <b>description</b>: <br>
 */
@Consumer(topic = "TEST_TOPIC", tag = "TEST_TAG", group = "TEST_GROUP")
public class RegisterConsumer extends NoTransactionMessageConsumer<String> {
  @Override
  public boolean onMessage(String message) throws Exception {

    System.out.println("处理消息："+message);

    return true;
  }
}