package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelsixDAO;
import com.gotop.Generalprocess.model.TGeneralprocessModelsix;
import com.gotop.Generalprocess.model.TGeneralprocessModelsixExample;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TGeneralprocessModelsixService implements ITGeneralprocessModelsixService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelsixService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsixDAO tGeneralprocessModelsixDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelsixDAO(ITGeneralprocessModelsixDAO tGeneralprocessModelsixDAO) throws Exception {
        this.tGeneralprocessModelsixDAO = tGeneralprocessModelsixDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelsixDAO gettGeneralprocessModelsixDAO() throws Exception {
        return this.tGeneralprocessModelsixDAO;
    }

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TGeneralprocessModelsixExample example = new TGeneralprocessModelsixExample();
        TGeneralprocessModelsixExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TGeneralprocessModelsix record = new TGeneralprocessModelsix();
        List list = tGeneralprocessModelsixDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TGeneralprocessModelsix obj) throws Exception {
        this.tGeneralprocessModelsixDAO.insert(obj);
    }

    /**
     * 删除单条记录
     * @abatorgenerated
     */


    /**
     * 批量更新数据
     * @abatorgenerated
     */
    public void updateBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelsix tObject = (TGeneralprocessModelsix)abs.get(i);
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
            	TGeneralprocessModelsix tObject = (TGeneralprocessModelsix)abs.get(i);
            	this.insert(tObject);
        }
    }




    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List queryAllDataList(HashMap map) throws Exception {
        TGeneralprocessModelsixExample example = new TGeneralprocessModelsixExample();
        TGeneralprocessModelsixExample.Criteria criteria = example.createCriteria();
        List list = tGeneralprocessModelsixDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryPageDataList(HashMap map, Page page) throws Exception {
        List list = tGeneralprocessModelsixDAO.selectByDynamic(map,page);
        return list;
    }
}