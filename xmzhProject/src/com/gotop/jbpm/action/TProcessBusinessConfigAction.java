package com.gotop.jbpm.action;

import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.jbpm.service.ITProcessBusinessConfigService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.cmd.Command;
import org.jbpm.api.cmd.Environment;
import org.jbpm.api.history.HistoryActivityInstance;
import org.jbpm.api.history.HistoryActivityInstanceQuery;
import org.jbpm.api.task.Task;

public class TProcessBusinessConfigAction extends BaseAction implements Command {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITProcessBusinessConfigService tProcessBusinessConfigService;

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settProcessBusinessConfigService(ITProcessBusinessConfigService tProcessBusinessConfigService) {
        this.tProcessBusinessConfigService = tProcessBusinessConfigService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITProcessBusinessConfigService gettProcessBusinessConfigService() {
        return this.tProcessBusinessConfigService;
    }
    
    private  String info;
    
    public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/**
     * 查询datacell列表.
     * @abatorgenerated
     */
    public void queryDataGrid() throws Exception {
        AjaxParam apm = XmlConvert.queryDatacell();
        Page page = apm.getPage();
        HashMap hm = apm.getParams();
        List data = tProcessBusinessConfigService.queryDataGrid(hm , page);
        String xmlStr = XmlConvert.getXmlListBean(page,data);
        MUO.write(xmlStr);
    }

    /**
     * 批量更新列表.
     * @abatorgenerated
     */
    public void updateDataGrid() throws Exception {
        HashMap hmp = XmlConvert.updateDatacell();
        tProcessBusinessConfigService.updateDataGrid(hmp);
    }

    /**
     * comboselect演示.
     * @abatorgenerated
     */
    public void comboSelect() throws Exception {
        HashMap combopara = this.getCombopara();
        if(combopara!=null){
            	List combo = tProcessBusinessConfigService.queryAllDataList(combopara);
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
        List orgs = tProcessBusinessConfigService.queryPageDataList(hm,page);
        request.setAttribute("orgs", orgs);
        request.setAttribute("page", page);
        return "viewlist";
    }

    
    String executionId;// 流程节点id
	String activityName;//退回的节点
	HashMap var;

	

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public HashMap getVar() {
		return var;
	}

	public void setVar(HashMap var) {
		this.var = var;
	}
	
	
	
	public  String dotest(){
		System.out.println("++++++++++ooooooooooooooooooooooooo++++++++++++");
		info = "succe222222ss";
		try {
			this.execute(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "dotest";
	}

	public String execute(Environment environment) throws Exception {
		
		
		System.out.println("11111111++++++++++ooooooooooooooooooooooooo++++++++++++");
		// TODO Auto-generated method stub
		String info = "";
		// 1取得当前的活动节点
	
		ExecutionService es = environment.get(ExecutionService.class);
		TaskService ts = environment.get(TaskService.class);
		HistoryService hs = environment.get(HistoryService.class);

		Execution e = es.findExecutionById(executionId);
		Set<String> actiNames = e.findActiveActivityNames();
		if (actiNames == null || actiNames.size() == 0) {
			info = "fails";
			throw new Exception("没有可撤回的活动!");

		}

		if (actiNames.size() > 1) {
			info = "fails";
			throw new Exception("发生异常,存在多个的活动!");
		}

		String actiName = actiNames.iterator().next(); // 当前活动节点名称

		// 2 将流程推回

		Task t = ts.createTaskQuery().executionId(executionId).uniqueResult();

		ts.completeTask(t.getId(), "退回至" + activityName, var);

		Session session = environment.get(Session.class);
		// 清除痕迹，注意是清除两步痕迹，很重要，要清除得天衣无缝
		// 3.1 清除回退的痕迹

		List<HistoryActivityInstance> hinsts1 = hs
				.createHistoryActivityInstanceQuery().executionId(executionId)
				.activityName(actiName)
				.orderDesc(HistoryActivityInstanceQuery.PROPERTY_ENDTIME)
				.list();

		if (hinsts1 == null || hinsts1.size() == 0) {
			info = "fails";
			throw new Exception("清除回退历史记录时发生异常，历史不存在！");
		}
		session.delete(hinsts1.get(0));

		// 3.2清除之前发送的痕迹
		List<HistoryActivityInstance> hinsts2 = hs
				.createHistoryActivityInstanceQuery().executionId(executionId)
				.activityName(activityName)
				.orderDesc(HistoryActivityInstanceQuery.PROPERTY_ENDTIME)
				.list();

		if (hinsts2 == null || hinsts2.size() == 0) {
			info = "fails";
			throw new Exception("清除发送历史记录时发生异常，历史不存在！");
		}
		for (HistoryActivityInstance hi : hinsts2) {
			if (hi.getEndTime() != null) {
				session.delete(hi);
				break;
			}
		}
		
		info = "success";
		Struts2Utils.renderText(info);
		return "dotest";
	}
}