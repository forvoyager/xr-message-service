package com.xr.message.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.controller.IMessageConsumerController;
import com.xr.message.common.model.MessageConsumerModel;
import com.xr.message.service.IMessageConsumerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息消费者 HTTP服务 <br>
 */
@RestController
public class MessageConsumerController implements IMessageConsumerController {

  @Resource
  private IMessageConsumerService messageConsumerService;

  @Override
  public ResultDto<MessageConsumerModel> insert(@RequestBody MessageConsumerModel entity) throws Exception {
    return ResultDto.successData(messageConsumerService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<MessageConsumerModel> entityList) throws Exception {
    return ResultDto.successData(messageConsumerService.insertBatch(entityList));
  }

  @Override
  public ResultDto<MessageConsumerModel> insertOrUpdate(@RequestBody MessageConsumerModel entity) throws Exception {
    return ResultDto.successData(messageConsumerService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception {
    return ResultDto.successData(messageConsumerService.deleteById(id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageConsumerService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody MessageConsumerModel entity) throws Exception {
    return ResultDto.successData(messageConsumerService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageConsumerService.updateByMap(condition));
  }

  @Override
  public ResultDto<MessageConsumerModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectById(id, master));
  }

  @Override
  public ResultDto<List<MessageConsumerModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<MessageConsumerModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectList(condition, master));
  }

  @Override
  public ResultDto<MessageConsumerModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, MessageConsumerModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<MessageConsumerModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerService.selectPage(page, size, condition, master));
  }

}
