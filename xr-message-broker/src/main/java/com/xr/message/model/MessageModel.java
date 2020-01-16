package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 14:44:15 <br>
 * <b>description</b>: 消息记录 模型 <br>
 */
public class MessageModel extends BaseModel {

  public static final String ID = "id";
  public static final String TOPIC_ID = "topic_id";
  public static final String TAG_ID = "tag_id";
  public static final String TYPE = "type";
  public static final String STATUS = "status";

  /**
   * 消息id
   */
  private Long id;
  /**
   * topic id
   */
  private Long topic_id;
  /**
   * tag id
   */
  private Long tag_id;
  /**
   * 类型 see MessageType
   */
  private Integer type;
  /**
   * 状态 0待确认 1待发送 2成功 3失败 4无效
   */
  private Integer status;

  public Long getId() {
    return this.id;
  }

  public MessageModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getTopic_id() {
    return this.topic_id;
  }

  public MessageModel setTopic_id(Long topic_id) {
    this.topic_id = topic_id;
    return this;
  }

  public Long getTag_id() {
    return this.tag_id;
  }

  public MessageModel setTag_id(Long tag_id) {
    this.tag_id = tag_id;
    return this;
  }

  public Integer getType() {
    return this.type;
  }

  public MessageModel setType(Integer type) {
    this.type = type;
    return this;
  }

  public Integer getStatus() {
    return this.status;
  }

  public MessageModel setStatus(Integer status) {
    this.status = status;
    return this;
  }

}

