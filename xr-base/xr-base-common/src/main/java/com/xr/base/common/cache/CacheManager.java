package com.xr.base.common.cache;

import com.xr.base.common.util.AssertUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 10:22:00 <br>
 * <b>description</b>: 本地缓存 <br>
 */
public class CacheManager {

  private static final ConcurrentHashMap<String, Object> localCache = new ConcurrentHashMap<String, Object>();

  public static void put(String key, Object data) throws Exception{
    AssertUtils.notEmpty(key, "key不能为空");
    localCache.put(key, data);
  }

  public static <T> T get(String key){
    return getWithDefault(key, null);
  }

  public static <T> T getWithDefault(String key, Object defaultValue){
    Object data = localCache.get(key);
    return (T) (data==null?defaultValue:data);
  }

  public static <T> T getWithCallable(String key, Callable callable) throws Exception{
    Object data = localCache.get(key);
    return (T) (data==null ? callable.call() : data);
  }
}
