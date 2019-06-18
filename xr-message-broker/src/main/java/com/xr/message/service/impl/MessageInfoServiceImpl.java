package com.xr.message.service.impl;

import com.xr.message.base.service.impl.BaseServiceImpl;
import com.xr.message.common.model.MessageInfoModel;
import com.xr.message.mapper.MessageInfoMapper;
import com.xr.message.service.IMessageInfoService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息记录表 服务实现 <br>
 */
@Service("messageInfoService")
public class MessageInfoServiceImpl extends BaseServiceImpl<MessageInfoMapper, MessageInfoModel> implements IMessageInfoService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
