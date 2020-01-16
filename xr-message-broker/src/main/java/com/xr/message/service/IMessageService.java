package com.xr.message.service;

import com.xr.base.jdbc.service.IBaseService;
import com.xr.message.model.MessageModel;

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

}
