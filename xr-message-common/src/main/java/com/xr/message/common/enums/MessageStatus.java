package com.xr.message.common.enums;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 11:34:00 <br>
 * <b>description</b>: 消息状态 <br>
 */
public enum MessageStatus {

  init(0, "待确认"), // 初始状态
  available(1, "待发送"), // 收到确认发送的请求：可以将消息投递给消费者了
  success(2, "成功"), // 消费者处理成功
  fail(3, "失败"), // 消费者处理失败
  invalid(4, "无效"), // 收到取消发送的请求
  ;

  private int code;
  private String description;

  MessageStatus(int code, String description){
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public static MessageStatus parse(int code){
    for(MessageStatus ms : values()){
      if(ms.getCode() == code){
        return ms;
      }
    }

    throw new IllegalArgumentException("非法的消息状态");
  }
}
