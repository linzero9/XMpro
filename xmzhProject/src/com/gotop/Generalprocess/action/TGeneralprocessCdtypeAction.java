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
    
    private List<TGeneralprocessCdtype> tGeneralprocessCdtypes;
    private List<TGeneralprocessCdtype> aaa;
    private  TGeneralprocessCdtype cdtype;
    

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

	public List<TGeneralprocessCdtype> gettGeneralprocessCdtypes() {
		return tGeneralprocessCdtypes;
	}

	public void settGeneralprocessCdtypes(
			List<TGeneralprocessCdtype> tGeneralprocessCdtypes) {
		this.tGeneralprocessCdtypes = tGeneralprocessCdtypes;
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
        setAaa(tGeneralprocessCdtypeService.queryPageCdtype(cdtype,page));
//        for(int i=0;i<tGeneralprocessCdtypes.size();i++)
//        {
//         System.out.println(i+":"+tGeneralprocessCdtypes.get(i).getProcessName());
//        }
        return "viewlist";
    }

	public List<TGeneralprocessCdtype> getAaa() {
		return aaa;
	}

	public void setAaa(List<TGeneralprocessCdtype> aaa) {
		this.aaa = aaa;
	}


}