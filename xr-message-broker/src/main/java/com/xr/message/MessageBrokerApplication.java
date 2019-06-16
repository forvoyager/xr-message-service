package com.xr.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019/6/15 0015 13:26 <br>
 * <b>description</b>：
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath*:spring.xml")
public class MessageBrokerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MessageBrokerApplication.class, args);
  }

}
