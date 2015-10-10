package com.gotop.deviceManagement.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.gotop.deviceManagement.dao.IDeviceManDetailDAO;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;



public class DeviceManDetailDAO extends SqlMapClientDao implements IDeviceManDetailDAO {
	
/**
 * 已经通过集成类 ，获取到了 访问数据库的实例！  可以获取到对象进行DAO操作
 */
	protected Logger log = Logger.getLogger(DeviceManDetailDAO.class);

	
	public DeviceManDetailDAO() {
	super();
	// TODO 自动生成的构造函数存根
}


	@Override
	public List detailList(Map<String, Object> map, Page page) {
		if(page!=null)
			return queryForList("T_DEVICE_Detail_SqlMap.queryList", map, page);
		else
			return queryForList("T_DEVICE_Detail_SqlMap.queryList", map);
	}


	@Override
	public void insert(DeviceDetail detail) {
		getSqlMapClientTemplate().insert("T_DEVICE_Detail_SqlMap.insert", detail);
	}

	@Override
	public int delete(DeviceDetail detail) {
        int rows = getSqlMapClientTemplate().delete("T_DEVICE_Detail_SqlMap.delete", detail);
        return rows;
	}
}
