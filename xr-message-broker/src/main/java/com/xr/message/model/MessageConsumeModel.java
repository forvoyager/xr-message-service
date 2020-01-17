package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消息投递记录 模型 <br>
 */
public class MessageConsumeModel extends BaseModel {

  public static final String ID = "id";
  public static final String MESSAGE_ID = "message_id";
  public static final String CONSUMER_ID = "consumer_id";
  public static final String STATUS = "status";

  /**
   * 主键id
   */
  private Long id;
  /**
   * 消息id
   */
  private Long message_id;
  /**
   * 消费者id
   */
  private Long consumer_id;
  /**
   * 状态 0已投递 1消费成功 2消费失败 3投递失败
   */
  private Integer status;

  public Long getId() {
    return this.id;
  }

  public MessageConsumeModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getMessage_id() {
    return this.message_id;
  }

  public MessageConsumeModel setMessage_id(Long message_id) {
    this.message_id = message_id;
    return this;
  }

  public Long getConsumer_id() {
    return this.consumer_id;
  }

  public MessageConsumeModel setConsumer_id(Long consumer_id) {
    this.consumer_id = consumer_id;
    return this;
  }

  public Integer getStatus() {
    return this.status;
  }

  public MessageConsumeModel setStatus(Integer status) {
    this.status = status;
    return this;
  }

}

