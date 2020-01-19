package com.xr.message.service;

import com.xr.base.jdbc.service.IBaseService;
import com.xr.message.common.dto.ConsumerSignupDto;
import com.xr.message.model.ConsumerModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:01:49 <br>
 * <b>description</b>: 消费者 服务定义 <br>
 */
public interface IConsumerService extends IBaseService<ConsumerModel> {

  /**
   * 消费者注册
   * @param consumerDto
   * @return 返回消费者ID
   * @throws Exception
   */
  Long signup(ConsumerSignupDto consumerDto) throws Exception;

}
