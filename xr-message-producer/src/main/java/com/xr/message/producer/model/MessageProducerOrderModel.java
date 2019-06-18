package com.xr.message.producer.model;

import com.xr.message.base.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 18:00:42 <br>
 * <b>description</b>: 消息生产者订单 模型 <br>
 */
public class MessageProducerOrderModel extends BaseModel {

  public static final String ID = "id";
  public static final String ORDER_ID = "order_id";

  /**
   * ID
   */
  private Long id;
  /**
   * 订单id
   */
  private Long order_id;

  public Long getId() {
    return this.id;
  }
  public MessageProducerOrderModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getOrder_id() {
    return this.order_id;
  }
  public MessageProducerOrderModel setOrder_id(Long order_id) {
    this.order_id = order_id;
    return this;
  }

}

