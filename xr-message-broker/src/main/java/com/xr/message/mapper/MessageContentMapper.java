package com.xr.message.mapper;

import com.xr.message.base.mapper.IBaseMapper;
import com.xr.message.common.model.MessageContentModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息内容表 mapper操作 <br>
 */
@Mapper
public interface MessageContentMapper extends IBaseMapper<MessageContentModel> {
}