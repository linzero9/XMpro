package com.gotop.jbpm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.cmd.Command;
import org.jbpm.api.cmd.Environment;
import org.jbpm.api.task.Task;
import org.jbpm.api.history.HistoryActivityInstance;
import org.jbpm.api.history.HistoryActivityInstanceQuery;

import com.gotop.crm.util.BaseAction;
import com.gotop.util.Struts2Utils;

public class WithdrawJbpmAction extends BaseAction implements Command {

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
	public void test(){
		
		String aa ="sss";
	}
	@Override
	public Object execute(Environment environment) throws Exception {
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
		return null;
	}

}
