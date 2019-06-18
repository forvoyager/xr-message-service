package com.xr.message.base.datasource;

import com.xr.message.base.enums.Cluster;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>:保存上下文Data Source类型（线程安全）
 */
public class DataSourceContextHolder {

  private static ThreadLocal<Cluster> contextHolder = new ThreadLocal<Cluster>();

  public static void setMaster(){
    contextHolder.set(Cluster.master);
  }
  public static void setSlave(){
    contextHolder.set(Cluster.slave);
  }

  public static Cluster getDataSourceType() {
    return contextHolder.get();
  }

  public static void clear() {
    contextHolder.remove();
  }
}
