package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModeloneDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.model.TGeneralprocessModelone;
import com.gotop.Generalprocess.model.TGeneralprocessModeloneExample;
import com.gotop.Generalprocess.service.ITGeneralprocessModeloneService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import org.apache.log4j.Logger;

public class TGeneralprocessModeloneService implements ITGeneralprocessModeloneService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModeloneService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModeloneDAO tGeneralprocessModeloneDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModeloneDAO(ITGeneralprocessModeloneDAO tGeneralprocessModeloneDAO) throws Exception {
        this.tGeneralprocessModeloneDAO = tGeneralprocessModeloneDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModeloneDAO gettGeneralprocessModeloneDAO() throws Exception {
        return this.tGeneralprocessModeloneDAO;
    }

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TGeneralprocessModeloneExample example = new TGeneralprocessModeloneExample();
        TGeneralprocessModeloneExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TGeneralprocessModelone record = new TGeneralprocessModelone();
        List list = tGeneralprocessModeloneDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 更新单条记录，通过主键
     * @abatorgenerated
     */
    public void update(TGeneralprocessModelone obj) throws Exception {
        this.tGeneralprocessModeloneDAO.updateByPrimaryKeySelective(obj);
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TGeneralprocessModelone obj) throws Exception {
        this.tGeneralprocessModeloneDAO.insert(obj);
    }

    /**
     * 删除单条记录
     * @abatorgenerated
     */
    public void delete(TGeneralprocessModelone obj) throws Exception {
        java.math.BigDecimal key = obj.getProcessmodeloneid();
        this.tGeneralprocessModeloneDAO.deleteByPrimaryKey(key);
    }

    /**
     * 批量更新数据
     * @abatorgenerated
     */
    public void updateBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelone tObject = (TGeneralprocessModelone)abs.get(i);
            	this.update(tObject);
        }
    }

    /**
     * 批量插入数据
     * @abatorgenerated
     */
    public void insertBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelone tObject = (TGeneralprocessModelone)abs.get(i);
            	this.insert(tObject);
        }
    }

    /**
     * 批量删除数据
     * @abatorgenerated
     */
    public void deleteBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelone tObject = (TGeneralprocessModelone)abs.get(i);
            	this.delete(tObject);
        }
    }

    /**
     * datacell方式批量更新数据
     * @abatorgenerated
     */
    public void updateDataGrid(HashMap hmp) throws Exception {
        this.tGeneralprocessModeloneDAO.startBatch();
        List insertEntities = (List) hmp.get("insertEntities");
        List deleteEntities = (List) hmp.get("deleteEntities");
        List updateEntities = (List) hmp.get("updateEntities");
        this.updateBatch(updateEntities);
        this.insertBatch(insertEntities);
        this.deleteBatch(deleteEntities);
        this.tGeneralprocessModeloneDAO.executeBatch();
    }

    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List queryAllDataList(HashMap map) throws Exception {
        TGeneralprocessModeloneExample example = new TGeneralprocessModeloneExample();
        TGeneralprocessModeloneExample.Criteria criteria = example.createCriteria();
        List list = tGeneralprocessModeloneDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryPageDataList(HashMap map, Page page) throws Exception {
        List list = tGeneralprocessModeloneDAO.selectByDynamic(map,page);
        return list;
    }

	@Override
	public ProcessModelOne queryModelOneById(String processModelId) {
		return this.tGeneralprocessModeloneDAO.queryModelOneById(processModelId);
	}

	@Override
	public ProcessModelOne queryModelOne(ProcessModelOne modelOne) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelOne != null){
			if(modelOne.getFlow_Id() != null && !"".equals(modelOne.getFlow_Id())){
				map.put("flow_id", modelOne.getFlow_Id());
			}
			if(modelOne.getTaskName() != null && !"".equals(modelOne.getTaskName())){
				map.put("taskName", modelOne.getTaskName());
			}
		}
		return this.tGeneralprocessModeloneDAO.queryModelOne(map);
	}
	

	
	
	
	
}