package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.service.ITGeneralprocessModelthreeService;
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

public class TGeneralprocessModelthreeAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelthreeService tGeneralprocessModelthreeService;

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelthreeService(ITGeneralprocessModelthreeService tGeneralprocessModelthreeService) {
        this.tGeneralprocessModelthreeService = tGeneralprocessModelthreeService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelthreeService gettGeneralprocessModelthreeService() {
        return this.tGeneralprocessModelthreeService;
    }

   
}