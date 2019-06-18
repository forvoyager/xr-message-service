package com.xr.message.base.datasource;

import com.xr.message.base.enums.Cluster;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Objects;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>:数据源动态切换拦截器
 */
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataSourceInterceptor {

  protected Logger logger = LoggerFactory.getLogger(getClass());

  public DataSourceInterceptor() {
    logger.info("init data source interceptor...");
  }

  @Pointcut("target(com.xr.message.base.service.IService)")
  public void pointcut() {
  }

  @Around("pointcut()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {

    // 标记是否是第一次进来，用于处理事务嵌套
    boolean isFirst = false;

    try {
      if (DataSourceContextHolder.getDataSourceType() == null) {
        isFirst = true;
      }

      /*
      根据method的最后一个参数来判断是操作master？ or slave？
      默认都操作主库
      优化：//TODO
      根据方法前缀来控制，如insert/update操作master，其他操作slave
       */
      if(isFirst) {
        Object[] args = pjp.getArgs();
        Object last = Objects.nonNull(args) && args.length > 0 ? args[args.length - 1] : null;
        if (Cluster.slave.equals(last)) {
          DataSourceContextHolder.setSlave();
        } else {
          DataSourceContextHolder.setMaster();
        }
      }

      return pjp.proceed();

    } finally {
      if(isFirst) {
        DataSourceContextHolder.clear();
      }
    }

  }
}
