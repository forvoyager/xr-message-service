package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消费者 模型 <br>
 */
public class ConsumerModel extends BaseModel {

  public static final String ID = "id";
  public static final String GROUP = "group";
  public static final String NAME = "name";
  public static final String TAG_ID = "tag_id";

  /**
   * 消费者id
   */
  private Long id;
  /**
   * 消费者分组 当多个不同的消费者消费同一个tag的消息时，需使用不同的group
   */
  private String group;
  /**
   * 消费者名字，如：{IP}@{JVM PID}
   */
  private String name;
  /**
   * 消费的tag id
   */
  private Long tag_id;

  public Long getId() {
    return this.id;
  }

  public ConsumerModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getGroup() {
    return this.group;
  }

  public ConsumerModel setGroup(String group) {
    this.group = group;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public ConsumerModel setName(String name) {
    this.name = name;
    return this;
  }

  public Long getTag_id() {
    return this.tag_id;
  }

  public ConsumerModel setTag_id(Long tag_id) {
    this.tag_id = tag_id;
    return this;
  }

}

