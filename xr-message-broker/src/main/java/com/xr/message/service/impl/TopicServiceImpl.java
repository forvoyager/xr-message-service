package com.xr.message.service.impl;

import com.xr.base.common.enums.Cluster;
import com.xr.base.common.util.DateUtils;
import com.xr.base.common.util.Utils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.mapper.TopicMapper;
import com.xr.message.model.TopicModel;
import com.xr.message.service.ITopicService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息主题 服务实现 <br>
 */
@Service("topicService")
public class TopicServiceImpl extends BaseServiceImpl<TopicMapper, TopicModel> implements ITopicService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }

  @Override
  public TopicModel insert(String name) throws Exception {

    // 检查是否已经创建了
    TopicModel topicModel = this.selectOne(Utils.newHashMap(TopicModel.NAME, name), Cluster.master);
    if(topicModel != null){
      return topicModel;
    }

    // 不存在，创建topic
    topicModel = new TopicModel();
    topicModel.setName(name);
    topicModel.setDescription(name);
    topicModel.setCreate_time(DateUtils.currentTimeInSecond());
    return this.insert(topicModel);
  }
}
