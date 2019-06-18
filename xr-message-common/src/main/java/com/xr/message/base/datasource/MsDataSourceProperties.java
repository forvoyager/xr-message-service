package com.xr.message.base.datasource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>:数据源自动配置信息
 */
public class MsDataSourceProperties {
  public static final String PREFIX = "ms.base.data.source";

  private boolean enabled = true;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
