package com.gotop.dict.model;

import java.io.Serializable;

public class EosDictType   implements Serializable {
	
	//类型编号
	private String dictTypeId;
	
	//类型名称
	private String dictTypeName;

	public String getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getDictTypeName() {
		return dictTypeName;
	}

	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}
	
	
}
