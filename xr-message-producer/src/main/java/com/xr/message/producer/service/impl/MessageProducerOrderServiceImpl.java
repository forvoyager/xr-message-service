package com.xr.message.producer.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.producer.model.MessageProducerOrderModel;
import com.xr.message.producer.service.IMessageProducerOrderService;
import com.xr.message.producer.mapper.MessageProducerOrderMapper;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 18:00:42 <br>
 * <b>description</b>: 消息生产者订单 服务实现 <br>
 */
@Service("messageProducerOrderService")
public class MessageProducerOrderServiceImpl extends BaseServiceImpl<MessageProducerOrderMapper, MessageProducerOrderModel> implements IMessageProducerOrderService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
