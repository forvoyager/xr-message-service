package com.xr.message.controller;

import com.xr.base.common.dto.ResultDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:20:00 <br>
 * <b>description</b>: 消费者相关操作 API接口<br>
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

  /**
   * 消息消费者注册
   * @return
   * @throws Exception
   */
  @RequestMapping("/signup")
  public ResultDto signup() throws Exception{

    return null;
  }

  /**
   * 消息消费者心跳上传
   * @return
   * @throws Exception
   */
  @RequestMapping("/heartbeat")
  public ResultDto heartbeat() throws Exception{

    return null;
  }

  /**
   * 消费者拉取消息
   * @param topic 拉取哪个topic
   * @param tag 拉取topic中的哪个tag
   * @param offset_type 拉取方式 0从最新消费
   * @param offset
   * @param size 拉取多少条消息，默认10（可配）
   * @throws Exception
   */
  @RequestMapping("/pull")
  public ResultDto pull(String topic, String tag, int offset_type, long offset, int size) throws Exception{

    return null;
  }

  /**
   * 拉取消息回应信息（拉取到消息后，告知服务器我拿到了）
   * @return
   * @throws Exception
   */
  @RequestMapping("/pull/ack")
  public ResultDto pullAck() throws Exception{

    return null;
  }

  /**
   * 拉取的消息处理完毕，上传处理结果
   * @return
   * @throws Exception
   */
  @RequestMapping("/consume/ack")
  public ResultDto consumeAck() throws Exception{

    return null;
  }

}
