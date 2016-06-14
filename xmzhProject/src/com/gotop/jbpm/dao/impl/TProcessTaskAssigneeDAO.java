package com.gotop.jbpm.dao.impl;

import com.gotop.jbpm.dao.ITProcessTaskAssigneeDAO;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.model.TProcessBusiness;
import com.gotop.jbpm.model.TProcessConfig;
import com.gotop.jbpm.model.TProcessTaskAssignee;
import com.gotop.jbpm.model.TProcessTaskAssigneeExample;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TProcessTaskAssigneeDAO extends SqlMapClientDao implements ITProcessTaskAssigneeDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TProcessTaskAssigneeDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table T_PROCESS_TASK_ASSIGNEE
     *
     * @abatorgenerated 
     */
    public TProcessTaskAssigneeDAO() {
        super();
    }

    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    public Long insert(TProcessTaskAssignee record) {
    	 Long id = (Long)getSqlMapClientTemplate().insert("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_insert", record);
    	 return id;
    }

    /**
     * 通过主键更新一条全部字段内容
     * @abatorgenerated
     */
    public int updateByPrimaryKey(TProcessTaskAssignee record) {
        int rows = getSqlMapClientTemplate().update("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
     * @abatorgenerated
     */
    public int updateByPrimaryKeySelective(TProcessTaskAssignee record) {
        int rows = getSqlMapClientTemplate().update("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    public List selectByExample(TProcessTaskAssigneeExample example) {
        List list = queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByMapAndPage(HashMap example) {
        List list = queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_selectByMapAndPage", example);
        return list;
    }

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByExampleAndPage(TProcessTaskAssignee record, TProcessTaskAssigneeExample example, Page page) {
         UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
         List list = queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_selectByExampleAndPage",parms,page);
        return list;
    }

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    public TProcessTaskAssignee expandEntityByTemplate(TProcessTaskAssignee example) {
        TProcessTaskAssignee result = (TProcessTaskAssignee)queryForObject("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_expandEntityByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    public List queryEntitiesByTemplate(TProcessTaskAssignee example) {
        List<TProcessTaskAssignee> result = (List<TProcessTaskAssignee>)queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_queryEntitiesByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    public List queryEntitiesByTemplateWithPage(TProcessTaskAssignee example, Page page) {
        List<TProcessTaskAssignee> result = (List<TProcessTaskAssignee>)queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_queryEntitiesByTemplate", example,page);
        return result;
    }

    /**
     * 通过主键查询一条记录
     * @abatorgenerated
     */
    public TProcessTaskAssignee selectByPrimaryKey(Long id) {
        TProcessTaskAssignee key = new TProcessTaskAssignee();
        key.setId(id);
        TProcessTaskAssignee record = (TProcessTaskAssignee) queryForObject("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    public int deleteByExample(TProcessTaskAssigneeExample example) {
        int rows = getSqlMapClientTemplate().delete("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    public int deleteByTemplate(TProcessTaskAssignee example) {
        int rows = getSqlMapClientTemplate().delete("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_deleteByTemplate", example);
        return rows;
    }

    /**
     * 通过主键删除一条记录
     * @abatorgenerated
     */
    public int deleteByPrimaryKey(Long id) {
        TProcessTaskAssignee key = new TProcessTaskAssignee();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    public int countByExample(TProcessTaskAssigneeExample example) {
        Integer count = (Integer)  queryForObject("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    public int countByTemplate(TProcessTaskAssignee example) {
        Integer rows = (Integer)queryForObject("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_countByTemplate", example);
        return rows.intValue();
    }

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    public int updateByExampleSelective(TProcessTaskAssignee record, TProcessTaskAssigneeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    public int updateByExample(TProcessTaskAssignee record, TProcessTaskAssigneeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    public int updateEntityByTemplate(TProcessTaskAssignee record, TProcessTaskAssignee example) {
        HashMap<String,TProcessTaskAssignee> params = new HashMap<String,TProcessTaskAssignee>();
        params.put("record", record);
        params.put("template", example);
        int rows = getSqlMapClientTemplate().update("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_updateEntityByTemplate", params);
        return rows;
    }

    /**
     * 分页查询信息
     * @abatorgenerated
     */
    public List selectByDynamic(HashMap map, Page page) throws Exception {
        List list = queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.abatorgenerated_selectByDynamic", map, page);
        return list;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table T_PROCESS_TASK_ASSIGNEE
     *
     * @abatorgenerated 
     */
    private static class UpdateByExampleParms extends TProcessTaskAssigneeExample {
        private Object record;

        public UpdateByExampleParms(Object record, TProcessTaskAssigneeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public List<TProcessTaskAssignee> queryMyToDoTasksList(Map<String, Object> map,Page page) {
		 List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryMyToDoTasksList", map,page);
		return tProcessTaskAssignees;
	}

	@Override
	public List<TProcessTaskAssignee> queryMyCompletedTasksList(
			Map<String, Object> map, Page page) {
		 List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryMyCompletedTasksList", map,page);
			return tProcessTaskAssignees;
	}

	@Override
	public List<TProcessTaskAssignee> queryMyDraftsList(
			Map<String, Object> map, Page page) {
		 List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryMyDraftsList", map,page);
			return tProcessTaskAssignees;
	}

	@Override
	public List<TProcessTaskAssignee> querySuperviseList(
			Map<String, Object> map, Page page) {
		List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.querySuperviseList", map,page);
		return tProcessTaskAssignees;
	}
	
	@Override
	public List<TProcessTaskAssignee> myStartProcessList(Map<String, Object> map,
			Page page) {
		List list = queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.myStartProcessList", map,page);
		return list;
	}
    /**
     * 
     *
     * 首页督办提醒,点击更多时使用,更多时,显示字段不一样,需要关联更多的表,为了效率,单独现在写一个过程
     *
     * @param map,包括empid,orgcode
     * @param posicode
     * @param taskAssignee
     * @param page
     * @return
     *
     * <pre>
     * 修改日期        修改人    修改原因
     * 2014-9-11    黄开忠    新建
     * </pre>
     */
     public  List<TProcessTaskAssignee> querySuperviseRemMore(Map<String, Object> map,Page page) throws Exception{
         List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.querySuperviseRemMore", map,page);
         return tProcessTaskAssignees;
       }

	@Override
	public List<TProcessTaskAssignee> downexl(Map<String, Object> map)
			throws Exception {
		List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.downexl", map);
		return tProcessTaskAssignees;
	}

	@Override
	public List<TProcessTaskAssignee> selectByTaskExeConfigId(
			Map<String, Object> map) {
		List<TProcessTaskAssignee> tProcessTaskAssignees = this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.selectByTaskExeConfigId", map);
		return tProcessTaskAssignees;
	}

	@Override
	public List queryTaskAssginee(TaskAssgineeDto taskAssgineeDto) {
		
		List list =this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryTaskAssginee", taskAssgineeDto);
		return list;
	}
	
	@Override
	public List queryJBPM4Task(TaskAssgineeDto taskAssgineeDto) {
		
		List list =this.queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryJBPM4Task", taskAssgineeDto);
		return list;
	}
	
	@Override
	public List queryDefinitionId(String executionId) {
		
		List list =  queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryDefinitionId", executionId);
		return list;
	}

	@Override
	public List queryTaskAssigneeId(Long id) {
		
		List list =  queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryTaskAssigneeId", id);
		return list;
	}

	@Override
	public void updateTaskAssigneePerson(Map<String, Object> map) {
		
		getSqlMapClientTemplate().update("T_PROCESS_TASK_ASSIGNEE_SqlMap.updateTaskAssigneePerson", map);
	}

	@Override
	public List getEmpnameByEmpId(Long empid) {
		
		List list =  queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.getEmpnameByEmpId", empid);
		return list;
	}

	@Override
	public List queryEmpInfo() {
		
		List list =  queryForList("T_PROCESS_TASK_ASSIGNEE_SqlMap.queryEmpInfo", null);
		return list;
	}


}