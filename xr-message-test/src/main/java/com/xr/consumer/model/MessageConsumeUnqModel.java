package com.xr.consumer.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-02-27 18:54:18 <br>
 * <b>description</b>: 消息处理记录 模型 <br>
 */
public class MessageConsumeUnqModel extends BaseModel {

  public static final String MESSAGE_ID = "message_id";

  /**
   * 消息id
   */
  private Long message_id;

  public Long getMessage_id() {
    return this.message_id;
  }

  public MessageConsumeUnqModel setMessage_id(Long message_id) {
    this.message_id = message_id;
    return this;
  }

}

