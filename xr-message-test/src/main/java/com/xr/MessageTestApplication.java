package com.xr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2020/01/20 15:26 <br>
 * <b>description</b>：测试服务
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath*:spring.xml")
public class MessageTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(MessageTestApplication.class, args);
  }

}
