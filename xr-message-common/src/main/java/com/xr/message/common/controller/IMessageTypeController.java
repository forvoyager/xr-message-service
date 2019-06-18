package com.xr.message.common.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.model.MessageTypeModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-06-18 08:05:38 <br>
 * <b>description</b>: 消息类型 HTTP接口 <br>
 */
public interface IMessageTypeController {

  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return MessageTypeModel 插入成功的对象
   */
  @RequestMapping("/messageType/insert")
  ResultDto<MessageTypeModel> insert(@RequestBody MessageTypeModel entity) throws Exception;

  /**
   * <p>
   * 插入（批量）
   * </p>
   *
   * @param entityList 对象列表
   * @return Integer 插入成功的记录数
   */
  @RequestMapping("/messageType/insert/batch")
  ResultDto<Integer> insertBatch(@RequestBody List<MessageTypeModel> entityList) throws Exception;

  /**
   * <p>
   * 存在则更新，否则插入
   * </p>
   *
   * @param entity 实体对象
   * @return MessageTypeModel 插入/更新成功的对象
   */
  @RequestMapping("/messageType/insert/update")
  ResultDto<MessageTypeModel> insertOrUpdate(@RequestBody MessageTypeModel entity) throws Exception;

  /**
   * <p>
   * 根据 主键ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return Integer 删除的行数
   */
  @RequestMapping("/messageType/delete/{id}")
  ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，删除记录
   * </p>
   *
   * @param condition 删除条件
   * @return Integer 删除的行数
   */
  @RequestMapping("/messageType/delete")
  ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception;

  /**
   * <p>
   * 根据 model 修改数据
   * </p>
   *
   * @param entity 实体对象
   * @return MessageTypeModel 更新的行数
   */
  @RequestMapping("/messageType/update/model")
  ResultDto<Long> update(@RequestBody MessageTypeModel entity) throws Exception;

  /**
   * <p>
   * 根据map条件 修改
   * </p>
   *
   * @param columnMap 更新数据/更新条件
   * @return Integer 更新的行数
   */
  @RequestMapping("/messageType/update/map")
  ResultDto<Long> updateByMap(@RequestBody Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 根据 主键ID 查询
   * </p>
   *
   * @param id 主键ID
   * @param master 主节点 or 从节点
   * @return MessageTypeModel
   */
  @RequestMapping("/messageType/select/{master}/{id}")
  ResultDto<MessageTypeModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 ID 批量查询
   * </p>
   *
   * @param idList 主键ID列表
   * @param master 主节点 or 从节点
   * @return List<MessageTypeModel> 列表
   */
  @RequestMapping("/messageType/select/{master}/batch")
  ResultDto<List<MessageTypeModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 查询（根据 condition 条件）
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return List<MessageTypeModel> 列表
   */
  @RequestMapping("/messageType/select/{master}/list")
  ResultDto<List<MessageTypeModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询一条记录
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return MessageTypeModel
   */
  @RequestMapping("/messageType/select/{master}/one")
  ResultDto<MessageTypeModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询并转换成map
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return Map<主键, MessageTypeModel>
   */
  @RequestMapping("/messageType/select/{master}/map")
  ResultDto<Map<Integer, MessageTypeModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询总记录数
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return long 记录数
   */
  @RequestMapping("/messageType/select/{master}/count")
  ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 翻页查询
   * </p>
   *
   * @param page 第几页
   * @param size 每页记录数
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return
   */
  @RequestMapping("/messageType/select/{master}/page/{page}/{size}")
  ResultDto<PageData<MessageTypeModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

}
