package com.xr.message.mapper;

import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.message.model.ConsumerModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 10:40:36 <br>
 * <b>description</b>: 消费者 mapper操作 <br>
 */
@Mapper
public interface ConsumerMapper extends IBaseMapper<ConsumerModel> {
}
