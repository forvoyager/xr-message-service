package com.test;

import com.xr.message.consumer.annotation.Consumer;
import com.xr.message.consumer.service.IMessageCallbackService;

import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:54:00 <br>
 * <b>description</b>: <br>
 */
@Consumer(topic = "TEST_TOPIC", tag = "TEST_TAG", group = "TEST_GROUP")
public class TestMessageCallback implements IMessageCallbackService<Map<String, Long>> {
  @Override
  public boolean onMessage(Map<String, Long> message) throws Exception {
    return false;
  }
}
