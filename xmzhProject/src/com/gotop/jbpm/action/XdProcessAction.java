package com.gotop.jbpm.action;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.service.IXdProcessService;

public class XdProcessAction   extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected IXdProcessService xdProcessService;

	public IXdProcessService getXdProcessService() {
		return xdProcessService;
	}

	public void setXdProcessService(IXdProcessService xdProcessService) {
		this.xdProcessService = xdProcessService;
	}
	
	public String queryXdMyToDoList(){
		return "xd_mytodo_list";
	}
}
