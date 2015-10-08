package com.gotop.dict.service.impl;

import com.gotop.dict.dao.IEosDictEntryDAO;
import com.gotop.dict.model.EosDictEntry;
import com.gotop.dict.model.EosDictType;
import com.gotop.dict.service.IEosDictEntryService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class EosDictEntryService implements IEosDictEntryService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(EosDictEntryService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected IEosDictEntryDAO eosDictEntryDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void setEosDictEntryDAO(IEosDictEntryDAO eosDictEntryDAO) throws Exception {
        this.eosDictEntryDAO = eosDictEntryDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public IEosDictEntryDAO getEosDictEntryDAO() throws Exception {
        return this.eosDictEntryDAO;
    }

	@Override
	public List<EosDictType> dictTypeList(EosDictType dictType, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(dictType != null && dictType.getDictTypeName() != null && !"".equals(dictType.getDictTypeName())){
			map.put("dictTypeName",  dictType.getDictTypeName());
		}
		List list = eosDictEntryDAO.dictTypeList(map,page);
        return list;
	} 

    /**
     * 插入单条记录
     */
    public void insert(EosDictEntry obj) throws Exception {
        this.eosDictEntryDAO.insert(obj);
    }

}