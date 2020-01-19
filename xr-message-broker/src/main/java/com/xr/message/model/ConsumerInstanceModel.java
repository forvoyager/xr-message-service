package com.xr.message.model;

import com.xr.base.common.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 10:34:15 <br>
 * <b>description</b>: 消费者实例信息 模型 <br>
 */
public class ConsumerInstanceModel extends BaseModel {

  public static final String ID = "id";
  public static final String CONSUMER_ID = "consumer_id";
  public static final String INSTANCE = "instance";
  public static final String NAME = "name";
  public static final String STATUS = "status";

  /**
   * 实例id
   */
  private Long id;
  /**
   * 消费者id
   */
  private Long consumer_id;
  /**
   * 消费者实例{IP}@{JVM PID}
   */
  private String instance;
  /**
   * 消费者名字，如：class name
   */
  private String name;
  /**
   * 状态 0有效 1无效
   */
  private Integer status;

  public Long getId() {
    return this.id;
  }

  public ConsumerInstanceModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getConsumer_id() {
    return this.consumer_id;
  }

  public ConsumerInstanceModel setConsumer_id(Long consumer_id) {
    this.consumer_id = consumer_id;
    return this;
  }

  public String getInstance() {
    return this.instance;
  }

  public ConsumerInstanceModel setInstance(String instance) {
    this.instance = instance;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public ConsumerInstanceModel setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getStatus() {
    return this.status;
  }

  public ConsumerInstanceModel setStatus(Integer status) {
    this.status = status;
    return this;
  }

}

