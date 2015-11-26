package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessModeltwo;
import com.gotop.Generalprocess.model.TGeneralprocessModeltwoExample;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModeltwoDAO {
    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    void insert(TGeneralprocessModeltwo record);

    /**
     * 通过主键更新一条全部字段内容
     * @abatorgenerated
     */
    int updateByPrimaryKey(TGeneralprocessModeltwo record);

    /**
     * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
     * @abatorgenerated
     */
    int updateByPrimaryKeySelective(TGeneralprocessModeltwo record);

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    List selectByExample(TGeneralprocessModeltwoExample example);

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    List selectByMapAndPage(HashMap example);

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    List selectByExampleAndPage(TGeneralprocessModeltwo record, TGeneralprocessModeltwoExample example, Page page);

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    TGeneralprocessModeltwo expandEntityByTemplate(TGeneralprocessModeltwo example);

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    List queryEntitiesByTemplate(TGeneralprocessModeltwo example);

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    List queryEntitiesByTemplateWithPage(TGeneralprocessModeltwo example, Page page);

    /**
     * 通过主键查询一条记录
     * @abatorgenerated
     */
    TGeneralprocessModeltwo selectByPrimaryKey(BigDecimal processmodelid);

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    int deleteByExample(TGeneralprocessModeltwoExample example);

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    int deleteByTemplate(TGeneralprocessModeltwo example);

    /**
     * 通过主键删除一条记录
     * @abatorgenerated
     */
    int deleteByPrimaryKey(BigDecimal processmodelid);

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    int countByExample(TGeneralprocessModeltwoExample example);

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    int countByTemplate(TGeneralprocessModeltwo example);

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    int updateByExampleSelective(TGeneralprocessModeltwo record, TGeneralprocessModeltwoExample example);

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    int updateByExample(TGeneralprocessModeltwo record, TGeneralprocessModeltwoExample example);

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    int updateEntityByTemplate(TGeneralprocessModeltwo record, TGeneralprocessModeltwo example);

    /**
     * 分页查询信息
     * @abatorgenerated
     */
    List selectByDynamic(HashMap map, Page page) throws Exception;

    /**
     * 批量提交开始
     * @abatorgenerated
     */
    void startBatch() throws Exception;

    /**
     * 批量提交
     * @abatorgenerated
     */
    void executeBatch() throws Exception;

	ProcessModelTwo queryModelTwoById(String processModelId);

	void addModelTwo(ProcessModelTwo modelTwo);

	ProcessModelTwo queryModelTwo(HashMap<String, Object> map);

	void uptModelTwo(ProcessModelTwo modelTwo);
}