package com.xr.message.service.impl;

import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.message.mapper.ConsumerMapper;
import com.xr.message.model.ConsumerModel;
import com.xr.message.service.IConsumerService;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消费者 服务实现 <br>
 */
@Service("consumerService")
public class ConsumerServiceImpl extends BaseServiceImpl<ConsumerMapper, ConsumerModel> implements IConsumerService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
