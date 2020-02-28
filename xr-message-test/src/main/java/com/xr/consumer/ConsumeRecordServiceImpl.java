package com.xr.consumer;

import com.xr.base.common.enums.Cluster;
import com.xr.base.common.util.DateUtils;
import com.xr.base.common.util.Utils;
import com.xr.consumer.model.MessageConsumeUnqModel;
import com.xr.consumer.service.IMessageConsumeUnqService;
import com.xr.message.consumer.service.IConsumeRecordService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-02-27 18:06:00 <br>
 * <b>description</b>: 消息消费记录 服务实现<br>
 */
@Component
public class ConsumeRecordServiceImpl implements IConsumeRecordService {

  @Resource
  private IMessageConsumeUnqService messageConsumeUnqService;

  @Transactional
  @Override
  public long insert(long message_id, Object data) throws Exception {
    MessageConsumeUnqModel model = new MessageConsumeUnqModel();
    model.setMessage_id(message_id);
    model.setCreate_time(DateUtils.currentTimeInSecond());
    model = messageConsumeUnqService.insert(model);
    return model.getMessage_id();
  }

  @Transactional
  @Override
  public int delete(long message_id) throws Exception {
    if(messageConsumeUnqService.deleteById(message_id) != 1){
      Utils.throwsBizException("删除消息消费记录失败，消息ID:"+message_id);
    }

    return 1;
  }

  @Override
  public boolean checkExisted(long message_id) throws Exception {
    return messageConsumeUnqService.selectById(message_id, Cluster.master) == null ? false : true;
  }
}
