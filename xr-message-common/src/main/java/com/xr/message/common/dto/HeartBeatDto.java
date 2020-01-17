package com.xr.message.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 09:29:00 <br>
 * <b>description</b>: 心跳信息<br>
 */
public class HeartBeatDto implements Serializable {

  /**
   * 主机名
   */
  private String hostname;
  /**
   * IP地址
   */
  private String ip;
  /**
   * JVM进程ID
   */
  private int pid;
  /**
   * 实例名称（spring.application.name）
   */
  private String instanceName;

  /**
   * 类型 0生产者 1消费者
   */
  private int type;
  /**
   * 发布/订阅 的topic
   * 具体内容见type
   */
  private List<String> topics = new ArrayList<String>();
  /**
   * 发布/订阅 的tag，按topic归类
   * Map<topic, List tag>
   * 具体内容见type
   */
  private Map<String, List<String>> tags = new HashMap<String, List<String>>();

}
