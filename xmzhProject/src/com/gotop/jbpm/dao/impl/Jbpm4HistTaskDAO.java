package com.gotop.jbpm.dao.impl;

import com.gotop.jbpm.dao.IJbpm4HistTaskDAO;
import com.gotop.jbpm.model.Jbpm4HistTask;
import com.gotop.jbpm.model.Jbpm4HistTaskExample;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class Jbpm4HistTaskDAO extends SqlMapClientDao implements IJbpm4HistTaskDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(Jbpm4HistTaskDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table JBPM4_HIST_TASK
     *
     * @abatorgenerated 
     */
    public Jbpm4HistTaskDAO() {
        super();
    }

    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    public void insert(Jbpm4HistTask record) {
        getSqlMapClientTemplate().insert("JBPM4_HIST_TASK_SqlMap.abatorgenerated_insert", record);
    }

    /**
     * 通过主键更新一条全部字段内容
     * @abatorgenerated
     */
    public int updateByPrimaryKey(Jbpm4HistTask record) {
        int rows = getSqlMapClientTemplate().update("JBPM4_HIST_TASK_SqlMap.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
     * @abatorgenerated
     */
    public int updateByPrimaryKeySelective(Jbpm4HistTask record) {
        int rows = getSqlMapClientTemplate().update("JBPM4_HIST_TASK_SqlMap.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    public List selectByExample(Jbpm4HistTaskExample example) {
        List list = queryForList("JBPM4_HIST_TASK_SqlMap.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByMapAndPage(HashMap example) {
        List list = queryForList("JBPM4_HIST_TASK_SqlMap.abatorgenerated_selectByMapAndPage", example);
        return list;
    }

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByExampleAndPage(Jbpm4HistTask record, Jbpm4HistTaskExample example, Page page) {
         UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
         List list = queryForList("JBPM4_HIST_TASK_SqlMap.abatorgenerated_selectByExampleAndPage",parms,page);
        return list;
    }

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    public Jbpm4HistTask expandEntityByTemplate(Jbpm4HistTask example) {
        Jbpm4HistTask result = (Jbpm4HistTask)queryForObject("JBPM4_HIST_TASK_SqlMap.abatorgenerated_expandEntityByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    public List queryEntitiesByTemplate(Jbpm4HistTask example) {
        List<Jbpm4HistTask> result = (List<Jbpm4HistTask>)queryForList("JBPM4_HIST_TASK_SqlMap.abatorgenerated_queryEntitiesByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    public List queryEntitiesByTemplateWithPage(Jbpm4HistTask example, Page page) {
        List<Jbpm4HistTask> result = (List<Jbpm4HistTask>)queryForList("JBPM4_HIST_TASK_SqlMap.abatorgenerated_queryEntitiesByTemplate", example,page);
        return result;
    }

    /**
     * 通过主键查询一条记录
     * @abatorgenerated
     */
    public Jbpm4HistTask selectByPrimaryKey(BigDecimal dbid) {
        Jbpm4HistTask key = new Jbpm4HistTask();
        key.setDbid(dbid);
        Jbpm4HistTask record = (Jbpm4HistTask) queryForObject("JBPM4_HIST_TASK_SqlMap.abatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    public int deleteByExample(Jbpm4HistTaskExample example) {
        int rows = getSqlMapClientTemplate().delete("JBPM4_HIST_TASK_SqlMap.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    public int deleteByTemplate(Jbpm4HistTask example) {
        int rows = getSqlMapClientTemplate().delete("JBPM4_HIST_TASK_SqlMap.abatorgenerated_deleteByTemplate", example);
        return rows;
    }

    /**
     * 通过主键删除一条记录
     * @abatorgenerated
     */
    public int deleteByPrimaryKey(BigDecimal dbid) {
        Jbpm4HistTask key = new Jbpm4HistTask();
        key.setDbid(dbid);
        int rows = getSqlMapClientTemplate().delete("JBPM4_HIST_TASK_SqlMap.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    public int countByExample(Jbpm4HistTaskExample example) {
        Integer count = (Integer)  queryForObject("JBPM4_HIST_TASK_SqlMap.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    public int countByTemplate(Jbpm4HistTask example) {
        Integer rows = (Integer)queryForObject("JBPM4_HIST_TASK_SqlMap.abatorgenerated_countByTemplate", example);
        return rows.intValue();
    }

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    public int updateByExampleSelective(Jbpm4HistTask record, Jbpm4HistTaskExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("JBPM4_HIST_TASK_SqlMap.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    public int updateByExample(Jbpm4HistTask record, Jbpm4HistTaskExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("JBPM4_HIST_TASK_SqlMap.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    public int updateEntityByTemplate(Jbpm4HistTask record, Jbpm4HistTask example) {
        HashMap<String,Jbpm4HistTask> params = new HashMap<String,Jbpm4HistTask>();
        params.put("record", record);
        params.put("template", example);
        int rows = getSqlMapClientTemplate().update("JBPM4_HIST_TASK_SqlMap.abatorgenerated_updateEntityByTemplate", params);
        return rows;
    }

    /**
     * 分页查询信息
     * @abatorgenerated
     */
    public List selectByDynamic(HashMap map, Page page) throws Exception {
        List list = queryForList("JBPM4_HIST_TASK_SqlMap.abatorgenerated_selectByDynamic", map, page);
        return list;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table JBPM4_HIST_TASK
     *
     * @abatorgenerated 
     */
    private static class UpdateByExampleParms extends Jbpm4HistTaskExample {
        private Object record;

        public UpdateByExampleParms(Object record, Jbpm4HistTaskExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}