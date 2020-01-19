package com.xr.message.service.impl;

import com.xr.base.common.util.Utils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.mapper.MessageContentMapper;
import com.xr.message.model.MessageContentModel;
import com.xr.message.service.IMessageContentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息内容 服务实现 <br>
 */
@Service("messageContentService")
public class MessageContentServiceImpl extends BaseServiceImpl<MessageContentMapper, MessageContentModel> implements IMessageContentService {
  @Override
  protected String getPrimaryKeyName() {
    return "message_id";
  }

  @Override
  public List<MessageContentModel> selectAvailableMessage(Long topic_id, Long tag_id, Long offset_message_id, Integer rows) throws Exception {
    return this.baseMapper.selectAvailableMessage(Utils.newHashMap(
            "topic_id", topic_id,
            "tag_id", tag_id,
            "offset_message_id", offset_message_id,
            "pagesize", rows
    ));
  }
}
