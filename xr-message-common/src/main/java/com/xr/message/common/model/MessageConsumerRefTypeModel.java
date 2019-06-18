package com.xr.message.common.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消费者与消息类型关联关系 模型 <br>
 */
public class MessageConsumerRefTypeModel extends BaseModel {

  public static final String ID = "id";
  public static final String CONSUMER_ID = "consumer_id";
  public static final String TYPE_ID = "type_id";

  /**
   * 
   */
  private Integer id;
  /**
   * 消费者id
   */
  private Integer consumer_id;
  /**
   * 消息类型id
   */
  private Integer type_id;

  public Integer getId() {
    return this.id;
  }
  public MessageConsumerRefTypeModel setId(Integer id) {
    this.id = id;
    return this;
  }

  public Integer getConsumer_id() {
    return this.consumer_id;
  }
  public MessageConsumerRefTypeModel setConsumer_id(Integer consumer_id) {
    this.consumer_id = consumer_id;
    return this;
  }

  public Integer getType_id() {
    return this.type_id;
  }
  public MessageConsumerRefTypeModel setType_id(Integer type_id) {
    this.type_id = type_id;
    return this;
  }

}

