package com.xr.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019/6/15 0015 13:39 <br>
 * <b>description</b>：
 */
@Configuration
@MapperScan(basePackageClasses = {MessageBrokerApplication.class})
public class MessageBrokerAutoConfiguration {
}
