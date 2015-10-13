package com.gotop.dict.dao;

import com.gotop.dict.model.EosDictEntry;
import com.primeton.utils.Page;
import java.util.List;
import java.util.Map;

public interface IEosDictEntryDAO {

	List dictTypeList(Map<String, Object> map, Page page);
	
	List queryDictEntryBydictTypeId(EosDictEntry dictEntry);

	EosDictEntry getDictEntryById(EosDictEntry dictEntry);
	
	void insert(EosDictEntry dictEntry);

	int updateById(EosDictEntry dictEntry);
	
	int deleteById(EosDictEntry dictEntry);
}