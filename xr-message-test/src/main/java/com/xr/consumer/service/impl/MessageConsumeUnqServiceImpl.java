package com.xr.consumer.service.impl;

import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.consumer.mapper.MessageConsumeUnqMapper;
import com.xr.consumer.model.MessageConsumeUnqModel;
import com.xr.consumer.service.IMessageConsumeUnqService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-02-27 18:54:18 <br>
 * <b>description</b>: 消息处理记录 服务实现 <br>
 */
@Service("messageConsumeUnqService")
public class MessageConsumeUnqServiceImpl extends BaseServiceImpl<MessageConsumeUnqMapper, MessageConsumeUnqModel> implements IMessageConsumeUnqService {
  @Override
  protected String getPrimaryKeyName() {
    return "message_id";
  }
}
