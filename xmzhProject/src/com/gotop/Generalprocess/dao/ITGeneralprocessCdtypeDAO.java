package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.TGeneralprocessCdtype;
import com.gotop.Generalprocess.model.TGeneralprocessCdtypeExample;
import com.primeton.utils.Page;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessCdtypeDAO {
    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    void insert(TGeneralprocessCdtype record);

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    List selectByExample(TGeneralprocessCdtypeExample example);

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    List selectByMapAndPage(HashMap example);

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    List selectByExampleAndPage(TGeneralprocessCdtype record, TGeneralprocessCdtypeExample example, Page page);

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    TGeneralprocessCdtype expandEntityByTemplate(TGeneralprocessCdtype example);

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    List queryEntitiesByTemplate(TGeneralprocessCdtype example);

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    List queryEntitiesByTemplateWithPage(TGeneralprocessCdtype example, Page page);

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    int deleteByExample(TGeneralprocessCdtypeExample example);

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    int deleteByTemplate(TGeneralprocessCdtype example);

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    int countByExample(TGeneralprocessCdtypeExample example);

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    int countByTemplate(TGeneralprocessCdtype example);

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    int updateByExampleSelective(TGeneralprocessCdtype record, TGeneralprocessCdtypeExample example);

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    int updateByExample(TGeneralprocessCdtype record, TGeneralprocessCdtypeExample example);

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    int updateEntityByTemplate(TGeneralprocessCdtype record, TGeneralprocessCdtype example);

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

	List<TGeneralprocessCdtype> queryPageCdtype(TGeneralprocessCdtype cdtype, Page page);

	List<TGeneralprocessCdtype> querycreditType(TGeneralprocessCdtype cdtype);
}