package com.xr.message.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.common.model.MessageProducerModel;
import com.xr.message.mapper.MessageProducerMapper;
import com.xr.message.service.IMessageProducerService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息生产者 服务实现 <br>
 */
@Service("messageProducerService")
public class MessageProducerServiceImpl extends BaseServiceImpl<MessageProducerMapper, MessageProducerModel> implements IMessageProducerService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
