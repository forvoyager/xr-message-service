package com.xr.message.consumer;

import com.xr.message.consumer.service.impl.ConsumerProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 16:59:00 <br>
 * <b>description</b>: 消费者初始化配置<br>
 */
@Component
public class ConsumerInitRunner implements CommandLineRunner {

  @Resource
  private ConsumerProcessor consumerProcessor;

  @Override
  public void run(String... args) throws Exception {
    // 执行初始化
    consumerProcessor.init();

    // 开始拉取消息进行消费
    consumerProcessor.start();
  }
}
