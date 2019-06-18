package com.xr.message.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.controller.IMessageTypeController;
import com.xr.message.common.model.MessageTypeModel;
import com.xr.message.service.IMessageTypeService;
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
 * <b>description</b>: 消息类型 HTTP服务 <br>
 */
@RestController
public class MessageTypeController implements IMessageTypeController {

  @Resource
  private IMessageTypeService messageTypeService;

  @Override
  public ResultDto<MessageTypeModel> insert(@RequestBody MessageTypeModel entity) throws Exception {
    return ResultDto.successData(messageTypeService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<MessageTypeModel> entityList) throws Exception {
    return ResultDto.successData(messageTypeService.insertBatch(entityList));
  }

  @Override
  public ResultDto<MessageTypeModel> insertOrUpdate(@RequestBody MessageTypeModel entity) throws Exception {
    return ResultDto.successData(messageTypeService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception {
    return ResultDto.successData(messageTypeService.deleteById(id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageTypeService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody MessageTypeModel entity) throws Exception {
    return ResultDto.successData(messageTypeService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageTypeService.updateByMap(condition));
  }

  @Override
  public ResultDto<MessageTypeModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectById(id, master));
  }

  @Override
  public ResultDto<List<MessageTypeModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<MessageTypeModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectList(condition, master));
  }

  @Override
  public ResultDto<MessageTypeModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, MessageTypeModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<MessageTypeModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageTypeService.selectPage(page, size, condition, master));
  }

}
