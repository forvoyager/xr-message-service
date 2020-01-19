package com.xr.message.common.dto;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-17 15:12:00 <br>
 * <b>description</b>: 消费者信息（topic + tag + group 唯一确定一个消费者） <br>
 */
public class ConsumerSignupDto extends RoleBaseInfoDto {

  /**
   * 消费的topic
   */
  private String topic;
  /**
   * 消费的tag
   */
  private String tag;
  /**
   * 消费者分组 当多个不同的消费者消费同一个tag的消息时，需使用不同的group
   */
  private String group;
  /**
   * 消费者名字，如：class name
   */
  private String name;

  public String getTopic() {
    return topic;
  }

  public ConsumerSignupDto setTopic(String topic) {
    this.topic = topic;
    return this;
  }

  public String getTag() {
    return tag;
  }

  public ConsumerSignupDto setTag(String tag) {
    this.tag = tag;
    return this;
  }

  public String getGroup() {
    return group;
  }

  public ConsumerSignupDto setGroup(String group) {
    this.group = group;
    return this;
  }

  public String getName() {
    return name;
  }

  public ConsumerSignupDto setName(String name) {
    this.name = name;
    return this;
  }
}
