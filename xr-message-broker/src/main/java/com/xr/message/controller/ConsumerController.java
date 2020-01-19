package com.xr.message.controller;

import com.xr.base.common.dto.ResultDto;
import com.xr.base.common.util.AssertUtils;
import com.xr.message.common.dto.ConsumerSignupDto;
import com.xr.message.service.IConsumerService;
import com.xr.message.service.IMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:20:00 <br>
 * <b>description</b>: 消费者相关操作 API接口<br>
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

  @Resource
  private IConsumerService consumerService;

  @Resource
  private IMessageService messageService;

  /**
   * 消息消费者注册
   * @return
   * @throws Exception
   */
  @RequestMapping("/signup")
  public ResultDto signup(ConsumerSignupDto consumer) throws Exception{
    AssertUtils.notNull(consumer, "消费者信息不完整");
    AssertUtils.notNull(consumer.getTopic(), "消费者TOPIC信息不完整");
    AssertUtils.notNull(consumer.getTag(), "消费者TAG信息不完整");
    AssertUtils.notNull(consumer.getGroup(), "消费者GROUP信息不完整");
    AssertUtils.notNull(consumer.getInstance(), "消费者INSTANCE信息不完整");
    return ResultDto.successData(consumerService.signup(consumer));
  }

  /**
   * 消息消费者心跳上传
   * @return
   * @throws Exception
   */
  @RequestMapping("/heartbeat")
  public ResultDto heartbeat() throws Exception{
    // TODO
    return null;
  }

  /**
   * 消费者拉取消息
   * @param consumer_id 消费者id
   * @param offset_type 拉取方式
   * @param offset
   * @param size 拉取多少条消息，默认10（可配）
   * @throws Exception
   */
  @RequestMapping("/pull")
  public ResultDto pull(long consumer_id, int offset_type, long offset, int size) throws Exception{
    return ResultDto.successData(messageService.pull(consumer_id, offset_type, offset, size));
  }

  /**
   * 拉取消息回应信息（拉取到消息后，告知服务器我拿到了）
   * @return
   * @throws Exception
   */
  @RequestMapping("/pull/ack")
  public ResultDto pullAck() throws Exception{
    // todo
    return null;
  }

  /**
   * 拉取的消息处理完毕，上传处理结果
   * @return
   * @throws Exception
   */
  @RequestMapping("/consume/ack")
  public ResultDto consumeAck() throws Exception{
    // todo
    return null;
  }

}
