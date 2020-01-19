package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 13:07:39 <br>
 * <b>description</b>: 消费者 模型 <br>
 */
public class ConsumerModel extends BaseModel {

  public static final String ID = "id";
  public static final String TOPIC_ID = "topic_id";
  public static final String TAG_ID = "tag_id";
  public static final String GROUP = "group";
  public static final String OFFSET_MESSAGE_ID = "offset_message_id";

  /**
   * 消费者id
   */
  private Long id;
  /**
   * topic id
   */
  private Long topic_id;
  /**
   * 消费的tag id
   */
  private Long tag_id;
  /**
   * 消费者分组 当多个不同的消费者消费同一个tag的消息时，需使用不同的group
   */
  private String group;
  /**
   * 下一条需要被消费的消息id
   */
  private Long offset_message_id;

  public Long getId() {
    return this.id;
  }

  public ConsumerModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getTopic_id() {
    return this.topic_id;
  }

  public ConsumerModel setTopic_id(Long topic_id) {
    this.topic_id = topic_id;
    return this;
  }

  public Long getTag_id() {
    return this.tag_id;
  }

  public ConsumerModel setTag_id(Long tag_id) {
    this.tag_id = tag_id;
    return this;
  }

  public String getGroup() {
    return this.group;
  }

  public ConsumerModel setGroup(String group) {
    this.group = group;
    return this;
  }

  public Long getOffset_message_id() {
    return this.offset_message_id;
  }

  public ConsumerModel setOffset_message_id(Long offset_message_id) {
    this.offset_message_id = offset_message_id;
    return this;
  }

}

