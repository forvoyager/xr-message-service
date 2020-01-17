package com.xr.message.common.dto;

import java.io.Serializable;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:12:00 <br>
 * <b>description</b>: 消费者信息 <br>
 */
public class ConsumerDto implements Serializable {
  /**
   * 消费者分组
   * group+name 唯一确定一个消费者
   */
  private String group;
  /**
   * 消费者名称
   */
  private String name;
  /**
   * IP地址
   */
  private String ip;
  /**
   * JVM进程ID
   */
  private int pid;

}
