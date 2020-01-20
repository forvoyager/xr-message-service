package com.xr.message.consumer.processor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 17:23:00 <br>
 * <b>description</b>: 自定义线程工厂 <br>
 */
public class XrThreadFactory implements ThreadFactory {
  private final AtomicLong threadIndex;
  private final String threadNamePrefix;
  private final boolean daemon;

  public XrThreadFactory(String threadNamePrefix) {
    this(threadNamePrefix, false);
  }

  public XrThreadFactory(String threadNamePrefix, boolean daemon) {
    this.threadIndex = new AtomicLong(0L);
    this.threadNamePrefix = threadNamePrefix;
    this.daemon = daemon;
  }

  public Thread newThread(Runnable r) {
    Thread thread = new Thread(r, this.threadNamePrefix + this.threadIndex.incrementAndGet());
    thread.setDaemon(this.daemon);
    return thread;
  }
}