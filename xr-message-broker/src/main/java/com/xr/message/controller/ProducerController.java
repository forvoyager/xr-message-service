package com.xr.message.controller;

import com.xr.base.common.dto.ResultDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:20:00 <br>
 * <b>description</b>: 生产者相关操作 API接口<br>
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

  /**
   * 消息消费者注册
   * @return
   * @throws Exception
   */
  @RequestMapping("/producer/signup")
  public ResultDto signup() throws Exception{

    return null;
  }

  /**
   * 消息消费者心跳上传
   * @return
   * @throws Exception
   */
  @RequestMapping("/producer/heartbeat")
  public ResultDto heartbeat() throws Exception{

    return null;
  }
}
