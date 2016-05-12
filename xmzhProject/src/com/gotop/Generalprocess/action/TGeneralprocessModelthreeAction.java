package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessMistakeService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeloneService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelthreeService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public class TGeneralprocessModelthreeAction extends BaseAction {
	
	
	
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
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * @author wsd
	 * @desc 模式三页面对象
	 * 
	 */
	private ProcessModelThree modelThree;

	/**
	 * @author wsd
	 * @desc 可修改模式一
	 */
	private ProcessModelOne modelOne;

	private String taskName;
	
	public ProcessModelOne getModelOne() {
		return modelOne;
	}

	public void setModelOne(ProcessModelOne modelOne) {
		this.modelOne = modelOne;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ProcessModelThree getModelThree() {
		return modelThree;
	}

	public void setModelThree(ProcessModelThree modelThree) {
		this.modelThree = modelThree;
	}

	public List<TDefaultOpinion> getDefaultOps() {
		return defaultOps;
	}

	public void setDefaultOps(List<TDefaultOpinion> defaultOps) {
		this.defaultOps = defaultOps;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public ITDefaultOpinionService gettDefaultOpinionService() {
		return tDefaultOpinionService;
	}

	public void settDefaultOpinionService(
			ITDefaultOpinionService tDefaultOpinionService) {
		this.tDefaultOpinionService = tDefaultOpinionService;
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

	/**
	 * 
	 * @author wsd
	 * @desc 默认意见
	 * 
	 */
	private List<TDefaultOpinion> defaultOps;

	/**
	 * 
	 * @author wsd
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;

	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;

	/**
	 * 
	 * @author wsd
	 * @desc 默认意见服务
	 * 
	 */
	private ITDefaultOpinionService tDefaultOpinionService;

	private ITGeneralprocessModelthreeService generalprocessModelthreeService;

	/**
	 * 模式一服务
	 */
	private ITGeneralprocessModeloneService generalprocessModeloneService;
	
	public ITGeneralprocessModeloneService getGeneralprocessModeloneService() {
		return generalprocessModeloneService;
	}

	public void setGeneralprocessModeloneService(
			ITGeneralprocessModeloneService generalprocessModeloneService) {
		this.generalprocessModeloneService = generalprocessModeloneService;
	}

	public ITGeneralprocessModelthreeService getGeneralprocessModelthreeService() {
		return generalprocessModelthreeService;
	}

	public void setGeneralprocessModelthreeService(
			ITGeneralprocessModelthreeService generalprocessModelthreeService) {
		this.generalprocessModelthreeService = generalprocessModelthreeService;
	}

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	/**
	 * 
	 * @author yyx
	 * @desc 跳转到模式三的表单页面
	 * @return
	 * 
	 */
	public String toModelThree() {
		try {
			MUOUserSession muo = getCurrentOnlineUser();
			// 获取流程实例id
			String businessId = taskAssgineeDto.getExecutionId();
			taskName = taskAssgineeDto.getTaskName();
			// 获取流程配置主表对象
			TGeneralprocessMain main = this.generalprocessMainService
					.queryMainByBusinessId(businessId);
			ProcessModelOne one = new ProcessModelOne();
			one.setFlow_Id(businessId);
			modelOne = this.generalprocessModeloneService.queryModelOne(one);
			
			if(modelOne != null){
				this.setModelOne(modelOne);
			}
			
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
			ProcessModelThree newModelThree = new ProcessModelThree();
			if (businessId != null && taskName1 != null) {
				ProcessModelThree modelThree = new ProcessModelThree();
				modelThree.setFlow_id(businessId);
				modelThree.setTaskName(taskName1);
				newModelThree = this.generalprocessModelthreeService
						.queryModelThree(modelThree);
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
			if (newModelThree != null) {
				rm = "ProcessModelThree" + "-"
						+ newModelThree.getProcessModelId();
				map.remove(rm);
			}
			
			if(modelOne != null){
				rm = "ProcessModelOne" + "-" + modelOne.getProcessModelId();
				map.remove(rm);
			}

			this.setModelThree(newModelThree);

			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
					.returnAllObj(map);

			String fxJson = JSONArray.fromObject(beans).toString();
			taskAssgineeDto.setFxJson(fxJson);
			queryDefault(); 
		} catch (Exception e) {
			log.error("查询模式三表单信息失败", e);
		}
		return "toModelthree";
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
	 * @author yyx
	 * @desc 后台处理模式一的新增模式三表单、结束流程、记录流程日志
	 * @return
	 * @throws Exception
	 */
	public void handleModelThree() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {

				this.generalprocessModelthreeService.handleModelThree(muo, modelThree, modelOne, taskAssgineeDto, files, filesFileName,files2, files2FileName);

				this.updateProcessMistakes();

			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式一表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);

	}
	
    //模式1文件操作
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

	//模式3文件操作
	private File[] files;
	private String[] filesFileName;
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
	
	/**
	 * 查询提交人
	 */
	public String querySubmitter(){
		if (processSubmitter!=null&&!"".equals(processSubmitter)) {
			if (processSubmitter.getFlowId()!=null&&!"".equals(processSubmitter.getFlowId())) {
				processSubmitter=generalprocessMistakeService.querySubmitter(processSubmitter);
				
			}
		}
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
	
}