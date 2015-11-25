package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModel;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.model.TGeneralprocessMainExample;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessMainDAO {
    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    void insert(TGeneralprocessMain record);

    /**
     * 通过主键更新一条全部字段内容
     * @abatorgenerated
     */
    int updateByPrimaryKey(TGeneralprocessMain record);

    /**
     * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
     * @abatorgenerated
     */
    int updateByPrimaryKeySelective(TGeneralprocessMain record);

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    List selectByExample(TGeneralprocessMainExample example);

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    List selectByMapAndPage(HashMap example);

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    List selectByExampleAndPage(TGeneralprocessMain record, TGeneralprocessMainExample example, Page page);

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    TGeneralprocessMain expandEntityByTemplate(TGeneralprocessMain example);

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    List queryEntitiesByTemplate(TGeneralprocessMain example);

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    List queryEntitiesByTemplateWithPage(TGeneralprocessMain example, Page page);

    /**
     * 通过主键查询一条记录
     * @abatorgenerated
     */
    TGeneralprocessMain selectByPrimaryKey(BigDecimal mainid);

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    int deleteByExample(TGeneralprocessMainExample example);

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    int deleteByTemplate(TGeneralprocessMain example);

    /**
     * 通过主键删除一条记录
     * @abatorgenerated
     */
    int deleteByPrimaryKey(BigDecimal mainid);

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    int countByExample(TGeneralprocessMainExample example);

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    int countByTemplate(TGeneralprocessMain example);

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    int updateByExampleSelective(TGeneralprocessMain record, TGeneralprocessMainExample example);

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    int updateByExample(TGeneralprocessMain record, TGeneralprocessMainExample example);

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    int updateEntityByTemplate(TGeneralprocessMain record, TGeneralprocessMain example);

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

    /**
     * 根据流程id和模版id生成模式主表记录
     * @param taskAssgineeDto
     */
	void addGeneralProcessMain(TaskAssgineeDto taskAssgineeDto,ProcessModel pm,Class<?> c);

	/**
     * 根据流程实例id获取流程主表对象
     * @param businessId
     * @return
     */
	TGeneralprocessMain queryMainByBusinessId(String businessId);

	/**
	 * 根据流程实例id和模版id更新模式主表记录
	 * @param taskAssgineeDto
	 * @param modelTwo
	 * @param class1
	 */
	void uptGeneralProcessMain(TaskAssgineeDto taskAssgineeDto,
			ProcessModel pm,TGeneralprocessMain main, Class<?> c);
}