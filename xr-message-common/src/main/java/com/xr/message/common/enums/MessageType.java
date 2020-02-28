package com.xr.message.common.enums;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 11:39:00 <br>
 * <b>description</b>: 消息类型<br>
 */
public enum MessageType {

  // 1打头，非事务消息
  simple(10, "简单消息"),

  // 2打头，事务消息
  transaction(20, "事务消息"),
  delay(21, "延迟消息"),
  sequence(22, "（严格）顺序消息"),
  ;

  private int code;
  private String description;

  MessageType(int code, String description){
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public static MessageType parse(int code){
    for(MessageType ms : values()){
      if(ms.getCode() == code){
        return ms;
      }
    }

    throw new IllegalArgumentException("非法的消息类型");
  }

}
