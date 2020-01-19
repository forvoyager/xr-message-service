package com.xr.message.service;

import com.xr.base.jdbc.service.IBaseService;
import com.xr.message.model.MessageContentModel;
import com.xr.message.model.MessageModel;

import java.util.List;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息记录 服务定义 <br>
 */
public interface IMessageService extends IBaseService<MessageModel> {

  /**
   * 消息入库
   * @param topic_id
   * @param tag_id
   * @param type
   * @param data
   * @return
   * @throws Exception
   */
  Long insert(Long topic_id, Long tag_id, int type, String data) throws Exception;

  /**
   * 拉取消息
   * @param consumer_id 消费者id
   * @param offset_type 拉取方式 0从最新位置（默认） 1从指定位置（消费者自己维护拉取进度） 2从指定时间（消费者自己维护拉取进度）
   * @param offset
   * @param size 拉取多少条消息，默认10（可配）
   * @return
   * @throws Exception
   */
  List<MessageContentModel> pull(long consumer_id, int offset_type, long offset, int size) throws Exception;
}
