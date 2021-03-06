package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息tag 模型 <br>
 */
public class TagModel extends BaseModel {

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String DESCRIPTION = "description";
  public static final String TOPIC_ID = "topic_id";
  public static final String OFFSET_MESSAGE_ID = "offset_message_id";

  /**
   * tag id
   */
  private Long id;
  /**
   * tag 名字，name + topic_id唯一确定一个tag
   */
  private String name;
  /**
   * tag 描述
   */
  private String description;
  /**
   * topic id，name + topic_id唯一确定一个tag
   */
  private Long topic_id;

  public Long getId() {
    return this.id;
  }

  public TagModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public TagModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return this.description;
  }

  public TagModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public Long getTopic_id() {
    return this.topic_id;
  }

  public TagModel setTopic_id(Long topic_id) {
    this.topic_id = topic_id;
    return this;
  }

}

