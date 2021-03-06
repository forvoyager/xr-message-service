package com.xr.message.service;

import com.xr.base.jdbc.service.IBaseService;
import com.xr.message.model.TagModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息tag 服务定义 <br>
 */
public interface ITagService extends IBaseService<TagModel> {

  TagModel insert(String name, Long topic_id) throws Exception;

}
