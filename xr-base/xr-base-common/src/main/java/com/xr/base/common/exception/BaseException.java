package com.xr.base.common.exception;

import com.xr.base.common.enums.ResultCodeEnum;

import java.util.Map;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2020-01-11 20:50:00
 * @Description: 自定义异常
 * 这里比较忧伤：
 * 1、继承自Exception（checked受检查异常）
 * 会导致@Transactional事务不能回滚，需要手动指定rollbackFor = Exception.class
 * 不配置rollbackFor属性，那么事物只会在遇到RuntimeException的时候才会回滚
 *
 * 2、继承自RuntimeException（Unchecked异常）
 * dubbo会对此类异常重新封装，不会把原始异常信息抛出去。（见org.apache.dubbo.rpc.filter.ExceptionFilter#onResponse）
 *
 * 解决方法：
 * 继承RuntimeException
 * dubbo接口实现GenericService，$invoke方法不做任何处理（废弃掉）
 * 蛋疼。。。
 *
 */
public class BaseException extends RuntimeException {
  /**
   * 代码
   * @see ResultCodeEnum
   */
  private String code;
  /**
   * 信息提示
   */
  private String message;
  /**
   * 扩展数据
   */
  private Map extData;

  public BaseException(){
//    this.code = ResultCodeEnum.SYSTEM_ERROR.getCode();
//    this.message = ResultCodeEnum.SYSTEM_ERROR.getLabel();
  }

  public BaseException(ResultCodeEnum code, String message){
    this.code = code.getCode();
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map getExtData() {
    return extData;
  }

  public void setExtData(Map extData) {
    this.extData = extData;
  }
}
