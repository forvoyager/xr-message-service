package com.xr.message.consumer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:58:00 <br>
 * <b>description</b>: 消费者注解，消息消费者用此注解标注
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Consumer {

  /**
   * 标识消费的topic
   * @return
   */
  String topic() default "DEFAULT";

  /**
   * 标识消费的tag
   * @return
   */
  String tag() default "";

  /**
   * 标识消费者分组，注：当多个不同的消费者消费同一个tag的消息时，需使用不同的group
   * @return
   */
  String consumerGroup() default "";
}
