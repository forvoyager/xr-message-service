package com.xr.message.dto;

import java.io.Serializable;
import java.util.List;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 15:01:00 <br>
 * <b>description</b>: <br>
 */
public class MessageIdDto implements Serializable {

  /**
   * 消息id列表
   */
  private List<Long> messageIdList;

  public List<Long> getMessageIdList() {
    return messageIdList;
  }

  public MessageIdDto setMessageIdList(List<Long> messageIdList) {
    this.messageIdList = messageIdList;
    return this;
  }
}
