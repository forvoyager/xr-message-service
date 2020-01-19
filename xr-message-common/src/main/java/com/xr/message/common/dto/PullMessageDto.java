package com.xr.message.common.dto;

import java.io.Serializable;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 18:26:00 <br>
 * <b>description</b>: 拉取的消息信息<br>
 */
public class PullMessageDto implements Serializable {
  /**
   * 消息id
   */
  private long message_id;
  /**
   * 消息内容
   */
  private String content;

  public long getMessage_id() {
    return message_id;
  }

  public PullMessageDto setMessage_id(long message_id) {
    this.message_id = message_id;
    return this;
  }

  public String getContent() {
    return content;
  }

  public PullMessageDto setContent(String content) {
    this.content = content;
    return this;
  }
}
