package com.xr.message.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.controller.IMessageConsumerRefTypeController;
import com.xr.message.common.model.MessageConsumerRefTypeModel;
import com.xr.message.service.IMessageConsumerRefTypeService;
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
 * <b>description</b>: 消费者与消息类型关联关系 HTTP服务 <br>
 */
@RestController
public class MessageConsumerRefTypeController implements IMessageConsumerRefTypeController {

  @Resource
  private IMessageConsumerRefTypeService messageConsumerRefTypeService;

  @Override
  public ResultDto<MessageConsumerRefTypeModel> insert(@RequestBody MessageConsumerRefTypeModel entity) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<MessageConsumerRefTypeModel> entityList) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.insertBatch(entityList));
  }

  @Override
  public ResultDto<MessageConsumerRefTypeModel> insertOrUpdate(@RequestBody MessageConsumerRefTypeModel entity) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.deleteById(id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody MessageConsumerRefTypeModel entity) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.updateByMap(condition));
  }

  @Override
  public ResultDto<MessageConsumerRefTypeModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectById(id, master));
  }

  @Override
  public ResultDto<List<MessageConsumerRefTypeModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<MessageConsumerRefTypeModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectList(condition, master));
  }

  @Override
  public ResultDto<MessageConsumerRefTypeModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, MessageConsumerRefTypeModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<MessageConsumerRefTypeModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageConsumerRefTypeService.selectPage(page, size, condition, master));
  }

}
