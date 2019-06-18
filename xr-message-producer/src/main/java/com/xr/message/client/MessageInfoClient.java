package com.xr.message.client;

import com.xr.message.common.Constants;
import com.xr.message.common.controller.IMessageInfoController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息记录表 相关操作feign客户端 <br>
 */
@FeignClient(value = Constants.MESSAGE_BROKER_SERVICE_ID)
public interface MessageInfoClient extends IMessageInfoController {
}
