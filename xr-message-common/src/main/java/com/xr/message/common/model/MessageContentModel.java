package com.xr.message.common.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息内容表 模型 <br>
 */
public class MessageContentModel extends BaseModel {

  public static final String MSG_ID = "msg_id";
  public static final String CONTENT = "content";

  /**
   * 消息id
   */
  private Long msg_id;
  /**
   * 消息内容
   */
  private String content;

  public Long getMsg_id() {
    return this.msg_id;
  }
  public MessageContentModel setMsg_id(Long msg_id) {
    this.msg_id = msg_id;
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

