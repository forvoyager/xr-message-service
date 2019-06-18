package com.xr.message.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.common.model.MessageTypeModel;
import com.xr.message.mapper.MessageTypeMapper;
import com.xr.message.service.IMessageTypeService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息类型 服务实现 <br>
 */
@Service("messageTypeService")
public class MessageTypeServiceImpl extends BaseServiceImpl<MessageTypeMapper, MessageTypeModel> implements IMessageTypeService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
