package com.xr.message.consumer.service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 16:44:00 <br>
 * <b>description</b>: 消息消费记录 服务定义<br>
 */
public interface IConsumeRecordService {

  /**
   * 写入消费记录
   * @param message_id 消息id
   * @param data 消息内容
   * @return 消费记录id（如果有）
   * @throws Exception
   */
  long insert(long message_id, Object data) throws Exception;

  /**
   * 更具消息id删除消费记录
   * @param message_id 消息id
   * @return 返回删除的条数
   * @throws Exception
   */
  int delete(long message_id) throws Exception;

  /**
   * 根据消息id查询消费记录是否存证
   * @param message_id 消息id
   * @return true存证（成功消费了） false不存在（还没用消费 或 消费失败了）
   * @throws Exception
   */
  boolean checkExisted(long message_id) throws Exception;

}
