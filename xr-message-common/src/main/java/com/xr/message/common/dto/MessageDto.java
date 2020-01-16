package com.xr.message.common.dto;

import java.io.Serializable;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2020-01-16 09:43:00 <br>
 * <b>description</b>：消息内容
 */
public class MessageDto implements Serializable{

  /**
   * 消息topic
   */
  private String topic;
  /**
   * 消息tag（或 消息类型）
   */
  private String tag;
  /**
   * 消息type 0简单消息 1延迟消息 2事务消息 3（严格）顺序消息
   */
  private int type;
  /**
   * 消息内容 json格式
   */
  private String data;

  public String getTopic() {
    return topic;
  }

  public MessageDto setTopic(String topic) {
    this.topic = topic;
    return this;
  }

  public String getTag() {
    return tag;
  }

  public MessageDto setTag(String tag) {
    this.tag = tag;
    return this;
  }

  public int getType() {
    return type;
  }

  public MessageDto setType(int type) {
    this.type = type;
    return this;
  }

  public String getData() {
    return data;
  }

  public MessageDto setData(String data) {
    this.data = data;
    return this;
  }
}
