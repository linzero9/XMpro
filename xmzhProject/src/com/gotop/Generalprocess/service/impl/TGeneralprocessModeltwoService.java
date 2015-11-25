package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModeltwoDAO;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessModeltwo;
import com.gotop.Generalprocess.model.TGeneralprocessModeltwoExample;
import com.gotop.Generalprocess.service.ITGeneralprocessModeltwoService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TGeneralprocessModeltwoService implements ITGeneralprocessModeltwoService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModeltwoService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModeltwoDAO tGeneralprocessModeltwoDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModeltwoDAO(ITGeneralprocessModeltwoDAO tGeneralprocessModeltwoDAO) throws Exception {
        this.tGeneralprocessModeltwoDAO = tGeneralprocessModeltwoDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModeltwoDAO gettGeneralprocessModeltwoDAO() throws Exception {
        return this.tGeneralprocessModeltwoDAO;
    }

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TGeneralprocessModeltwoExample example = new TGeneralprocessModeltwoExample();
        TGeneralprocessModeltwoExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TGeneralprocessModeltwo record = new TGeneralprocessModeltwo();
        List list = tGeneralprocessModeltwoDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 更新单条记录，通过主键
     * @abatorgenerated
     */
    public void update(TGeneralprocessModeltwo obj) throws Exception {
        this.tGeneralprocessModeltwoDAO.updateByPrimaryKeySelective(obj);
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TGeneralprocessModeltwo obj) throws Exception {
        this.tGeneralprocessModeltwoDAO.insert(obj);
    }

    /**
     * 删除单条记录
     * @abatorgenerated
     */
    public void delete(TGeneralprocessModeltwo obj) throws Exception {
        java.math.BigDecimal key = obj.getProcessmodelid();
        this.tGeneralprocessModeltwoDAO.deleteByPrimaryKey(key);
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
            	TGeneralprocessModeltwo tObject = (TGeneralprocessModeltwo)abs.get(i);
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
            	TGeneralprocessModeltwo tObject = (TGeneralprocessModeltwo)abs.get(i);
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
            	TGeneralprocessModeltwo tObject = (TGeneralprocessModeltwo)abs.get(i);
            	this.delete(tObject);
        }
    }

    /**
     * datacell方式批量更新数据
     * @abatorgenerated
     */
    public void updateDataGrid(HashMap hmp) throws Exception {
        this.tGeneralprocessModeltwoDAO.startBatch();
        List insertEntities = (List) hmp.get("insertEntities");
        List deleteEntities = (List) hmp.get("deleteEntities");
        List updateEntities = (List) hmp.get("updateEntities");
        this.updateBatch(updateEntities);
        this.insertBatch(insertEntities);
        this.deleteBatch(deleteEntities);
        this.tGeneralprocessModeltwoDAO.executeBatch();
    }

    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List queryAllDataList(HashMap map) throws Exception {
        TGeneralprocessModeltwoExample example = new TGeneralprocessModeltwoExample();
        TGeneralprocessModeltwoExample.Criteria criteria = example.createCriteria();
        List list = tGeneralprocessModeltwoDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryPageDataList(HashMap map, Page page) throws Exception {
        List list = tGeneralprocessModeltwoDAO.selectByDynamic(map,page);
        return list;
    }

	@Override
	public ProcessModelTwo queryModelTwoById(String processModelId) {
        return tGeneralprocessModeltwoDAO.queryModelTwoById(processModelId);
	}

	@Override
	public ProcessModelTwo queryModelTwo(ProcessModelTwo modelTwo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelTwo != null){
			if(modelTwo.getFlow_id() != null && !"".equals(modelTwo.getFlow_id())){
				map.put("flow_id", modelTwo.getFlow_id());
			}
			if(modelTwo.getTaskName() != null && !"".equals(modelTwo.getTaskName())){
				map.put("taskName", modelTwo.getTaskName());
			}
		}
		return this.tGeneralprocessModeltwoDAO.queryModelTwo(map);
	}
}