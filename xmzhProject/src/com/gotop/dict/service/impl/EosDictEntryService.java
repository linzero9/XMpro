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

	@Override
	public List<EosDictEntry> queryDictEntryBydictTypeId(EosDictEntry dictEntry) {
		 List<EosDictEntry> dictEntrys = eosDictEntryDAO.queryDictEntryBydictTypeId(dictEntry);
		return dictEntrys;
	}

	@Override
	public EosDictEntry getDictEntryById(EosDictEntry dictEntry) {
		EosDictEntry dictEntry2 = eosDictEntryDAO.getDictEntryById(dictEntry);
		return dictEntry2;
	}

	@Override
	public void insert(EosDictEntry dictEntry) {
			eosDictEntryDAO.insert(dictEntry);
	}
	
	@Override
	public void update(EosDictEntry dictEntry) {
			eosDictEntryDAO.updateById(dictEntry);
	}

	@Override
	public void delete(EosDictEntry dictEntry) {
		String dictIds = dictEntry.getDictId();
		String[] dictIdsArr=dictIds.split(",");
		for(int i=0; i<dictIdsArr.length; i++){
			dictEntry.setDictId(dictIdsArr[i]);
			eosDictEntryDAO.deleteById(dictEntry);
		}
	}

}