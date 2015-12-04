package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.model.TGeneralprocessCdtype;
import com.gotop.Generalprocess.service.ITGeneralprocessCdtypeService;
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

public class TGeneralprocessCdtypeAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessCdtypeService tGeneralprocessCdtypeService;
    
    private List<TGeneralprocessCdtype> cdtypes;
    private  TGeneralprocessCdtype cdtype;
    private  String cdtypeJson;
    

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessCdtypeService(ITGeneralprocessCdtypeService tGeneralprocessCdtypeService) {
        this.tGeneralprocessCdtypeService = tGeneralprocessCdtypeService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessCdtypeService gettGeneralprocessCdtypeService() {
        return this.tGeneralprocessCdtypeService;
    }


	public TGeneralprocessCdtype getCdtype() {
		return cdtype;
	}

	public void setCdtype(TGeneralprocessCdtype cdtype) {
		this.cdtype = cdtype;
	}
    


	/**
     * viewDataList说明.
     * @abatorgenerated
     */
    public String queryViewList() throws Exception {
        HttpServletRequest request=ServletActionContext.getRequest();
        Page page = this.getPage();
        cdtypes=this.tGeneralprocessCdtypeService.queryPageCdtype(cdtype, page);
        this.setCdtypes(cdtypes);
        return "fslist";
    }
    

	/**
     * querycreditType说明.
     * @abatorgenerated
     */
    public String querycreditType() throws Exception {
        cdtypes=this.tGeneralprocessCdtypeService.querycreditType(cdtype);
        this.setCdtypes(cdtypes);
        return "ctlist";
    }

	public List<TGeneralprocessCdtype> getCdtypes() {
		return cdtypes;
	}

	public void setCdtypes(List<TGeneralprocessCdtype> cdtypes) {
		this.cdtypes = cdtypes;
	}
	public String getCdtypeJson() {
		return cdtypeJson;
	}

	public void setCdtypeJson(String cdtypeJson) {
		this.cdtypeJson = cdtypeJson;
	}
}