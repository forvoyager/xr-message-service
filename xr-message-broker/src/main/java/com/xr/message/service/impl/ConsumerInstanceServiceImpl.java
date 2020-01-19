package com.xr.message.service.impl;

import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.mapper.ConsumerInstanceMapper;
import com.xr.message.model.ConsumerInstanceModel;
import com.xr.message.service.IConsumerInstanceService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 10:34:15 <br>
 * <b>description</b>: 消费者实例信息 服务实现 <br>
 */
@Service("consumerInstanceService")
public class ConsumerInstanceServiceImpl extends BaseServiceImpl<ConsumerInstanceMapper, ConsumerInstanceModel> implements IConsumerInstanceService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
