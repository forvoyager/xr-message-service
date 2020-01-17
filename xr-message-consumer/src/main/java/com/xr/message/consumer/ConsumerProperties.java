package com.xr.message.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 17:08:00 <br>
 * <b>description</b>: <br>
 */
@ConfigurationProperties(prefix = ConsumerProperties.PREFIX)
public class ConsumerProperties {

  public static final String PREFIX = "xr.message";

  /**
   * 消息服务地址
   */
  private String nameServerAddress = "localhost:9999";
  /**
   * 是否启动push模式，默认启动。
   * 为false表示关闭，消息不会自动推送，需要手动拉取。
   */
  private boolean pushEnable = true;

  public String getNameServerAddress() {
    return nameServerAddress;
  }

  public ConsumerProperties setNameServerAddress(String nameServerAddress) {
    this.nameServerAddress = nameServerAddress;
    return this;
  }

  public boolean isPushEnable() {
    return pushEnable;
  }

  public ConsumerProperties setPushEnable(boolean pushEnable) {
    this.pushEnable = pushEnable;
    return this;
  }
}
