package com.xr.message.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.common.model.MessageConsumerModel;
import com.xr.message.mapper.MessageConsumerMapper;
import com.xr.message.service.IMessageConsumerService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息消费者 服务实现 <br>
 */
@Service("messageConsumerService")
public class MessageConsumerServiceImpl extends BaseServiceImpl<MessageConsumerMapper, MessageConsumerModel> implements IMessageConsumerService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
