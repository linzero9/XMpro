package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.model.TGeneralprocessMainExample;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TGeneralprocessMainService implements ITGeneralprocessMainService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessMainService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessMainDAO tGeneralprocessMainDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessMainDAO(ITGeneralprocessMainDAO tGeneralprocessMainDAO) throws Exception {
        this.tGeneralprocessMainDAO = tGeneralprocessMainDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessMainDAO gettGeneralprocessMainDAO() throws Exception {
        return this.tGeneralprocessMainDAO;
    }

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TGeneralprocessMainExample example = new TGeneralprocessMainExample();
        TGeneralprocessMainExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TGeneralprocessMain record = new TGeneralprocessMain();
        List list = tGeneralprocessMainDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 更新单条记录，通过主键
     * @abatorgenerated
     */
    public void update(TGeneralprocessMain obj) throws Exception {
        this.tGeneralprocessMainDAO.updateByPrimaryKeySelective(obj);
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TGeneralprocessMain obj) throws Exception {
        this.tGeneralprocessMainDAO.insert(obj);
    }

    /**
     * 删除单条记录
     * @abatorgenerated
     */
    public void delete(TGeneralprocessMain obj) throws Exception {
        
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
            	TGeneralprocessMain tObject = (TGeneralprocessMain)abs.get(i);
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
            	TGeneralprocessMain tObject = (TGeneralprocessMain)abs.get(i);
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
            	TGeneralprocessMain tObject = (TGeneralprocessMain)abs.get(i);
            	this.delete(tObject);
        }
    }

    /**
     * datacell方式批量更新数据
     * @abatorgenerated
     */
    public void updateDataGrid(HashMap hmp) throws Exception {
        this.tGeneralprocessMainDAO.startBatch();
        List insertEntities = (List) hmp.get("insertEntities");
        List deleteEntities = (List) hmp.get("deleteEntities");
        List updateEntities = (List) hmp.get("updateEntities");
        this.updateBatch(updateEntities);
        this.insertBatch(insertEntities);
        this.deleteBatch(deleteEntities);
        this.tGeneralprocessMainDAO.executeBatch();
    }

    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List queryAllDataList(HashMap map) throws Exception {
        TGeneralprocessMainExample example = new TGeneralprocessMainExample();
        TGeneralprocessMainExample.Criteria criteria = example.createCriteria();
        List list = tGeneralprocessMainDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryPageDataList(HashMap map, Page page) throws Exception {
        List list = tGeneralprocessMainDAO.selectByDynamic(map,page);
        return list;
    }

	@Override
	public TGeneralprocessMain queryMainByBusinessId(String businessId) {
		return this.tGeneralprocessMainDAO.queryMainByBusinessId(businessId);
	}
}