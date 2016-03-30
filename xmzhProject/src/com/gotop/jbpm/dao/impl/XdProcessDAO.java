package com.gotop.jbpm.dao.impl;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.impl.DeviceManDetailDAO;
import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.util.dataSource.SqlMapClientDao;

public class XdProcessDAO  extends SqlMapClientDao  implements IXdProcessDAO{

	protected Logger log = Logger.getLogger(DeviceManDetailDAO.class);

	public XdProcessDAO() {
		super();
		// TODO 自动生成的构造函数存根
	}

	
}
