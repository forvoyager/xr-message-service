package com.xr.message.service.impl;

import com.xr.base.common.util.DateUtils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.common.enums.MessageStatus;
import com.xr.message.mapper.MessageMapper;
import com.xr.message.model.MessageContentModel;
import com.xr.message.model.MessageModel;
import com.xr.message.service.IMessageContentService;
import com.xr.message.service.IMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息记录 服务实现 <br>
 */
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<MessageMapper, MessageModel> implements IMessageService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }

  @Transactional
  @Override
  public Long insert(Long topic_id, Long tag_id, int type, String data) throws Exception {
    // 消息信息
    long current = DateUtils.currentTimeInSecond();
    MessageModel messageModel = new MessageModel();
    messageModel.setTopic_id(topic_id);
    messageModel.setTag_id(tag_id);
    messageModel.setType(type);
    messageModel.setStatus(MessageStatus.init.getCode());
//    if(type == MessageType.simple.getCode()){
//      // 非事务消息，状态直接置为待发送（不需要确认）
//      messageModel.setStatus(MessageStatus.available.getCode());
//    }
    messageModel.setCreate_time(current);
    messageModel.setUpdate_time(current);
    messageModel.setVersion(0L);
    messageModel = this.insert(messageModel);

    // 消息内容
    MessageContentModel contentModel = new MessageContentModel();
    contentModel.setMessage_id(messageModel.getId());
    contentModel.setContent(data);
    messageContentService.insert(contentModel);

    return messageModel.getId();
  }

  @Resource
  private IMessageContentService messageContentService;
}
