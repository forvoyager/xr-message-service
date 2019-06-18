package com.xr.message.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.controller.IMessageInfoController;
import com.xr.message.common.model.MessageInfoModel;
import com.xr.message.service.IMessageInfoService;
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
 * <b>description</b>: 消息记录表 HTTP服务 <br>
 */
@RestController
public class MessageInfoController implements IMessageInfoController {

  @Resource
  private IMessageInfoService messageInfoService;

  @Override
  public ResultDto<MessageInfoModel> insert(@RequestBody MessageInfoModel entity) throws Exception {
    return ResultDto.successData(messageInfoService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<MessageInfoModel> entityList) throws Exception {
    return ResultDto.successData(messageInfoService.insertBatch(entityList));
  }

  @Override
  public ResultDto<MessageInfoModel> insertOrUpdate(@RequestBody MessageInfoModel entity) throws Exception {
    return ResultDto.successData(messageInfoService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception {
    return ResultDto.successData(messageInfoService.deleteById(id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageInfoService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody MessageInfoModel entity) throws Exception {
    return ResultDto.successData(messageInfoService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageInfoService.updateByMap(condition));
  }

  @Override
  public ResultDto<MessageInfoModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectById(id, master));
  }

  @Override
  public ResultDto<List<MessageInfoModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<MessageInfoModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectList(condition, master));
  }

  @Override
  public ResultDto<MessageInfoModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Long, MessageInfoModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<MessageInfoModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageInfoService.selectPage(page, size, condition, master));
  }

}
