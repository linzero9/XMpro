package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessCdtypeDAO;
import com.gotop.Generalprocess.model.TGeneralprocessCdtype;
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