package com.xr.message.service.impl;

import com.xr.base.common.enums.Cluster;
import com.xr.base.common.util.DateUtils;
import com.xr.base.common.util.Utils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.common.dto.ConsumerSignupDto;
import com.xr.message.mapper.ConsumerMapper;
import com.xr.message.model.ConsumerInstanceModel;
import com.xr.message.model.ConsumerModel;
import com.xr.message.model.TagModel;
import com.xr.message.model.TopicModel;
import com.xr.message.service.IConsumerInstanceService;
import com.xr.message.service.IConsumerService;
import com.xr.message.service.ITagService;
import com.xr.message.service.ITopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消费者 服务实现 <br>
 */
@Service("consumerService")
public class ConsumerServiceImpl extends BaseServiceImpl<ConsumerMapper, ConsumerModel> implements IConsumerService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }

  @Transactional
  @Override
  public Long signup(ConsumerSignupDto consumerDto) throws Exception {

    TopicModel topic = topicService.insert(consumerDto.getTopic());

    TagModel tag = tagService.insert(consumerDto.getTag(), topic.getId());

    long current = DateUtils.currentTimeInSecond();

    // 生成消费者记录
    ConsumerModel consumer = this.selectOne(Utils.newHashMap(
            ConsumerModel.TOPIC_ID, topic.getId(),
            ConsumerModel.TAG_ID, tag.getId(),
            ConsumerModel.GROUP, consumerDto.getGroup()
    ), Cluster.master);
    if(consumer == null){
      consumer = new ConsumerModel();
      consumer.setTopic_id(topic.getId());
      consumer.setTag_id(tag.getId());
      consumer.setGroup(consumerDto.getGroup());
      consumer.setOffset_message_id(0L);
      consumer.setCreate_time(current);
      consumer.setUpdate_time(current);
      consumer.setVersion(0L);
      consumer = this.insert(consumer);
    }

    // 生成消费者实例记录
    ConsumerInstanceModel instance = consumerInstanceService.selectOne(Utils.newHashMap(
            ConsumerInstanceModel.CONSUMER_ID, consumer.getId(),
            ConsumerInstanceModel.INSTANCE, consumerDto.getInstance(),
            ConsumerInstanceModel.NAME, consumerDto.getName()
    ), Cluster.master);
    if(instance == null){
      instance = new ConsumerInstanceModel();
      instance.setConsumer_id(consumer.getId());
      instance.setInstance(consumerDto.getInstance());
      instance.setName(consumerDto.getName());
      instance.setStatus(0);
      instance = consumerInstanceService.insert(instance);
    }

    return consumer.getId();
  }

  @Resource
  private ITopicService topicService;

  @Resource
  private ITagService tagService;

  @Resource
  private IConsumerInstanceService consumerInstanceService;
}
