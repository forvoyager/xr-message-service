package com.xr.message.common.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息消费者 模型 <br>
 */
public class MessageConsumerModel extends BaseModel {

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String CONSUMER_URL = "consumer_url";
  public static final String DESCRIPTION = "description";

  /**
   * 消费者id
   */
  private Integer id;
  /**
   * 消费者名字
   */
  private String name;
  /**
   * 消息者地址
   */
  private String consumer_url;
  /**
   * 消息者描述
   */
  private String description;

  public Integer getId() {
    return this.id;
  }
  public MessageConsumerModel setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return this.name;
  }
  public MessageConsumerModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getConsumer_url() {
    return this.consumer_url;
  }
  public MessageConsumerModel setConsumer_url(String consumer_url) {
    this.consumer_url = consumer_url;
    return this;
  }

  public String getDescription() {
    return this.description;
  }
  public MessageConsumerModel setDescription(String description) {
    this.description = description;
    return this;
  }

}

