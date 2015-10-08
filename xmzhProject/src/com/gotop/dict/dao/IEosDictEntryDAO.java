package com.gotop.dict.dao;

import com.gotop.dict.model.EosDictEntry;
import com.primeton.utils.Page;
import java.util.List;
import java.util.Map;

public interface IEosDictEntryDAO {
    /**
     * 插入一条新数据.
     */
    void insert(EosDictEntry record);

    /**
     * 通过主键更新一条全部字段内容
     */
    int updateByPrimaryKey(EosDictEntry record);
    
	List dictTypeList(Map<String, Object> map, Page page);
}