package com.xr.message.base.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>:动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
  @Override
  protected Object determineCurrentLookupKey() {
    return DataSourceContextHolder.getDataSourceType();
  }
}
