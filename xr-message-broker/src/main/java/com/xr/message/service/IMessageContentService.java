package com.xr.message.service;

import com.xr.base.jdbc.service.IBaseService;
import com.xr.message.model.MessageContentModel;

import java.util.List;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息内容 服务定义 <br>
 */
public interface IMessageContentService extends IBaseService<MessageContentModel> {

  /**
   * 查询需要被消费的消息内容（按消息id升序）
   *
   * @param topic_id
   * @param tag_id
   * @param offset_message_id 消息记录起始位置
   * @param rows 查询的消息记录数
   * @return
   * @throws Exception
   */
  List<MessageContentModel> selectAvailableMessage(Long topic_id, Long tag_id, Long offset_message_id, Integer rows) throws Exception;

}
