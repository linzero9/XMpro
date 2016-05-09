package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.service.ITGeneralprocessModeloneService;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.util.XmlConvert;
import com.gotop.vo.system.MUOUserSession;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class TGeneralprocessModeloneAction extends BaseAction {
	/**
	 * 当前用户和提交人po
	 */
	private ProcessSubmitter processSubmitter;
	private String flowId;
	
    public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public ProcessSubmitter getProcessSubmitter() {
		return processSubmitter;
	}

	public void setProcessSubmitter(ProcessSubmitter processSubmitter) {
		this.processSubmitter = processSubmitter;
	}

	/**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModeloneService tGeneralprocessModeloneService;

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModeloneService(ITGeneralprocessModeloneService tGeneralprocessModeloneService) {
        this.tGeneralprocessModeloneService = tGeneralprocessModeloneService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModeloneService gettGeneralprocessModeloneService() {
        return this.tGeneralprocessModeloneService;
    }

    /**
     * 查询datacell列表.
     * @abatorgenerated
     */
    public void queryDataGrid() throws Exception {
        AjaxParam apm = XmlConvert.queryDatacell();
        Page page = apm.getPage();
        HashMap hm = apm.getParams();
        List data = tGeneralprocessModeloneService.queryDataGrid(hm , page);
        String xmlStr = XmlConvert.getXmlListBean(page,data);
        MUO.write(xmlStr);
    }

    /**
     * 批量更新列表.
     * @abatorgenerated
     */
    public void updateDataGrid() throws Exception {
        HashMap hmp = XmlConvert.updateDatacell();
        tGeneralprocessModeloneService.updateDataGrid(hmp);
    }

    /**
     * comboselect演示.
     * @abatorgenerated
     */
    public void comboSelect() throws Exception {
        HashMap combopara = this.getCombopara();
        if(combopara!=null){
            	List combo = tGeneralprocessModeloneService.queryAllDataList(combopara);
            	String dataresult = XmlConvert.getXmlListBean(combo);
            	MUO.write(dataresult);
        }
    }

    /**
     * viewDataList说明.
     * @abatorgenerated
     */
    public String queryViewList() throws Exception {
        HttpServletRequest request=ServletActionContext.getRequest();
        Page page = this.getPage();
        HashMap hm = new HashMap();
        List orgs = tGeneralprocessModeloneService.queryPageDataList(hm,page);
        request.setAttribute("orgs", orgs);
        request.setAttribute("page", page);
        return "viewlist";
    }
    
	/**
	 * 查询提交人
	 */
	public String querySubmitter(){
		if (flowId!=null&&!"".equals(flowId)) {
			this.processSubmitter.setFlowId(flowId);
		}
		processSubmitter=tGeneralprocessModeloneService.querySubmitter(processSubmitter);
		MUOUserSession user = this.getCurrentOnlineUser();
		processSubmitter.setCurrenUser(user.toString());
		this.setProcessSubmitter(processSubmitter);
		return "processSubmitter";
	}
    
}