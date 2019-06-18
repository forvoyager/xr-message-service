package com.xr.message.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.controller.IMessageContentController;
import com.xr.message.common.model.MessageContentModel;
import com.xr.message.service.IMessageContentService;
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
 * <b>description</b>: 消息内容表 HTTP服务 <br>
 */
@RestController
public class MessageContentController implements IMessageContentController {

  @Resource
  private IMessageContentService messageContentService;

  @Override
  public ResultDto<MessageContentModel> insert(@RequestBody MessageContentModel entity) throws Exception {
    return ResultDto.successData(messageContentService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<MessageContentModel> entityList) throws Exception {
    return ResultDto.successData(messageContentService.insertBatch(entityList));
  }

  @Override
  public ResultDto<MessageContentModel> insertOrUpdate(@RequestBody MessageContentModel entity) throws Exception {
    return ResultDto.successData(messageContentService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("msg_id") long msg_id) throws Exception {
    return ResultDto.successData(messageContentService.deleteById(msg_id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageContentService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody MessageContentModel entity) throws Exception {
    return ResultDto.successData(messageContentService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(messageContentService.updateByMap(condition));
  }

  @Override
  public ResultDto<MessageContentModel> selectById(@PathVariable("msg_id") long msg_id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectById(msg_id, master));
  }

  @Override
  public ResultDto<List<MessageContentModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<MessageContentModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectList(condition, master));
  }

  @Override
  public ResultDto<MessageContentModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Long, MessageContentModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<MessageContentModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(messageContentService.selectPage(page, size, condition, master));
  }

}
