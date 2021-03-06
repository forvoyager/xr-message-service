package com.xr.base.common.enums;

/**
 * 返回状态码定义
 */
public enum ResultCodeEnum {

  SUCCESS("200", "成功"),
  ILLEGAL_STATUS("400", "不合法的参数"),
  SYSTEM_ERROR("500", "系统错误"),
  ;

  private String code;
  private String label;

  private ResultCodeEnum(String code, String label){
    this.code = code;
    this.label = label;
  }

  public String getCode() {
    return code;
  }

  public String getLabel() {
    return label;
  }
}
