package com.xr.consumer.mapper;

import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.consumer.model.MessageConsumeUnqModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-02-27 18:54:18 <br>
 * <b>description</b>: 消息处理记录 mapper操作 <br>
 */
@Mapper
public interface MessageConsumeUnqMapper extends IBaseMapper<MessageConsumeUnqModel> {
}
