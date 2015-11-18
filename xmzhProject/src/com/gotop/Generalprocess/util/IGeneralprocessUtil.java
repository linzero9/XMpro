package com.gotop.Generalprocess.util;

import java.util.List;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;

public interface IGeneralprocessUtil<T>{
	
	public List<GeneralprocessFieldBean> getBaseInfoByClassName(String classname);

}
