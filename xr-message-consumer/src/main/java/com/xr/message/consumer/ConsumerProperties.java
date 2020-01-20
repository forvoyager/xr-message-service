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
   * 是否启动消费者自动配置，默认启动
   */
  private boolean enable = true;
  /**
   * 消息服务地址
   */
  private String nameServerAddress = "localhost:9999";
  /**
   * 是否启动消息自动推送模式，默认启动。
   * 为false表示关闭，消息不会自动推送，需要手动拉取。
   */
  private boolean pushModelEnable = true;
  /**
   * 消费者一次拉取的消息数，默认10
   */
  private int pullRows = 10;

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  public String getNameServerAddress() {
    return nameServerAddress;
  }

  public void setNameServerAddress(String nameServerAddress) {
    this.nameServerAddress = nameServerAddress;
  }

  public boolean isPushModelEnable() {
    return pushModelEnable;
  }

  public void setPushModelEnable(boolean pushModelEnable) {
    this.pushModelEnable = pushModelEnable;
  }

  public int getPullRows() {
    return pullRows;
  }

  public void setPullRows(int pullRows) {
    this.pullRows = pullRows;
  }
}
