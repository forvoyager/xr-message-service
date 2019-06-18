package com.xr.message.common.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息生产者 模型 <br>
 */
public class MessageProducerModel extends BaseModel {

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String VERIFY_URL = "verify_url";
  public static final String DESCRIPTION = "description";

  /**
   * 生产者id
   */
  private Integer id;
  /**
   * 生产者名字
   */
  private String name;
  /**
   * 消息订单验证地址
   */
  private String verify_url;
  /**
   * 生产者描述
   */
  private String description;

  public Integer getId() {
    return this.id;
  }
  public MessageProducerModel setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return this.name;
  }
  public MessageProducerModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getVerify_url() {
    return this.verify_url;
  }
  public MessageProducerModel setVerify_url(String verify_url) {
    this.verify_url = verify_url;
    return this;
  }

  public String getDescription() {
    return this.description;
  }
  public MessageProducerModel setDescription(String description) {
    this.description = description;
    return this;
  }

}

