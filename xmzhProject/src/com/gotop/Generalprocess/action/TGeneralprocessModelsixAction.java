package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.util.XmlConvert;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class TGeneralprocessModelsixAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsixService tGeneralprocessModelsixService;

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelsixService(ITGeneralprocessModelsixService tGeneralprocessModelsixService) {
        this.tGeneralprocessModelsixService = tGeneralprocessModelsixService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelsixService gettGeneralprocessModelsixService() {
        return this.tGeneralprocessModelsixService;
    }
    
    
    
    
    

}