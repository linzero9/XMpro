package com.gotop.timeMachine.action;

import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.gotop.util.XmlConvert;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class TModelTimedayAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITModelTimedayService tModelTimedayService;
    
    
    private  List<TModelTimeday>  days;
    
    
    
    public List<TModelTimeday> getDays() {
		return days;
	}

	public void setDays(List<TModelTimeday> days) {
		this.days = days;
	}

	/**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settModelTimedayService(ITModelTimedayService tModelTimedayService) {
        this.tModelTimedayService = tModelTimedayService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITModelTimedayService gettModelTimedayService() {
        return this.tModelTimedayService;
    }

    /**
     * 查询datacell列表.
     * @abatorgenerated
     */
    public void queryDataGrid() throws Exception {
        AjaxParam apm = XmlConvert.queryDatacell();
        Page page = apm.getPage();
        HashMap hm = apm.getParams();
        List data = tModelTimedayService.queryDataGrid(hm , page);
        String xmlStr = XmlConvert.getXmlListBean(page,data);
        MUO.write(xmlStr);
    }

    /**
     * 批量更新列表.
     * @abatorgenerated
     */
    public void updateDataGrid() throws Exception {
        HashMap hmp = XmlConvert.updateDatacell();
        tModelTimedayService.updateDataGrid(hmp);
    }

    /**
     * comboselect演示.
     * @abatorgenerated
     */
    public void comboSelect() throws Exception {
        HashMap combopara = this.getCombopara();
        if(combopara!=null){
            	List combo = tModelTimedayService.queryAllDataList(combopara);
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
        List orgs = tModelTimedayService.queryPageDataList(hm,page);
        request.setAttribute("beans", orgs);
        request.setAttribute("page", page);
        return "viewlist";
    }
    
    
    /**
     * 超限时长报表  hanld
     * 
     * @author wujiajun
     * 
     * @desc  用于处理  超限时长报表 的action
     * 
     * 1.查询出所有的信贷流程，必须为结束
     * 2.循环流程的 flowid 获取到每个流程，然后取到表JBPM4_HIST_ACTINST 的所有记录（就是走过的所有节点）
     * 3.循环JBPM4_HIST_ACTINST   根据 时间表 计算出 是否超时 以及超时时间 （考虑二次提交）
     * 3.计算后的结果存入到 临时表中 
     * 4.查询临时表信息 ，显示到页面 
     * 
     */
    public String hanldTimeReport() throws Exception {
      
        return "timeReport";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}