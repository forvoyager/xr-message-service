package com.xr.message.mapper;

import com.xr.message.base.mapper.IBaseMapper;
import com.xr.message.common.model.MessageProducerModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息生产者 mapper操作 <br>
 */
@Mapper
public interface MessageProducerMapper extends IBaseMapper<MessageProducerModel> {
}
