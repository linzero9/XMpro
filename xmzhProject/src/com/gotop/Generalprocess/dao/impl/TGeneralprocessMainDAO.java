package com.gotop.Generalprocess.dao.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.model.ProcessModel;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.model.TGeneralprocessMainExample;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TGeneralprocessMainDAO extends SqlMapClientDao implements ITGeneralprocessMainDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessMainDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table T_GENERALPROCESS_MAIN
     *
     * @abatorgenerated 
     */
    public TGeneralprocessMainDAO() {
        super();
    }

    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    public void insert(TGeneralprocessMain record) {
        getSqlMapClientTemplate().insert("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_insert", record);
    }

    /**
     * 通过主键更新一条全部字段内容
     * @abatorgenerated
     */
    public int updateByPrimaryKey(TGeneralprocessMain record) {
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
     * @abatorgenerated
     */
    public int updateByPrimaryKeySelective(TGeneralprocessMain record) {
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    public List selectByExample(TGeneralprocessMainExample example) {
        List list = queryForList("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByMapAndPage(HashMap example) {
        List list = queryForList("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_selectByMapAndPage", example);
        return list;
    }

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByExampleAndPage(TGeneralprocessMain record, TGeneralprocessMainExample example, Page page) {
         UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
         List list = queryForList("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_selectByExampleAndPage",parms,page);
        return list;
    }

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    public TGeneralprocessMain expandEntityByTemplate(TGeneralprocessMain example) {
        TGeneralprocessMain result = (TGeneralprocessMain)queryForObject("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_expandEntityByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    public List queryEntitiesByTemplate(TGeneralprocessMain example) {
        List<TGeneralprocessMain> result = (List<TGeneralprocessMain>)queryForList("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_queryEntitiesByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    public List queryEntitiesByTemplateWithPage(TGeneralprocessMain example, Page page) {
        List<TGeneralprocessMain> result = (List<TGeneralprocessMain>)queryForList("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_queryEntitiesByTemplate", example,page);
        return result;
    }

    /**
     * 通过主键查询一条记录
     * @abatorgenerated
     */
    public TGeneralprocessMain selectByPrimaryKey(BigDecimal mainid) {
        return null;
    }

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    public int deleteByExample(TGeneralprocessMainExample example) {
        int rows = getSqlMapClientTemplate().delete("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    public int deleteByTemplate(TGeneralprocessMain example) {
        int rows = getSqlMapClientTemplate().delete("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_deleteByTemplate", example);
        return rows;
    }

    /**
     * 通过主键删除一条记录
     * @abatorgenerated
     */
    public int deleteByPrimaryKey(BigDecimal mainid) {
        return 1;
    }

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    public int countByExample(TGeneralprocessMainExample example) {
        Integer count = (Integer)  queryForObject("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    public int countByTemplate(TGeneralprocessMain example) {
        Integer rows = (Integer)queryForObject("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_countByTemplate", example);
        return rows.intValue();
    }

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    public int updateByExampleSelective(TGeneralprocessMain record, TGeneralprocessMainExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    public int updateByExample(TGeneralprocessMain record, TGeneralprocessMainExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    public int updateEntityByTemplate(TGeneralprocessMain record, TGeneralprocessMain example) {
        HashMap<String,TGeneralprocessMain> params = new HashMap<String,TGeneralprocessMain>();
        params.put("record", record);
        params.put("template", example);
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_updateEntityByTemplate", params);
        return rows;
    }

    /**
     * 分页查询信息
     * @abatorgenerated
     */
    public List selectByDynamic(HashMap map, Page page) throws Exception {
        List list = queryForList("T_GENERALPROCESS_MAIN_SqlMap.abatorgenerated_selectByDynamic", map, page);
        return list;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table T_GENERALPROCESS_MAIN
     *
     * @abatorgenerated 
     */
    private static class UpdateByExampleParms extends TGeneralprocessMainExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGeneralprocessMainExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public void addGeneralProcessMain(TaskAssgineeDto taskAssgineeDto,ProcessModel pm,Class<?> c) {
		TGeneralprocessMain main = new TGeneralprocessMain();
		main.setBusinessId(taskAssgineeDto.getExecutionId());
		main.setTemplateId(taskAssgineeDto.getDefinitionId());
		if("com.gotop.Generalprocess.model.ProcessModelOne".equals(c.getName())){
			//模式一
			main.setRules("ProcessModelOne");
		}
		if("com.gotop.Generalprocess.model.ProcessModelTwo".equals(c.getName())){
			//模式二
			main.setRules("ProcessModelTwo");
		}
		if("com.gotop.Generalprocess.model.ProcessModelThree".equals(c.getName())){
			//模式三
			main.setRules("ProcessModelThree");
		}
		if("com.gotop.Generalprocess.model.ProcessModelFour".equals(c.getName())){
			//模式四
			main.setRules("ProcessModelFour");
		}
		if("com.gotop.Generalprocess.model.ProcessModelFive".equals(c.getName())){
			//模式五
			main.setRules("ProcessModelFive");
		}

		if("com.gotop.Generalprocess.model.ProcessModelSix".equals(c.getName())){
			//模式六
			main.setRules("ProcessModelSix");
		}
		if("com.gotop.Generalprocess.model.ProcessModelEight".equals(c.getName())){
			//模式八
			main.setRules("ProcessModelEight");

		}
		main.setIds(String.valueOf(pm.getProcessModelId()));
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MAIN_SqlMap.addGeneralProcessMain", main);
	}

	@Override
	public TGeneralprocessMain queryMainByBusinessId(String businessId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("businessId", businessId);
		return (TGeneralprocessMain) queryForObject("T_GENERALPROCESS_MAIN_SqlMap.queryMainByBusinessId", map);
	}

	@Override
	public void uptGeneralProcessMain(TaskAssgineeDto taskAssgineeDto,
			ProcessModel pm, TGeneralprocessMain main,Class<?> c) {
		//规则更新
		String rules = main.getRules();
		if (rules != null) {
			if ("com.gotop.Generalprocess.model.ProcessModelOne".equals(c.getName())) {
				// 模式一
				rules += "," + "ProcessModelOne";
			}
			if ("com.gotop.Generalprocess.model.ProcessModelTwo".equals(c.getName())) {
				// 模式二
				rules += "," + "ProcessModelTwo";
			}
			if ("com.gotop.Generalprocess.model.ProcessModelThree".equals(c.getName())) {
				// 模式三
				rules += "," + "ProcessModelThree";
			}
			if ("com.gotop.Generalprocess.model.ProcessModelFour".equals(c.getName())) {
				// 模式四
				rules += "," + "ProcessModelFour";
			}
			if ("com.gotop.Generalprocess.model.ProcessModelFive".equals(c.getName())) {
				// 模式五
				rules += "," + "ProcessModelFive";
			}

			if ("com.gotop.Generalprocess.model.ProcessModelSix".equals(c.getName())) {
				// 模式六
				rules += "," + "ProcessModelSix";
			}
			
			

			if("com.gotop.Generalprocess.model.ProcessModelEight".equals(c.getName())){
				//模式八
				rules += "," + "ProcessModelEight";
			}

		}
		
		//主键更新
		String ids = main.getIds();
		if(ids != null){
			ids += "," + String.valueOf(pm.getProcessModelId());
		}
		main.setRules(rules);
		main.setIds(ids);
		getSqlMapClientTemplate().update("T_GENERALPROCESS_MAIN_SqlMap.uptGeneralProcessMain", main);
	}
}