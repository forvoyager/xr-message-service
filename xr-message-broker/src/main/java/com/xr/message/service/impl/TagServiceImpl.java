package com.xr.message.service.impl;

import com.xr.base.common.util.DateUtils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.mapper.TagMapper;
import com.xr.message.model.TagModel;
import com.xr.message.service.ITagService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-15 15:27:59 <br>
 * <b>description</b>: 消息tag 服务实现 <br>
 */
@Service("tagService")
public class TagServiceImpl extends BaseServiceImpl<TagMapper, TagModel> implements ITagService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }

  @Override
  public TagModel insert(String name, Long topic_id) throws Exception {
    TagModel tagModel = new TagModel();
    tagModel.setName(name);
    tagModel.setDescription(name);
    tagModel.setTopic_id(topic_id);
    tagModel.setCreate_time(DateUtils.currentTimeInSecond());
    return this.insert(tagModel);
  }
}
