package com.xr.message.mapper;

import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.message.model.MessageConsumeModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消息投递记录 mapper操作 <br>
 */
@Mapper
public interface MessageConsumeMapper extends IBaseMapper<MessageConsumeModel> {
}
