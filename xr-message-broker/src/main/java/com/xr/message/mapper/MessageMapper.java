package com.xr.message.mapper;

import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.message.model.MessageModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息记录 mapper操作 <br>
 */
@Mapper
public interface MessageMapper extends IBaseMapper<MessageModel> {
}
