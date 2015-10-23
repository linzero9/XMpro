package com.gotop.dict.model;

import java.io.Serializable;

public class EosDictEntry  extends Object implements Serializable {
  
	//类型编号
    private String dictTypeId;
    
    //项编号
    private String dictId;
    
	//项名称 .
    private String dictName;

	public String getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

}