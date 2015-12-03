package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.TGeneralprocessCdtype;
import com.primeton.utils.Page;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessCdtypeDAO {



	List<TGeneralprocessCdtype> queryPageCdtype(TGeneralprocessCdtype cdtype, Page page);

	List<TGeneralprocessCdtype> querycreditType(TGeneralprocessCdtype cdtype);
}