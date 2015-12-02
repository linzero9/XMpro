package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessCdtypeDAO;
import com.gotop.Generalprocess.model.TGeneralprocessCdtype;
import com.gotop.Generalprocess.model.TGeneralprocessCdtypeExample;
import com.gotop.Generalprocess.service.ITGeneralprocessCdtypeService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TGeneralprocessCdtypeService implements ITGeneralprocessCdtypeService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessCdtypeService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessCdtypeDAO tGeneralprocessCdtypeDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessCdtypeDAO(ITGeneralprocessCdtypeDAO tGeneralprocessCdtypeDAO) throws Exception {
        this.tGeneralprocessCdtypeDAO = tGeneralprocessCdtypeDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessCdtypeDAO gettGeneralprocessCdtypeDAO() throws Exception {
        return this.tGeneralprocessCdtypeDAO;
    }

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TGeneralprocessCdtypeExample example = new TGeneralprocessCdtypeExample();
        TGeneralprocessCdtypeExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TGeneralprocessCdtype record = new TGeneralprocessCdtype();
        List list = tGeneralprocessCdtypeDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TGeneralprocessCdtype obj) throws Exception {
        this.tGeneralprocessCdtypeDAO.insert(obj);
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
            	TGeneralprocessCdtype tObject = (TGeneralprocessCdtype)abs.get(i);
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
            	TGeneralprocessCdtype tObject = (TGeneralprocessCdtype)abs.get(i);
            	this.insert(tObject);
        }
    }



    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List<TGeneralprocessCdtype> queryAllDataList(HashMap map) throws Exception {
        TGeneralprocessCdtypeExample example = new TGeneralprocessCdtypeExample();
        TGeneralprocessCdtypeExample.Criteria criteria = example.createCriteria();
        List<TGeneralprocessCdtype> list = (List<TGeneralprocessCdtype>)tGeneralprocessCdtypeDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List<TGeneralprocessCdtype> queryPageDataList(HashMap map, Page page) throws Exception {
    	List<TGeneralprocessCdtype> list = (List<TGeneralprocessCdtype>)tGeneralprocessCdtypeDAO.selectByDynamic(map,page);
        return list;
    }

	@Override
	public void updateDataGrid(HashMap hmp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TGeneralprocessCdtype> queryPageCdtype(
			TGeneralprocessCdtype cdtype, Page page) {
		// TODO Auto-generated method stub
		
		List<TGeneralprocessCdtype> list = (List<TGeneralprocessCdtype>)tGeneralprocessCdtypeDAO.queryPageCdtype(cdtype,page);
		return list;
	}

	@Override
	public List<TGeneralprocessCdtype> querycreditType(
			TGeneralprocessCdtype cdtype) {
		// TODO Auto-generated method stub
		List<TGeneralprocessCdtype> list = (List<TGeneralprocessCdtype>)tGeneralprocessCdtypeDAO.querycreditType(cdtype);
		return list;
	}
}