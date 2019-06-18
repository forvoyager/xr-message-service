package com.xr.message.common.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息记录表 模型 <br>
 */
public class MessageInfoModel extends BaseModel {

  public static final String ID = "id";
  public static final String TYPE_ID = "type_id";
  public static final String PRODUCER_ID = "producer_id";
  public static final String STATUS = "status";
  public static final String RETRIES = "retries";

  /**
   * 消息id
   */
  private Long id;
  /**
   * 类型id
   */
  private Integer type_id;
  /**
   * 生产者id
   */
  private Integer producer_id;
  /**
   * 状态 0待发送 1成功 2失败
   */
  private Integer status;
  /**
   * 重试次数
   */
  private Integer retries;

  public Long getId() {
    return this.id;
  }
  public MessageInfoModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Integer getType_id() {
    return this.type_id;
  }
  public MessageInfoModel setType_id(Integer type_id) {
    this.type_id = type_id;
    return this;
  }

  public Integer getProducer_id() {
    return this.producer_id;
  }
  public MessageInfoModel setProducer_id(Integer producer_id) {
    this.producer_id = producer_id;
    return this;
  }

  public Integer getStatus() {
    return this.status;
  }
  public MessageInfoModel setStatus(Integer status) {
    this.status = status;
    return this;
  }

  public Integer getRetries() {
    return this.retries;
  }
  public MessageInfoModel setRetries(Integer retries) {
    this.retries = retries;
    return this;
  }

}

