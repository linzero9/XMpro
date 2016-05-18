package com.gotop.dict.service;

import com.gotop.dict.dao.IEosDictEntryDAO;
import com.gotop.dict.model.EosDictEntry;
import com.gotop.dict.model.EosDictType;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface IEosDictEntryService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void setEosDictEntryDAO(IEosDictEntryDAO eosDictEntryDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    IEosDictEntryDAO getEosDictEntryDAO() throws Exception;
    
    List<EosDictType> dictTypeList(EosDictType dictType, Page page);
    
    List<EosDictEntry> queryDictEntryBydictTypeId(EosDictEntry dictEntry, Page page2);
    
    List<EosDictEntry> queryDictEntryBydictTypeId(EosDictEntry dictEntry);

	EosDictEntry getDictEntryById(EosDictEntry dictEntry);
	//根据dictTypeId查询属性
	EosDictType getEosDictTypeBydictTypeId(EosDictType dictType);
	void insert(EosDictEntry dictEntry);
	
	void update(EosDictEntry dictEntry);

	void delete(EosDictEntry dictEntry);

	int queryIsExist(EosDictEntry dictEntry);

}