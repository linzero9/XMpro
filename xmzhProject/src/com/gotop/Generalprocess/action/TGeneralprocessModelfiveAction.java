package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.service.ITGeneralprocessModelfiveService;
import com.gotop.crm.util.BaseAction;

/**
 * 模式五控制器
 * @author wsd
 *
 */
public class TGeneralprocessModelfiveAction extends BaseAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelfiveService tGeneralprocessModelfiveService;

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelfiveService(ITGeneralprocessModelfiveService tGeneralprocessModelfiveService) {
        this.tGeneralprocessModelfiveService = tGeneralprocessModelfiveService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelfiveService gettGeneralprocessModelfiveService() {
        return this.tGeneralprocessModelfiveService;
    }
    
    public String toModelFive(){
    	return null;
    }
    
    public void handleModelFive(){
    	
    }

}