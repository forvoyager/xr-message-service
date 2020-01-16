package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息内容 模型 <br>
 */
public class MessageContentModel extends BaseModel {

  public static final String MESSAGE_ID = "message_id";
  public static final String CONTENT = "content";

  /**
   * 消息id
   */
  private Long message_id;
  /**
   * 消息内容
   */
  private String content;

  public Long getMessage_id() {
    return this.message_id;
  }

  public MessageContentModel setMessage_id(Long message_id) {
    this.message_id = message_id;
    return this;
  }

  public String getContent() {
    return this.content;
  }

  public MessageContentModel setContent(String content) {
    this.content = content;
    return this;
  }

}

