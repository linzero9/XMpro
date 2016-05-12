package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessModelEight;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.model.TApproveOpninionGP;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessMistakeService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeleightService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITApproveOpninionService;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

public class TGeneralprocessModeleightAction extends BaseAction {
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
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModeleightService tGeneralprocessModeleigthService;
	
	
    private  ITApproveOpninionService tApproveOpninionService;
    
    

	public ITApproveOpninionService gettApproveOpninionService() {
		return tApproveOpninionService;
	}

	public void settApproveOpninionService(
			ITApproveOpninionService tApproveOpninionService) {
		this.tApproveOpninionService = tApproveOpninionService;
	}

	/**
	 * 
	 * @author yyx
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	private String taskName;

	private ProcessModelEight modelEight;

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;
	
	private List<TDefaultOpinion> defaultOps;
	
	private ITDefaultOpinionService tDefaultOpinionService;
	
	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;

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

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	/**
	 * 通过spring注入Service的set类.
	 * 
	 * @abatorgenerated
	 */
	public void settGeneralprocessModeleigthService(
			ITGeneralprocessModeleightService tGeneralprocessModeleigthService) {
		this.tGeneralprocessModeleigthService = tGeneralprocessModeleigthService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModeleightService gettGeneralprocessModeleigthService() {
		return this.tGeneralprocessModeleigthService;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ProcessModelEight getModelEight() {
		return modelEight;
	}

	public void setModelEight(ProcessModelEight modelEight) {
		this.modelEight = modelEight;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	/**
	 * 
	 * @author yyx
	 * @desc 跳转到模式三的表单页面
	 * @return
	 * 
	 */
	public String toModelEight() {
		try {

			// 获取流程实例id
			String businessId = taskAssgineeDto.getExecutionId();
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
			
			taskName= taskAssgineeDto.getTaskName();
			
			String taskName1 = "";
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
			ProcessModelEight modelEight2 = new ProcessModelEight();
			modelEight2.setFlow_id(businessId);
			modelEight2.setTaskName(taskName1);
			ProcessModelEight newModelEight = new ProcessModelEight();
			newModelEight = this.tGeneralprocessModeleigthService
					.queryModelEight(modelEight2);

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
			if (newModelEight != null) {
				rm = "ProcessModelEight" + "-"
						+ newModelEight.getProcessModelId();
				map.remove(rm);
			}
			
			//加入公积金提交时间为上一个节点的 提交时间！（当公积金提交时间为空的时候）
			
		  	if(newModelEight==null){
        		newModelEight= new ProcessModelEight();
        	}
			
			if(newModelEight.getTjgjjsj()==null||newModelEight.getTjgjjsj()==""||newModelEight==null){
				

				
		        HashMap hm = new HashMap();
		        hm.put("resourceFlow", taskAssgineeDto.getExecutionId());
		        List<TApproveOpninionGP> data = tApproveOpninionService.queryViewListForGP(hm,page);
		        for (TApproveOpninionGP  Gp : data) {
		        	
		      
		        	
		        	newModelEight.setTjgjjsj(Gp.getOperaterDate());
		        	break;
					
				}
		        
				System.out.println("加入公积金提交时间为上一个节点的 提交时间");
				
			}
			
			
			
			
			
			this.setModelEight(newModelEight);

			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
					.returnAllObj(map);

			String fxJson = JSONArray.fromObject(beans).toString();
			taskAssgineeDto.setFxJson(fxJson);
			queryDefault(); 
		} catch (Exception e) {
			log.error("查询模式八表单信息失败", e);
		}
		// queryDefault();
		return "toModelEight";
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
	 * @desc 后台处理模式一的新增模式八表单、结束流程、记录流程日志
	 * @return
	 * @throws Exception
	 */
	public void handleModelEight() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.tGeneralprocessModeleigthService.handleModelEight(muo, modelEight, taskAssgineeDto, files, filesFileName);
				this.updateProcessMistakes();
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式八表单失败！]", e);
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