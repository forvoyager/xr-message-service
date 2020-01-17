package com.xr.message.consumer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 16:24:00 <br>
 * <b>description</b>: 消费者 启动自动配置 <br>
 */
@Configuration
@EnableConfigurationProperties(ConsumerProperties.class)
public class ConsumerAutoConfiguration {
}
