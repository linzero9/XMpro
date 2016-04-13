package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfourService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;

/**
 * 模式四控制器
 * 
 * @author wsd
 * 
 */
public class TGeneralprocessModelfourAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProcessModelFourMistake> fourMistakes;

	private List<ProcessModelFourMistake> otherMistakes;
	
	/**
	 * 历史差错内容
	 */
	private String hiFiles;
	
	/**
	 * 历史扣款金额
	 */
	private String hiJees;
	
	/**
	 * 历史流程实例id
	 */
	private String hiFlowId;
	
	/**
	 * 历史登记人id
	 */
	private String hiEmpId;
	
	/**
	 * 历史节点名称
	 */
	private String hiTaskName;
	

	
	/**
	 * 历史模式四主键
	 */
	private String hiProFour;
	
	/**
	 * 历史添加时间
	 */
	private String hiAddTime;
	
	/**
	 * 
	 */
	private String isView;

	/**
	 * 差错内容
	 */
	private String[] files;
	
	private String sss="";
	private String sss2;

	
	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getSss() {
		return sss;
	}

	public void setSss(String sss) {
		this.sss = sss;
	}

	public String getSss2() {
		return sss2;
	}

	public void setSss2(String sss2) {
		this.sss2 = sss2;
	}

	/**
	 * 扣罚金额
	 */
	private String jees;
	
	/**
	 * 差错的历史时间
	 * */
	private String timees;
	
	
	

	public String getTimees() {
		return timees;
	}

	public void setTimees(String timees) {
		this.timees = timees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 模式四对象
	 */
	private ProcessModelFour modelFour;

	/**
	 * 页面标题展示
	 */
	private String taskName;

	/**
	 * 页面传输对象
	 */
	private TaskAssgineeDto taskAssgineeDto;

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;
	
	private List<TDefaultOpinion> defaultOps;
	
	private ITDefaultOpinionService tDefaultOpinionService;
	
	public List<TDefaultOpinion> getDefaultOps() {
		return defaultOps;
	}

	public void setDefaultOps(List<TDefaultOpinion> defaultOps) {
		this.defaultOps = defaultOps;
	}

	public ITDefaultOpinionService gettDefaultOpinionService() {
		return tDefaultOpinionService;
	}

	public void settDefaultOpinionService(
			ITDefaultOpinionService tDefaultOpinionService) {
		this.tDefaultOpinionService = tDefaultOpinionService;
	}

	public List<ProcessModelFourMistake> getOtherMistakes() {
		return otherMistakes;
	}

	public void setOtherMistakes(List<ProcessModelFourMistake> otherMistakes) {
		this.otherMistakes = otherMistakes;
	}

	public String getHiFiles() {
		return hiFiles;
	}

	public void setHiFiles(String hiFiles) {
		this.hiFiles = hiFiles;
	}

	public String getHiJees() {
		return hiJees;
	}

	public void setHiJees(String hiJees) {
		this.hiJees = hiJees;
	}

	public String getHiFlowId() {
		return hiFlowId;
	}

	public void setHiFlowId(String hiFlowId) {
		this.hiFlowId = hiFlowId;
	}

	public String getHiEmpId() {
		return hiEmpId;
	}

	public void setHiEmpId(String hiEmpId) {
		this.hiEmpId = hiEmpId;
	}

	public String getHiTaskName() {
		return hiTaskName;
	}

	public void setHiTaskName(String hiTaskName) {
		this.hiTaskName = hiTaskName;
	}

	public String getHiProFour() {
		return hiProFour;
	}

	public void setHiProFour(String hiProFour) {
		this.hiProFour = hiProFour;
	}

	public String getHiAddTime() {
		return hiAddTime;
	}

	public void setHiAddTime(String hiAddTime) {
		this.hiAddTime = hiAddTime;
	}

	public List<ProcessModelFourMistake> getFourMistakes() {
		return fourMistakes;
	} 

	public void setFourMistakes(List<ProcessModelFourMistake> fourMistakes) {
		this.fourMistakes = fourMistakes;
	}

/*	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}*/

	public String getJees() {
		return jees;
	}

	public void setJees(String jees) {
		this.jees = jees;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	/**
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModelfourService tGeneralprocessModelfourService;

	public ProcessModelFour getModelFour() {
		return modelFour;
	}

	public void setModelFour(ProcessModelFour modelFour) {
		this.modelFour = modelFour;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 通过spring注入Service的set类.
	 * 
	 * @abatorgenerated
	 */
	public void settGeneralprocessModelfourService(
			ITGeneralprocessModelfourService tGeneralprocessModelfourService) {
		this.tGeneralprocessModelfourService = tGeneralprocessModelfourService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModelfourService gettGeneralprocessModelfourService() {
		return this.tGeneralprocessModelfourService;
	}

	/**
	 * 
	 * @author wsd
	 * @desc 跳转到模式四的表单页面
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public String toModelFour() throws ClassNotFoundException,
			IllegalArgumentException, SecurityException,
			IllegalAccessException, NoSuchFieldException,
			NoSuchMethodException, InvocationTargetException,
			InstantiationException {
		// 获取流程实例id
		String businessId = taskAssgineeDto.getExecutionId();

		taskName = taskAssgineeDto.getTaskName();

		// 获取流程配置主表对象
		TGeneralprocessMain main = this.generalprocessMainService
				.queryMainByBusinessId(businessId);
		
		if(main != null){
			if(main.getBeginEmpId() != null && main.getBeginOrgId() != null){
				taskAssgineeDto.setBeginAssingee(main.getBeginEmpId());
				taskAssgineeDto.setBeginOrg(main.getBeginOrgId());
			}
		}
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String taskName1 = null;
		if (taskAssgineeDto.getNextTaskId() != null) {
			// 待办-办理
			taskName1 = jbpmService.getTaskNameById(taskAssgineeDto
					.getNextTaskId());
		} else {
			if (taskAssgineeDto.getActivityName() != null) {
				// 已办-查看详情
				taskName1 = taskAssgineeDto.getActivityName();
				taskName = taskName1;
			}
		}

		ProcessModelFour newModelFour = new ProcessModelFour();
		if (businessId != null && taskName1 != null) {
			ProcessModelFour modelFour = new ProcessModelFour();
			modelFour.setFlowId(businessId);
			modelFour.setTaskName(taskName1);
			newModelFour = this.tGeneralprocessModelfourService
					.queryModelFour(modelFour);
		}

		String[] rulesArray = null;
		String[] idsArray = null;
		if (main != null) {
			if (main.getRules() != null && !"".equals(main.getRules())) {
				String rules = main.getRules();
				rulesArray = rules.split(",");
			}

			if (main.getIds() != null && !"".equals(main.getIds())) {
				String ids = main.getIds();
				idsArray = ids.split(",");
			}

			for (int i = 0; i < idsArray.length; i++) {
				String id = idsArray[i];
				String rule = rulesArray[i];
				if(map.containsKey(rule + "-" + id)){
					continue;
				}else{
					map.put(rule + "-" + id, id);
					
				}
			}
		}

		String rm = "";
		if (newModelFour != null) {
			rm = "ProcessModelFour" + "-" + newModelFour.getProcessModelId();
			map.remove(rm);
		}

		this.setModelFour(newModelFour);

		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
				.returnAllObj(map);

		String fxJson = JSONArray.fromObject(beans).toString();
		taskAssgineeDto.setFxJson(fxJson);
		queryDefault(); 
		return "toModelFour";
	}

	public void queryDefault() {
		try {
			defaultOps = tDefaultOpinionService.queryDefaultOpsForshow(this
					.getCurrentOnlineUser().getEmpid());
		} catch (Exception e) {
			log.error("[获取默认意见失败]", e);
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式四表单、结束节点、记录流程日志
	 * @return
	 * @throws Exception
	 * 
	 */
	public void handleModelFour() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			
			if(files!=null && !"".equals(files)){
				for (int i = 0; i < files.length-1; i++) {
					sss+=files[i]+"| ";
				}
				for (int i = 0; i < files.length; i++) {
					sss2=files[i];
				}
				sss+=sss2;
				//sss=sss.replace("", "");
			}
			
			MUOUserSession muo = getCurrentOnlineUser();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("hiAddTime", hiAddTime);
			map.put("hiProFour", hiProFour);
			map.put("hiTaskName", hiTaskName);
			map.put("hiEmpId", hiEmpId);
			map.put("hiFlowId", hiFlowId);
			map.put("hiJees", hiJees);
			map.put("hiFiles", hiFiles);
			
			map.put("sss", sss);
			map.put("jees", jees);
			map.put("timees", timees);
			
			
			try {
				this.tGeneralprocessModelfourService.handleModelFour(muo, modelFour, map, taskAssgineeDto, files2, files2FileName);
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式四表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);
	}
	
	public void saveMistakeInfo() throws Exception{
		String info = "success";
		MUOUserSession muo = getCurrentOnlineUser();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String addTime=simpleDateFormat.format(new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mistakeContent", files[0]);
		map.put("punishBal", jees);
		map.put("addTime", addTime);
		
		
		try {
			this.tGeneralprocessModelfourService.saveMistakeInfo(muo, modelFour, map, taskAssgineeDto);
		} catch (Exception e) {
			info = "fails";
			log.error("[保存错误失败！]", e);
			throw e;
		}
		Struts2Utils.renderText(info);
	
}	



	/**
	 * 查询差错列表信息
	 * 
	 * @return
	 */
	public String queryFourMistake() {
		try {
			if (modelFour != null && modelFour.getProcessModelId() != null) {
				fourMistakes = this.tGeneralprocessModelfourService
						.queryFourMistake(modelFour);
			}
		} catch (Exception e) {
			log.error("查询差错列表失败！！", e);
		}
		return "list1";
	}
	
	public String queryFourMistakeByFlowId(){
		String busId = taskAssgineeDto.getExecutionId();
		try {
			if (busId != null && busId != null) {
				otherMistakes = this.tGeneralprocessModelfourService
						.queryFourMistakeByFlowId(busId,modelFour);
			}
		} catch (Exception e) {
			log.error("查询差错列表失败！！", e);
		}
		return "list2";
	}
    //文件操作
	private File[] files2;
	private String[] files2FileName;




	public File[] getFiles2() {
		return files2;
	}

	public void setFiles2(File[] files2) {
		this.files2 = files2;
	}

	public String[] getFiles2FileName() {
		return files2FileName;
	}

	public void setFiles2FileName(String[] files2FileName) {
		this.files2FileName = files2FileName;
	}

	
	
}