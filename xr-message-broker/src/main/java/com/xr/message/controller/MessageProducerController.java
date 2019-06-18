package com.xr.message.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.controller.IMessageProducerController;
import com.xr.message.common.model.MessageProducerModel;
import com.xr.message.service.IMessageProducerService;
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
 * <b>description</b>: 消息生产者 HTTP服务 <br>
 */
@RestController
public class MessageProducerController implements IMessageProducerController {

  @Resource
  private IMessageProducerService messageProducerService;

  @Override
  public ResultDto<MessageProducerModel> insert(@RequestBody MessageProducerModel entity) throws Exception {
    return ResultDto.successData(messageProducerService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<MessageProducerModel> entityList) throws Exception {
    return ResultDto.successData(messageProducerService.insertBatch(entityList));
  }

  @Override
  public ResultDto<MessageProducerModel> insertOrUpdate(@RequestBody MessageProducerModel entity) throws Exception {
    return ResultDto.successData(messageProducerService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception {
    return ResultDto.successData(messageProducerService.deleteById(id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageProducerService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody MessageProducerModel entity) throws Exception {
    return ResultDto.successData(messageProducerService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageProducerService.updateByMap(condition));
  }

  @Override
  public ResultDto<MessageProducerModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectById(id, master));
  }

  @Override
  public ResultDto<List<MessageProducerModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<MessageProducerModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectList(condition, master));
  }

  @Override
  public ResultDto<MessageProducerModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, MessageProducerModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<MessageProducerModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageProducerService.selectPage(page, size, condition, master));
  }

}
