package com.xr.message.consumer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 16:24:00 <br>
 * <b>description</b>: 消费者 启动自动配置 <br>
 */
@Configuration
// 扫描&创建当前路径下的bean
@ComponentScan(basePackageClasses = {ConsumerAutoConfiguration.class})
@EnableConfigurationProperties(ConsumerProperties.class)
// false时不启动消费者
@ConditionalOnProperty(prefix = ConsumerProperties.PREFIX, name = "enable", matchIfMissing = false)
public class ConsumerAutoConfiguration {
  public ConsumerAutoConfiguration(){}
}
