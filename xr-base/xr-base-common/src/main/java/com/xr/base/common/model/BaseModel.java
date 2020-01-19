package com.xr.base.common.model;

import java.beans.Transient;
import java.io.Serializable;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-11 20:50:00 <br>
 * <b>description</b>: 基础模型数据
 */
public class BaseModel implements Serializable {

  public static final String CREATE_TIME = "create_time";
  public static final String UPDATE_TIME = "update_time";
  public static final String VERSION = "version";
  public static final String WHERE_VERSION = "where_version";

  /**
   * 创建时间
   */
  protected Long create_time;
  /**
   * 最后更新时间
   */
  protected Long update_time;
  /**
   * 版本号
   */
  protected Long version;
  /**
   * 条件 版本号 （@Transient 不序列化）
   */
  protected Long where_version;

  @Transient
  public Long getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Long create_time) {
    this.create_time = create_time;
  }

  @Transient
  public Long getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(Long update_time) {
    this.update_time = update_time;
  }

  @Transient
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  @Transient
  public Long getWhere_version() {
    return where_version;
  }

  public void setWhere_version(Long where_version) {
    this.where_version = where_version;
  }
}
