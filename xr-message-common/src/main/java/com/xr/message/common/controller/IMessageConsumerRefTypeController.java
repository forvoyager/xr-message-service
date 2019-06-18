package com.xr.message.common.controller;

import com.xr.message.base.dto.ResultDto;
import com.xr.message.base.enums.Cluster;
import com.xr.message.base.page.PageData;
import com.xr.message.common.model.MessageConsumerRefTypeModel;
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
 * <b>description</b>: 消费者与消息类型关联关系 HTTP接口 <br>
 */
public interface IMessageConsumerRefTypeController {

  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return MessageConsumerRefTypeModel 插入成功的对象
   */
  @RequestMapping("/messageConsumerRefType/insert")
  ResultDto<MessageConsumerRefTypeModel> insert(@RequestBody MessageConsumerRefTypeModel entity) throws Exception;

  /**
   * <p>
   * 插入（批量）
   * </p>
   *
   * @param entityList 对象列表
   * @return Integer 插入成功的记录数
   */
  @RequestMapping("/messageConsumerRefType/insert/batch")
  ResultDto<Integer> insertBatch(@RequestBody List<MessageConsumerRefTypeModel> entityList) throws Exception;

  /**
   * <p>
   * 存在则更新，否则插入
   * </p>
   *
   * @param entity 实体对象
   * @return MessageConsumerRefTypeModel 插入/更新成功的对象
   */
  @RequestMapping("/messageConsumerRefType/insert/update")
  ResultDto<MessageConsumerRefTypeModel> insertOrUpdate(@RequestBody MessageConsumerRefTypeModel entity) throws Exception;

  /**
   * <p>
   * 根据 主键ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return Integer 删除的行数
   */
  @RequestMapping("/messageConsumerRefType/delete/{id}")
  ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，删除记录
   * </p>
   *
   * @param condition 删除条件
   * @return Integer 删除的行数
   */
  @RequestMapping("/messageConsumerRefType/delete")
  ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception;

  /**
   * <p>
   * 根据 model 修改数据
   * </p>
   *
   * @param entity 实体对象
   * @return MessageConsumerRefTypeModel 更新的行数
   */
  @RequestMapping("/messageConsumerRefType/update/model")
  ResultDto<Long> update(@RequestBody MessageConsumerRefTypeModel entity) throws Exception;

  /**
   * <p>
   * 根据map条件 修改
   * </p>
   *
   * @param columnMap 更新数据/更新条件
   * @return Integer 更新的行数
   */
  @RequestMapping("/messageConsumerRefType/update/map")
  ResultDto<Long> updateByMap(@RequestBody Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 根据 主键ID 查询
   * </p>
   *
   * @param id 主键ID
   * @param master 主节点 or 从节点
   * @return MessageConsumerRefTypeModel
   */
  @RequestMapping("/messageConsumerRefType/select/{master}/{id}")
  ResultDto<MessageConsumerRefTypeModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 ID 批量查询
   * </p>
   *
   * @param idList 主键ID列表
   * @param master 主节点 or 从节点
   * @return List<MessageConsumerRefTypeModel> 列表
   */
  @RequestMapping("/messageConsumerRefType/select/{master}/batch")
  ResultDto<List<MessageConsumerRefTypeModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 查询（根据 condition 条件）
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return List<MessageConsumerRefTypeModel> 列表
   */
  @RequestMapping("/messageConsumerRefType/select/{master}/list")
  ResultDto<List<MessageConsumerRefTypeModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询一条记录
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return MessageConsumerRefTypeModel
   */
  @RequestMapping("/messageConsumerRefType/select/{master}/one")
  ResultDto<MessageConsumerRefTypeModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询并转换成map
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return Map<主键, MessageConsumerRefTypeModel>
   */
  @RequestMapping("/messageConsumerRefType/select/{master}/map")
  ResultDto<Map<Integer, MessageConsumerRefTypeModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询总记录数
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return long 记录数
   */
  @RequestMapping("/messageConsumerRefType/select/{master}/count")
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
  @RequestMapping("/messageConsumerRefType/select/{master}/page/{page}/{size}")
  ResultDto<PageData<MessageConsumerRefTypeModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

}
