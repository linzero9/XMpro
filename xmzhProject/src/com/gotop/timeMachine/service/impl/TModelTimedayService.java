package com.gotop.timeMachine.service.impl;

import com.gotop.timeMachine.dao.ITModelTimedayDAO;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.model.TModelTimedayExample;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TModelTimedayService implements ITModelTimedayService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TModelTimedayService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITModelTimedayDAO tModelTimedayDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settModelTimedayDAO(ITModelTimedayDAO tModelTimedayDAO) throws Exception {
        this.tModelTimedayDAO = tModelTimedayDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITModelTimedayDAO gettModelTimedayDAO() throws Exception {
        return this.tModelTimedayDAO;
    }

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TModelTimedayExample example = new TModelTimedayExample();
        TModelTimedayExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TModelTimeday record = new TModelTimeday();
        List list = tModelTimedayDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TModelTimeday obj) throws Exception {
        this.tModelTimedayDAO.insert(obj);
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
            	TModelTimeday tObject = (TModelTimeday)abs.get(i);
            //  没有主键的表，请自行处理
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
            	TModelTimeday tObject = (TModelTimeday)abs.get(i);
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
            	TModelTimeday tObject = (TModelTimeday)abs.get(i);
            	this.delete(tObject);
        }
    }

    /**
     * datacell方式批量更新数据
     * @abatorgenerated
     */
    public void updateDataGrid(HashMap hmp) throws Exception {
        this.tModelTimedayDAO.startBatch();
        List insertEntities = (List) hmp.get("insertEntities");
        List deleteEntities = (List) hmp.get("deleteEntities");
        List updateEntities = (List) hmp.get("updateEntities");
        this.updateBatch(updateEntities);
        this.insertBatch(insertEntities);
        this.deleteBatch(deleteEntities);
        this.tModelTimedayDAO.executeBatch();
    }

    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List queryAllDataList(HashMap map) throws Exception {
        TModelTimedayExample example = new TModelTimedayExample();
        TModelTimedayExample.Criteria criteria = example.createCriteria();
        List list = tModelTimedayDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryPageDataList(HashMap map, Page page) throws Exception {
        List list = tModelTimedayDAO.selectByDynamic(map,page);
        return list;
    }

	@Override
	public void delete(TModelTimeday obj) throws Exception {
		// TODO Auto-generated method stub
		
		tModelTimedayDAO.deleteByTemplate(obj);
		
	}
}