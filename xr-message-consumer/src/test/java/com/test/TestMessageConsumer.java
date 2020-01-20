package com.test;

import com.xr.message.consumer.annotation.Consumer;
import com.xr.message.consumer.service.impl.NoTransactionMessageConsumer;

import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:54:00 <br>
 * <b>description</b>: <br>
 */
@Consumer(topic = "TEST_TOPIC", tag = "TEST_TAG", group = "TEST_GROUP")
public class TestMessageConsumer extends NoTransactionMessageConsumer<Map<String, Long>> {
  @Override
  protected boolean process(long message_id, Map<String, Long> data) throws Exception {
    return false;
  }
}
