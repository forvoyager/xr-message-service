package com.xr.message.common.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息类型 模型 <br>
 */
public class MessageTypeModel extends BaseModel {

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String CODE = "code";
  public static final String PRODUCER_ID = "producer_id";
  public static final String DESCRIPTION = "description";

  /**
   * 类型id
   */
  private Integer id;
  /**
   * 
   */
  private String name;
  /**
   * 
   */
  private String code;
  /**
   * 
   */
  private Integer producer_id;
  /**
   * 描述
   */
  private String description;

  public Integer getId() {
    return this.id;
  }
  public MessageTypeModel setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return this.name;
  }
  public MessageTypeModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getCode() {
    return this.code;
  }
  public MessageTypeModel setCode(String code) {
    this.code = code;
    return this;
  }

  public Integer getProducer_id() {
    return this.producer_id;
  }
  public MessageTypeModel setProducer_id(Integer producer_id) {
    this.producer_id = producer_id;
    return this;
  }

  public String getDescription() {
    return this.description;
  }
  public MessageTypeModel setDescription(String description) {
    this.description = description;
    return this;
  }

}

