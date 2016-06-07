package com.gotop.Generalprocess.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.examples.task.assignee.Order;
import org.jbpm.pvm.internal.env.EnvironmentFactory;
import org.jbpm.pvm.internal.env.EnvironmentImpl;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.model.TransitionImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.examples.task.assignee.Order;
import org.jbpm.pvm.internal.env.EnvironmentFactory;
import org.jbpm.pvm.internal.env.EnvironmentImpl;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.model.TransitionImpl;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.junit.Before;
import org.junit.Test;

import net.sf.json.JSONArray;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfourService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.Generalprocess.util.SpringContextUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;


/**
 * 
 * @author wujiajun  test  
 * 
 *
 */
public class TestBackAction {
	
	private JbpmService jbpmService;
	
	private TaskAssgineeDto taskAssgineeDto;
	
	 private ProcessEngine processEngine;  
	 
	    private TaskService taskService;  
	    private RepositoryService repositoryService;  
	    private ExecutionService executionService;  
	    private HistoryService historyService;  
	
	public  void  backOk(){
		
		
		
		// 获取流程实例id
		String businessId = taskAssgineeDto.getExecutionId();

	 String	taskName = taskAssgineeDto.getTaskName();
		


		 
/**1.获取到  流程的 DefinitionId 模板id  获取到ProcessDefinitionImpl-pd对象
 * 2.当前节点名称  和 上一个节点名称  以及 pd 然后获取到  ActivityImpl 对象
 * 
 * 3.回退的话 需要创建 他们之间的 线 （因为图上是没有线路的）
 * 
 * 4.completeTask执行这个方法，把流程回归到上一个节点
 * 
 * 5.当然 处理人 和代办  也要到上一个人身上哦！
 * 
 * 6.现在遇到的问题：1.上一个节点的名称获取，2.模板id的获取。3.把流程的下个处理人出现在代办列表中 。直接调用方法即可。处理了这3个问题 即可实现此功能哦。
 */
		 
			ProcessDefinitionImpl pd = (ProcessDefinitionImpl) repositoryService
			.createProcessDefinitionQuery()
			.processDefinitionId("wujiajunback1223yrv9t-1").uniqueResult();
			
			
			//当前节点
			  ActivityImpl sourceActivity = pd.findActivity("");  
	           //取得目标的活动定义  
	           ActivityImpl destActivity=pd.findActivity("模式一-受理调查");  
	           //为两个节点创建连接  
	           TransitionImpl transition = sourceActivity.createOutgoingTransition();  
	           transition.setName("to" + "模式一-受理调查");  
	           transition.setDestination(destActivity);  
	           sourceActivity.addOutgoingTransition(transition);  
	           System.out.println("sourceActivity.getName() = "+sourceActivity.getName());  
	           System.out.println("destActivity.getName() = "+destActivity.getName());  
			
			
		 
		 jbpmService.getProcessEngine().getTaskService().completeTask(taskAssgineeDto.getNextTaskId(),transition.getName(),null);  
		 
		 
		 
		 TaskAssgineeDto  dto = new  TaskAssgineeDto();
		 
		 //1.查询处理人
		 dto.setEmpIds("1,437273,23242");
		 dto.setExecutionId(businessId);
		 
		 
		 jbpmService.saceTaskAssignee(dto);
		
		
	}
	 
	 

}
