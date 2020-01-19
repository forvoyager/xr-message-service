package com.xr.message.mapper;

import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.message.model.ConsumerInstanceModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 10:34:15 <br>
 * <b>description</b>: 消费者实例信息 mapper操作 <br>
 */
@Mapper
public interface ConsumerInstanceMapper extends IBaseMapper<ConsumerInstanceModel> {
}
