package com.xr.message.producer.mapper;

import com.xr.message.base.mapper.IBaseMapper;
import com.xr.message.producer.model.MessageProducerOrderModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 18:00:42 <br>
 * <b>description</b>: 消息生产者订单 mapper操作 <br>
 */
@Mapper
public interface MessageProducerOrderMapper extends IBaseMapper<MessageProducerOrderModel> {
}
