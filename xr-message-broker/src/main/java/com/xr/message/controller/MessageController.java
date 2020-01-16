package com.xr.message.controller;

import com.xr.base.common.dto.ResultDto;
import com.xr.message.common.dto.MessageDto;
import com.xr.message.dto.MessageIdDto;
import com.xr.message.service.MessageProcessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 09:35:00 <br>
 * <b>description</b>: 消息相关操作 API接口<br>
 */
@RestController
@RequestMapping("/message")
public class MessageController {

  @Resource
  private MessageProcessor messageProcessor;

  /**
   * 发送消息
   * @param messageDto
   * @return 消息id
   * @throws Exception
   */
  @RequestMapping("/send")
  public ResultDto send(@RequestBody MessageDto messageDto) throws Exception{
    return ResultDto.successData(messageProcessor.send(messageDto));
  }

  /**
   * 确认发送
   * @param messageIdDto
   * @throws Exception
   */
  @RequestMapping(value = "/confirm")
  public ResultDto confirm(@RequestBody MessageIdDto messageIdDto) throws Exception{
    messageProcessor.confirm(messageIdDto.getMessageIdList());
    return ResultDto.success("确认发送成功");
  }

  /**
   * 取消发送
   * @param messageIdDto
   * @throws Exception
   */
  @RequestMapping("/cancel")
  public ResultDto cancel(@RequestBody MessageIdDto messageIdDto) throws Exception{
    messageProcessor.cancel(messageIdDto.getMessageIdList());
    return ResultDto.success("取消发送成功");
  }

  @RequestMapping("/pull")
  public void pull() throws Exception{

  }
}
