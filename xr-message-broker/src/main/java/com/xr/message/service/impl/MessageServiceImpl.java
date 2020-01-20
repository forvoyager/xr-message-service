package com.xr.message.service.impl;

import com.xr.base.common.enums.Cluster;
import com.xr.base.common.util.AssertUtils;
import com.xr.base.common.util.DateUtils;
import com.xr.base.common.util.Utils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.common.enums.MessageStatus;
import com.xr.message.mapper.MessageMapper;
import com.xr.message.model.ConsumerModel;
import com.xr.message.model.MessageConsumeModel;
import com.xr.message.model.MessageContentModel;
import com.xr.message.model.MessageModel;
import com.xr.message.service.IConsumerService;
import com.xr.message.service.IMessageConsumeService;
import com.xr.message.service.IMessageContentService;
import com.xr.message.service.IMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

  @Transactional
  @Override
  public List<MessageContentModel> pull(long consumer_id, int offset_type, long offset, int size) throws Exception {

    // 限制每次最大拉取的消息数
    size = Math.min(size, 1000);

    ConsumerModel consumer = consumerService.selectById(consumer_id, Cluster.master);
    AssertUtils.notNull(consumer, "消费者不存在，请先注册。");

    long current = DateUtils.currentTimeInSecond();

    // 查询需要被消费的消息
    List<MessageContentModel> contentModels = Collections.EMPTY_LIST;
    if(offset_type == 0){
      // 先锁住消费者记录（当前事务没提交）
      ConsumerModel updateConsumer = new ConsumerModel();
      updateConsumer.setId(consumer.getId());
      updateConsumer.setWhere_version(consumer.getVersion());
      updateConsumer.setUpdate_time(current);
      if( 1 != consumerService.update(updateConsumer) ){
        Utils.throwsBizException("拉取消息失败，稍后重试。");
      }

      // 查询本批次需要消费的消息
      contentModels = messageContentService.selectAvailableMessage(
              consumer.getTopic_id(), consumer.getTag_id(), consumer.getOffset_message_id(), size);

      int rows = contentModels.size();

      // 抛出异常，回滚上面的更新操作
      //AssertUtils.isTrue(rows > 0,"暂时没有需要处理的消息");

      if( rows > 0){
        Long next_consume_message_id = null;

        // 生成消息投递记录
        MessageConsumeModel consumeModel = null;
        List<MessageConsumeModel> consumeModels = new ArrayList<>();
        for(MessageContentModel mcm : contentModels){
          consumeModel = new MessageConsumeModel();
          consumeModel.setConsumer_id(consumer.getId());
          consumeModel.setMessage_id(mcm.getMessage_id());
          consumeModel.setStatus(0);
          consumeModel.setCreate_time(current);
          consumeModel.setUpdate_time(current);
          consumeModel.setVersion(0L);
          consumeModels.add(consumeModel);

          next_consume_message_id = mcm.getMessage_id();
        }
        messageConsumeService.insertBatch(consumeModels);

        // 分批消费消息，更新下一个需要消费的消息id
        updateConsumer.setWhere_version(consumer.getVersion()+1);
        updateConsumer.setOffset_message_id( next_consume_message_id + 1 );
        if( 1 != consumerService.update(updateConsumer) ){
          Utils.throwsBizException("拉取消息失败，稍后重试。");
        }
      }

    } else if(offset_type == 1){
      contentModels = messageContentService.selectAvailableMessage(
              consumer.getTopic_id(), consumer.getTag_id(), offset, size);
    } else if(offset_type == 2){
      // todo
    }

    return contentModels;
  }

  @Resource
  private IMessageContentService messageContentService;

  @Resource
  private IMessageConsumeService messageConsumeService;

  @Resource
  private IConsumerService consumerService;
}
