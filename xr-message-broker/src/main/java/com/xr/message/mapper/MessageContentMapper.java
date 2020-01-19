package com.xr.message.mapper;

import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.message.model.MessageContentModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息内容 mapper操作 <br>
 */
@Mapper
public interface MessageContentMapper extends IBaseMapper<MessageContentModel> {

  /**
   * <p>
   * 查询需要被消费的消息内容
   * </p>
   *
   * @param condition 查询条件
   * @return 返回消息内容
   */
  List<MessageContentModel> selectAvailableMessage(Map<String, Object> condition);

}
