package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessCdtypeDAO;
import com.gotop.Generalprocess.model.TGeneralprocessCdtype;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessCdtypeService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessCdtypeDAO(ITGeneralprocessCdtypeDAO tGeneralprocessCdtypeDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessCdtypeDAO gettGeneralprocessCdtypeDAO() throws Exception;

  

	List<TGeneralprocessCdtype> queryPageCdtype(TGeneralprocessCdtype cdtype,
			Page page);

	List<TGeneralprocessCdtype> querycreditType(TGeneralprocessCdtype cdtype);
}