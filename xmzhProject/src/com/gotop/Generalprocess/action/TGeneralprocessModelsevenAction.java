package com.gotop.Generalprocess.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessModelSeven;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessMistakeService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsevenService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

public class TGeneralprocessModelsevenAction extends BaseAction {
	private String[] rectification;
	private String[] mistakeId;

	public String[] getMistakeId() {
		return mistakeId;
	}

	public void setMistakeId(String[] mistakeId) {
		this.mistakeId = mistakeId;
	}

	public String[] getRectification() {
		return rectification;
	}

	public void setRectification(String[] rectification) {
		this.rectification = rectification;
	}
	/**
	 * 当前用户和提交人po
	 */
	private ProcessSubmitter processSubmitter;
	private ProcessMistake processMistake;
	private List<ProcessMistake> processMistakeList = new ArrayList<ProcessMistake>();
	public List<ProcessMistake> getProcessMistakeList() {
		return processMistakeList;
	}

	public void setProcessMistakeList(List<ProcessMistake> processMistakeList) {
		this.processMistakeList = processMistakeList;
	}

	public ProcessMistake getProcessMistake() {
		return processMistake;
	}

	public void setProcessMistake(ProcessMistake processMistake) {
		this.processMistake = processMistake;
	}

	public ProcessSubmitter getProcessSubmitter() {
		return processSubmitter;
	}

	public void setProcessSubmitter(ProcessSubmitter processSubmitter) {
		this.processSubmitter = processSubmitter;
	}
	/**
	 * 差错相关的service
	 */
	private IGeneralprocessMistakeService generalprocessMistakeService;
	
	public IGeneralprocessMistakeService getGeneralprocessMistakeService() {
		return generalprocessMistakeService;
	}

	public void setGeneralprocessMistakeService(
			IGeneralprocessMistakeService generalprocessMistakeService) {
		this.generalprocessMistakeService = generalprocessMistakeService;
	}
	
	/**
	 * 模式七控制器
	 */
	private static final long serialVersionUID = 1L;

	private List<TDefaultOpinion> defaultOps;
	
	private ITDefaultOpinionService tDefaultOpinionService;
	
	/**
	 * 
	 * @author wsd
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;

	private String taskName;
	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;

	private ProcessModelSeven modelSeven;

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	/**
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModelsevenService tGeneralprocessModelsevenService;

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

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

	public ProcessModelSeven getModelSeven() {
		return modelSeven;
	}

	public void setModelSeven(ProcessModelSeven modelSeven) {
		this.modelSeven = modelSeven;
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
	public void settGeneralprocessModelsevenService(
			ITGeneralprocessModelsevenService tGeneralprocessModelsevenService) {
		this.tGeneralprocessModelsevenService = tGeneralprocessModelsevenService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModelsevenService gettGeneralprocessModelsevenService() {
		return this.tGeneralprocessModelsevenService;
	}

	/**
	 * 跳转到模式七页面
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public String toModelSeven() throws SecurityException,
			IllegalArgumentException, ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		// 获取流程实例id
		String businessId = taskAssgineeDto.getExecutionId();

		taskName = taskAssgineeDto.getTaskName();
		// 获取流程配置主表对象
		TGeneralprocessMain main = this.generalprocessMainService
				.queryMainByBusinessId(businessId);

		if (main != null) {
			if (main.getBeginEmpId() != null && main.getBeginOrgId() != null) {
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

		ProcessModelSeven newModelSeven = new ProcessModelSeven();
		if (businessId != null && taskName1 != null) {
			ProcessModelSeven ms = new ProcessModelSeven();
			ms.setFlowId(businessId);
			ms.setTaskName(taskName1);
			newModelSeven = this.tGeneralprocessModelsevenService
					.queryModelSeven(ms);
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
				if (map.containsKey(rule + "-" + id)) {
					continue;
				} else {
					map.put(rule + "-" + id, id);
				}

			}
		}

		String rm = "";
		if (newModelSeven != null) {
			rm = "ProcessModelSeven" + "-" + newModelSeven.getProcessModelId();
			map.remove(rm);
		}

		this.setModelSeven(newModelSeven);

		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
				.returnAllObj(map);

		String fxJson = JSONArray.fromObject(beans).toString();
		taskAssgineeDto.setFxJson(fxJson);
		queryDefault(); 
		return "toModelSeven";
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
	 * 处理模式七节点,结束节点
	 * 
	 * @throws Exception
	 */
	public void handleModelSeven() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.tGeneralprocessModelsevenService.handleModelSeven(muo, modelSeven, taskAssgineeDto, files, filesFileName);
				this.updateProcessMistakes();
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式七表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);
	}
    //文件操作
	private File[] files;
	private String[] filesFileName;
	private String modeId;
    private String executionId; 
	private  String modeType;
    private String fileId;


	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String getModeId() {
		return modeId;
	}

	public void setModeId(String modeId) {
		this.modeId = modeId;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}
	/**
	 * 查询提交人
	 */
	public String querySubmitter(){
	
		processSubmitter=generalprocessMistakeService.querySubmitter(processSubmitter);
		MUOUserSession user = this.getCurrentOnlineUser();
		processSubmitter.setCurrenUser(user.getEmpname());
		this.setProcessSubmitter(processSubmitter);
		return "processSubmitter";
	}
	/**
	 * 查询差错相关
	 */
 public String queryProcessMistake(){
	List<ProcessMistake> processMistakeList= generalprocessMistakeService.queryProcessMistake(processMistake);
	this.setProcessMistakeList(processMistakeList);
   return "processMistakeList";
 }
	/**
	 * 更新整改情况
	 * @throws Exception 
	 */
	
	public void updateProcessMistake() throws Exception {
		processMistakeList.add(processMistake);
		String info = "success";
		try {
			this.generalprocessMistakeService.updateProcessMistake(processMistakeList);
		} catch (Exception e) {
			info = "fails";
			log.error("[保存错误失败！]", e);
			throw e;
		}
		Struts2Utils.renderText(info);
	}
	/**
	 * 提交时批量更新整改情况
	 * @throws Exception 
	 */
	
	public void updateProcessMistakes() throws Exception {
		if (mistakeId!=null&&mistakeId.length!=0&&rectification!=null&&!"".equals(rectification)) {
			
			for (int i = 0; i < mistakeId.length; i++) {
				processMistake=new ProcessMistake();
			    processMistake.setMistakeId(mistakeId[i]);
				processMistake.setRectification(rectification[i]);
				processMistakeList.add(processMistake);
				
			}
		}
		
	
			this.generalprocessMistakeService.updateProcessMistake(processMistakeList);
		
	}
}