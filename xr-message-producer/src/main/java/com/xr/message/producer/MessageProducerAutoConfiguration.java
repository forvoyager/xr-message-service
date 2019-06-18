package com.xr.message.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019/6/18 0018 18:12 <br>
 * <b>description</b>：
 */
@EnableDiscoveryClient
@Configuration
@MapperScan
public class MessageProducerAutoConfiguration {
}
