package com.xr.message;

import com.xr.message.processor.MessageProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 10:02:00 <br>
 * <b>description</b>: 应用启动后初始化数据 <br>
 */
@Component
public class MessageBrokerInitRunner implements CommandLineRunner {

  @Resource
  private MessageProcessor messageProcessor;

  @Override
  public void run(String... args) throws Exception {
    messageProcessor.init();
  }
}
