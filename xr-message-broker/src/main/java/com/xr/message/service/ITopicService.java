package com.xr.message.service;

import com.xr.base.jdbc.service.IBaseService;
import com.xr.message.model.TopicModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息主题 服务定义 <br>
 */
public interface ITopicService extends IBaseService<TopicModel> {

  TopicModel insert(String name) throws Exception;

}
