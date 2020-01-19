package com.xr.message.common.dto;

import java.io.Serializable;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 10:03:00 <br>
 * <b>description</b>: 消息服务中各种角色的基础信息 <br>
 */
public class RoleBaseInfoDto implements Serializable {
  /**
   * 主机名
   */
  private String hostname;
  /**
   * 实例名称 {IP}@{JVM PID}
   */
  private String instance;

  /**
   * 类型 0生产者 1消费者
   */
  private int type;

  public String getHostname() {
    return hostname;
  }

  public RoleBaseInfoDto setHostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

  public String getInstance() {
    return instance;
  }

  public RoleBaseInfoDto setInstance(String instance) {
    this.instance = instance;
    return this;
  }

  public int getType() {
    return type;
  }

  public RoleBaseInfoDto setType(int type) {
    this.type = type;
    return this;
  }
}
