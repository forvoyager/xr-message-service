package com.xr.message.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.common.model.MessageContentModel;
import com.xr.message.mapper.MessageContentMapper;
import com.xr.message.service.IMessageContentService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息内容表 服务实现 <br>
 */
@Service("messageContentService")
public class MessageContentServiceImpl extends BaseServiceImpl<MessageContentMapper, MessageContentModel> implements IMessageContentService {
  @Override
  protected String getPrimaryKeyName() {
    return "msg_id";
  }
}
