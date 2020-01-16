package com.xr.message.service;

import com.xr.base.common.enums.Cluster;
import com.xr.base.common.util.AssertUtils;
import com.xr.base.common.util.DateUtils;
import com.xr.base.common.util.Utils;
import com.xr.message.common.dto.MessageDto;
import com.xr.message.common.enums.MessageStatus;
import com.xr.message.common.enums.MessageType;
import com.xr.message.model.MessageModel;
import com.xr.message.model.TagModel;
import com.xr.message.model.TopicModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 10:44:00 <br>
 * <b>description</b>: 消息处理 <br>
 */
@Component("messageProcessor")
public class MessageProcessor {

  @Resource
  private ITopicService topicService;

  @Resource
  private ITagService tagService;

  @Resource
  private IMessageService messageService;

  /**
   * 发送消息
   * @param messageDto
   * @throws Exception
   */
  public Long send(MessageDto messageDto) throws Exception {
    AssertUtils.notNull(messageDto, "消息不完整");
    AssertUtils.notEmpty(messageDto.getTopic(), "消息topic不能为空");
    AssertUtils.notEmpty(messageDto.getTag(), "消息tag不能为空");
    AssertUtils.notEmpty(messageDto.getData(), "消息内容不能为空");
    MessageType.parse(messageDto.getType());

    Long topic_id = topics.get(messageDto.getTopic());
    if(topic_id == null){
      // topic不存在，则自动创建
      TopicModel topicModel = topicService.insert(messageDto.getTopic());
      topic_id = topicModel.getId();

      // 更新缓存
      topics.put(topicModel.getName(), topic_id);
    }

    Long tag_id = tags.get(messageDto.getTag()+"_"+topic_id);
    if(tag_id == null){
      // topic下对应的tag不存在，则自动创建
      TagModel tagModel = tagService.insert(messageDto.getTag(), topic_id);
      tag_id = tagModel.getId();

      // 更新缓存
      this.cacheTagMode(tagModel);
    }

    // 消息入库
    return messageService.insert(topic_id, tag_id, messageDto.getType(), messageDto.getData());
  }

  /**
   * 确认消息发送
   * 将消息置为待发送 MessageStatus.available
   *
   * @param messageIdList
   * @throws Exception
   */
  public void confirm(List<Long> messageIdList) throws Exception{
    AssertUtils.notEmpty(messageIdList, "确认发送的消息ID不存在");

    Map update = Utils.newHashMap(
            MessageModel.UPDATE_TIME, DateUtils.currentDateInSecond(),
            MessageModel.STATUS, MessageStatus.available.getCode(),
            "where_status", MessageStatus.init.getCode(),
            "idList", messageIdList
    );
    if(messageIdList.size() != messageService.updateByMap(update)){
      Utils.throwsBizException("确认发送失败，请重试。");
    }
  }

  /**
   * 取消消息发送
   * 将消息置为无效 MessageStatus.invalid
   *
   * @param messageIdList
   * @throws Exception
   */
  public void cancel(List<Long> messageIdList) throws Exception{
    AssertUtils.notEmpty(messageIdList, "取消发送的消息ID不存在");

    Map update = Utils.newHashMap(
            MessageModel.UPDATE_TIME, DateUtils.currentDateInSecond(),
            MessageModel.STATUS, MessageStatus.invalid.getCode(),
            "where_status", MessageStatus.init.getCode(),
            "idList", messageIdList
    );
    if(messageIdList.size() != messageService.updateByMap(update)){
      Utils.throwsBizException("取消发送失败，请重试。");
    }
  }

  /**
   * 初始化
   * @throws Exception
   */
  public void init() throws Exception {
    // 初始化topic
    List<TopicModel> topicModels = topicService.selectList(Utils.newHashMap("status", 1), Cluster.master);
    for(TopicModel topicModel : topicModels){
      topics.put(topicModel.getName(), topicModel.getId());
    }

    // 初始化tag
    List<TagModel> tagModels = tagService.selectList(Utils.newHashMap("status", 1), Cluster.master);
    for(TagModel tagModel : tagModels){
      cacheTagMode(tagModel);
    }

  }

  private void cacheTagMode(TagModel tagModel){
    tags.put(tagModel.getName(), tagModel.getId());
    tags.put(tagModel.getName()+"_"+tagModel.getTopic_id(), tagModel.getId());
  }

  // topic Map<name, id>
  private static final Map<String, Long> topics = new HashMap<String, Long>();

  // tag Map<name || name_topic_id, id>
  private static final Map<String, Long> tags = new HashMap<String, Long>();
}
