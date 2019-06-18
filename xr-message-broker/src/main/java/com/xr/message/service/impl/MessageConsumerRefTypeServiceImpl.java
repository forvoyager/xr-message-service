package com.xr.message.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.common.model.MessageConsumerRefTypeModel;
import com.xr.message.mapper.MessageConsumerRefTypeMapper;
import com.xr.message.service.IMessageConsumerRefTypeService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消费者与消息类型关联关系 服务实现 <br>
 */
@Service("messageConsumerRefTypeService")
public class MessageConsumerRefTypeServiceImpl extends BaseServiceImpl<MessageConsumerRefTypeMapper, MessageConsumerRefTypeModel> implements IMessageConsumerRefTypeService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
