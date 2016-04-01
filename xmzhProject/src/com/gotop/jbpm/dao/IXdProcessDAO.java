package com.gotop.jbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.primeton.utils.Page;

public interface IXdProcessDAO {

	List<XdProcessTaskAssignee> queryXdMyToDoList(Map<String, Object> map,Page page);

	List<XdProcessBean> queryXdProcessList(Map<String, Object> map, Page page);
}
