package com.xr.message.producer.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019/6/18 0018 20:14 <br>
 * <b>description</b>：消息发送拦截器
 */
@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE - 90)
public class MessageInterceptor {
}
