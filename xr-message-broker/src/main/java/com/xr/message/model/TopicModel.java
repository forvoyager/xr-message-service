package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息主题 模型 <br>
 */
public class TopicModel extends BaseModel {

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String DESCRIPTION = "description";

  /**
   * topic id
   */
  private Long id;
  /**
   * topic 名字
   */
  private String name;
  /**
   * topic 描述
   */
  private String description;

  public Long getId() {
    return this.id;
  }

  public TopicModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public TopicModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return this.description;
  }

  public TopicModel setDescription(String description) {
    this.description = description;
    return this;
  }

}

