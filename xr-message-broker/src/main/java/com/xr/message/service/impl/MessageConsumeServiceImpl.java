package com.xr.message.service.impl;

import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.mapper.MessageConsumeMapper;
import com.xr.message.model.MessageConsumeModel;
import com.xr.message.service.IMessageConsumeService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消息投递记录 服务实现 <br>
 */
@Service("messageConsumeService")
public class MessageConsumeServiceImpl extends BaseServiceImpl<MessageConsumeMapper, MessageConsumeModel> implements IMessageConsumeService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
