package com.gotop.Generalprocess.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import com.eos.server.dict.DictManager;
import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModeloneDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModeltwoDAO;
import com.gotop.Generalprocess.model.GeneralprocessDto;
import com.gotop.Generalprocess.model.ProcessModel;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TApproveOpninionGP;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeltwoService;
import com.gotop.Generalprocess.util.SpringPropertyResourceReader;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.model.TProcessBusiness;
import com.gotop.jbpm.service.ITProcessBusinessService;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.service.ITModelFileService;
import com.gotop.opinion.dao.ITApproveOpninionDAO;
import com.gotop.util.FileUploadUtil;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;
import com.gotop.vo.tyjg.Omorganization;
import com.primeton.utils.Page;

public class GeneralprocessService implements IGeneralprocessService {

	protected Logger log = Logger.getLogger(GeneralprocessService.class);

	private IGeneralprocessDAO generalProcessDAO;
	
	/**
	 * 附件上传
	 */
   private  ITModelFileService tModelFileService;
   
   
	public ITModelFileService gettModelFileService() {
		return tModelFileService;
	}

	public void settModelFileService(ITModelFileService tModelFileService) {
		this.tModelFileService = tModelFileService;
	}

	/**
	 * 模式主表DAO
	 */
	private ITGeneralprocessMainDAO generalprocessMainDAO;

	/**
	 * 模式一的DAO
	 */
	private ITGeneralprocessModeloneDAO generalprocessModeloneDAO;

	/**
	 * 模式二的DAO
	 */
	private ITGeneralprocessModeltwoDAO generalprocessModeltwoDAO;

	protected ITApproveOpninionDAO tApproveOpninionDAO;

	private ITProcessBusinessService tProcessBusinessService;
	
	/**
	 * 模式二服务
	 */
	private ITGeneralprocessModeltwoService generalprocessModeltwoService;
	
	public ITGeneralprocessModeltwoService getGeneralprocessModeltwoService() {
		return generalprocessModeltwoService;
	}

	public void setGeneralprocessModeltwoService(
			ITGeneralprocessModeltwoService generalprocessModeltwoService) {
		this.generalprocessModeltwoService = generalprocessModeltwoService;
	}

	public ITProcessBusinessService gettProcessBusinessService() {
		return tProcessBusinessService;
	}

	public void settProcessBusinessService(
			ITProcessBusinessService tProcessBusinessService) {
		this.tProcessBusinessService = tProcessBusinessService;
	}

	public ITGeneralprocessModeltwoDAO getGeneralprocessModeltwoDAO() {
		return generalprocessModeltwoDAO;
	}

	public void setGeneralprocessModeltwoDAO(
			ITGeneralprocessModeltwoDAO generalprocessModeltwoDAO) {
		this.generalprocessModeltwoDAO = generalprocessModeltwoDAO;
	}

	public ITGeneralprocessModeloneDAO getGeneralprocessModeloneDAO() {
		return generalprocessModeloneDAO;
	}

	public void setGeneralprocessModeloneDAO(
			ITGeneralprocessModeloneDAO generalprocessModeloneDAO) {
		this.generalprocessModeloneDAO = generalprocessModeloneDAO;
	}

	public ITGeneralprocessMainDAO getGeneralprocessMainDAO() {
		return generalprocessMainDAO;
	}

	public void setGeneralprocessMainDAO(
			ITGeneralprocessMainDAO generalprocessMainDAO) {
		this.generalprocessMainDAO = generalprocessMainDAO;
	}

	public ITApproveOpninionDAO gettApproveOpninionDAO() {
		return tApproveOpninionDAO;
	}

	public void settApproveOpninionDAO(ITApproveOpninionDAO tApproveOpninionDAO) {
		this.tApproveOpninionDAO = tApproveOpninionDAO;
	}

	private JbpmService jbpmService;

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public IGeneralprocessDAO getGeneralProcessDAO() {
		return generalProcessDAO;
	}

	public void setGeneralProcessDAO(IGeneralprocessDAO generalProcessDAO) {
		this.generalProcessDAO = generalProcessDAO;
	}

	@Override
	public void handleModelOne(MUOUserSession muo, ProcessModelOne modelOne,
			TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName) throws Exception {
	
		
		// 当前节点id
		String taskId = "";
		String preTaskId = "";
		String nextTaskId = "";
		String submitType = "";
		TaskAssgineeDto dto1 = null;
		TProcessBusiness pb = null;
        
		// 获取流程实例id
		String executionId = taskAssgineeDto.getExecutionId();
    
		if (modelOne.getProcessModelId() != null
				&& !"".equals(modelOne.getProcessModelId())) {
			// 修改模式一
			// 当前时间
			String uptDate = TimeUtil.getCntDtStr(new Date(), "yyyyMMddHHmmss");
			// 赋值最后修改时间
			modelOne.setLast_up_time(uptDate);
			// 赋值最后修改人empid
			modelOne.setLast_up_name(String.valueOf(muo.getEmpid()));

			// 执行更新模式一
			this.generalprocessModeloneDAO.uptModelOne(modelOne);
			taskId = taskAssgineeDto.getNextTaskId();
			modelOne.setOpinion("");
			// 提交
			submitType = "05";
			// 修改流程信息
			// TProcessBusiness business =
			// jbpmService.findProcessBusiness(taskAssgineeDto);
			// business.setBusinessTitle(euip.getEpTitle());
			// jbpmService.updateProcessBusiness(business);
			
	          //////////////////////////////////////////////附件保存////////////////////////////////////////////////////
				if(files!=null){
					TModelFile	obj=new TModelFile();
		 	    	 String suffixStr = null;
		 	    	 String address="";
		 	    	String ioioio=	SpringPropertyResourceReader.getProperty("file_model");
		 	    	 address=DictManager.getDictName("ZHPT_FILE_PATH","01");
		 	    	Properties props=System.getProperties();
		 	    	System.out.println(props.getProperty("os.name"));
		 	    	if(address==null||"".equals(address)){
		 			     address=ServletActionContext.getServletContext().getRealPath("/uploadfile");
		 	    	}
		 	    	else {
		 	    	    	if(props.getProperty("os.name").indexOf("Windows")>=0)
		 	    		    	address=ioioio+address;
		 	    	 }  
		 	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		 	    		 String fileDate=sdf.format(new Date());//时间
		     	
		 		       	 for(int i=0;i<filesFileName.length;i++){
		 		    		 String uuid = UUID.randomUUID().toString();//UUID
		 		       		 suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名      		 
		 			       		obj.setExecutionId(modelOne.getFlow_Id());
		 			       		obj.setModeId(String.valueOf(modelOne.getProcessModelId()));
		 			       		obj.setModeType("mod1");
		 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
								obj.setModeFiles(content);
				       			       		
		 		       		  obj.setFileName(filesFileName[i]);
		 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
		 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

								tModelFileService.insert(obj);
				
		 		       	 }
				}
			
		} else {
			// 新增模式一
			// 新增模式一表单
			HashMap<String, Object> map = new HashMap<String, Object>();
			// 办理人为当前登录者
			map.put("user", String.valueOf(muo.getEmpid()));
			// 启动流程,获得TaskAssgineeDto对象,获得ExecutionId流程实例id和NextTaskId当前节点的taskid
			dto1 = jbpmService.startProcessByDefinition(
					taskAssgineeDto.getDefinitionId(), map);
			// 获取当前节点的taskid
			// 用于做节点结束后的上一个节点
			preTaskId = dto1.getNextTaskId();
			taskId = preTaskId;
			taskAssgineeDto.setExecutionId(dto1.getExecutionId());
			
			String taskName = jbpmService.getTaskNameById(preTaskId);
			// 模式一赋值流程id
			modelOne.setFlow_Id(dto1.getExecutionId());
			modelOne.setTaskName(taskName);
			// 创建时间
			String currDate = TimeUtil
					.getCntDtStr(new Date(), "yyyyMMddHHmmss");
			modelOne.setCreate_time(currDate);
			// 创建人empid
			modelOne.setCreate_name(String.valueOf(muo.getEmpid()));
			modelOne.setLast_up_time(currDate);
			// 创建人empid
			modelOne.setLast_up_name(String.valueOf(muo.getEmpid()));

			// 插入模式一的表单信息
			this.generalprocessModeloneDAO.addModelOne(modelOne);
	          //////////////////////////////////////////////附件保存////////////////////////////////////////////////////
				if(files!=null){
					TModelFile	obj=new TModelFile();
		 	    	 String suffixStr = null;
		 	    	 String address="";
		 	    	String ioioio=	SpringPropertyResourceReader.getProperty("file_model");
		 	    	 address=DictManager.getDictName("ZHPT_FILE_PATH","01");
		 	    	Properties props=System.getProperties();
		 	    	System.out.println(props.getProperty("os.name"));
		 	    	if(address==null||"".equals(address)){
		 			     address=ServletActionContext.getServletContext().getRealPath("/uploadfile");
		 	    	}
		 	    	else {
		 	    	    	if(props.getProperty("os.name").indexOf("Windows")>=0)
		 	    		    	address=ioioio+address;
		 	    	 }  
		 	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		 	    		 String fileDate=sdf.format(new Date());//时间
		     	
		 		       	 for(int i=0;i<filesFileName.length;i++){
		 		    		 String uuid = UUID.randomUUID().toString();//UUID
		 		       		 suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名      		 
		 			       		obj.setExecutionId(modelOne.getFlow_Id());
		 			       		obj.setModeId(String.valueOf(modelOne.getProcessModelId()));
		 			       		obj.setModeType("mod1");
		 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
								obj.setModeFiles(content);
				       			       		
		 		       		  obj.setFileName(filesFileName[i]);
		 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
		 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

								tModelFileService.insert(obj);
				
		 		       	 }
				}
			modelOne.setOpinion(modelOne.getHanldOption());
			// 保存流程的信息

			// 构建流程业务关系信息
			
			//需要客户姓名+流程名  modify
			
			modelOne.setPubCustName(modelOne.getCust_Name());
			modelOne.setPubFlowId(modelOne.getFlow_Id());
			
			pb = insertProcessBus(modelOne, taskAssgineeDto);
		
			// 提交
			submitType = "05";
			// 保存流程业务关系的信息
			jbpmService.saveProcessBusiness(muo, pb);
		}
		//提交模式一
		String btnType = taskAssgineeDto.getBtnType();
		String isFirst = taskAssgineeDto.getIsFirst();
		if (isFirst == null && taskAssgineeDto.getEmpIds() != null
				&& !"".equals(taskAssgineeDto.getEmpIds())){
			//submitType = "01";
		}
		
		
		
		if (!"1".equals(btnType)) {
			//提交按钮

			//给DTO赋值taskId
			taskAssgineeDto.setTaskId(taskId);
			
			TaskAssgineeDto d1 = new TaskAssgineeDto();
			d1.setTaskExeAssginee(String.valueOf(muo.getEmpid()));
			d1.setTaskId(taskId);
			
			// 当前节点签收
			jbpmService.assignTask(d1);
			// 当前节点完成
			jbpmService.completeTask(taskId,
					taskAssgineeDto.getTransitionName(), null);
			
			taskAssgineeDto.setPreTaskAssingee(muo.getEmpid());
			
			jbpmService.updateTaskAssigneeState(taskAssgineeDto);
			
			// 正常下一步
			nextTaskId = jbpmService.getNextTaskId(taskAssgineeDto
					.getExecutionId());
			taskAssgineeDto.setNextTaskId(nextTaskId);
			TaskAssgineeDto newDto = makeTaskAssgineeDto(null,muo, taskAssgineeDto);
			
			jbpmService.saceTaskAssignee(makeTaskAssgineeDto(pb,
					muo, taskAssgineeDto));
			
			submitType = taskAssgineeDto.getTransitionName();
			
			insertApproveOpninion(modelOne, muo, nextTaskId,
					submitType, taskAssgineeDto);
			
			// 查询模式主表信息
			TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);
			
			//起草人empid
			taskAssgineeDto.setBeginAssingee(muo.getEmpid());
			//起草人
			taskAssgineeDto.setBeginOrg(muo.getOrgid());
			// 新增或更新模式主表的rule和id
			if (main != null) {
				// 修改
				this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelOne, main, ProcessModelOne.class);
			} else {
				// 新增
				this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelOne, ProcessModelOne.class);
			}
          //////////////////////////////////////////////附件上传////////////////////////////////////////////////////
/*			if(files!=null){
				TModelFile	obj=new TModelFile();
	 	    	 String suffixStr = null;
	 	    	 String address="";
	 	    	String ioioio=	SpringPropertyResourceReader.getProperty("file_model");
	 	    	 address=DictManager.getDictName("ZHPT_FILE_PATH","01");
	 	    	Properties props=System.getProperties();
	 	    	System.out.println(props.getProperty("os.name"));
	 	    	if(address==null||"".equals(address)){
	 			     address=ServletActionContext.getServletContext().getRealPath("/uploadfile");
	 	    	}
	 	    	else {
	 	    	    	if(props.getProperty("os.name").indexOf("Windows")>=0)
	 	    		    	address=ioioio+address;
	 	    	 }  
	 	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
	 	    		 String fileDate=sdf.format(new Date());//时间
	     	
	 		       	 for(int i=0;i<filesFileName.length;i++){
	 		    		 String uuid = UUID.randomUUID().toString();//UUID
	 		       		 suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名      		 
	 			       		obj.setExecutionId(newDto.getExecutionId());
	 			       		obj.setModeId(String.valueOf(modelOne.getProcessModelId()));
	 			       		obj.setModeType("mod1");
	 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
							obj.setModeFiles(content);
			       			       		
	 		       		  obj.setFileName(filesFileName[i]);
	 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
	 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

							tModelFileService.insert(obj);
			
	 		       	 }
			}*/
	    	    
			
		}
		
	}

	@Override
	public void handleModelTwo(MUOUserSession muo, ProcessModelTwo modelTwo,
			TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName) throws Exception {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelTwo.setTaskName(taskName);
		modelTwo.setFlow_id(taskAssgineeDto.getExecutionId());
		
		if (modelTwo.getProcessModelId() != null
				&& !"".equals(modelTwo.getProcessModelId())){
			this.generalprocessModeltwoDAO.uptModelTwo(modelTwo);
		}else{
			// 保存模式二表单内容
			this.generalprocessModeltwoDAO.addModelTwo(modelTwo);
		}

		modelTwo.setOpinion(modelTwo.getOpninion_content());

		// 获取流程实例id
		String executionId = taskAssgineeDto.getExecutionId();

		// 查询模式主板信息
		TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);

		// 新增或更新模式主板的rule和id
		if (main != null) {
			// 修改
			this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelTwo, main, ProcessModelTwo.class);
		} else {
			// 新增
			this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelTwo, ProcessModelTwo.class);
		}

		String btnType = taskAssgineeDto.getBtnType();
		/* if(btnType.equals("2")){ */
		// 模式二-提交操作
		// 审核通过
		// 提交下个节点
		TaskAssgineeDto d1 = new TaskAssgineeDto();

		d1.setTaskId(taskId);
		d1.setTaskExeAssginee(String.valueOf(muo.getEmpid()));

		// 赋值当前节点id
		taskAssgineeDto.setTaskId(taskId);

		// 签收当前节点
		jbpmService.assignTask(d1);

		// 完成当前节点
		jbpmService.completeTask(taskId, taskAssgineeDto.getTransitionName(),
				null);

		taskAssgineeDto.setPreTaskAssingee(muo.getEmpid());

		jbpmService.updateTaskAssigneeState(taskAssgineeDto);

		// 赋值下个节点id
		String nextTaskId = jbpmService.getNextTaskId(taskAssgineeDto
				.getExecutionId());
		taskAssgineeDto.setNextTaskId(nextTaskId);

		// 当前节点执行人
		taskAssgineeDto.setTaskExeAssginee(String.valueOf(muo.getEmpid()));

		TaskAssgineeDto newDto = makeTaskAssgineeDto(null,muo, taskAssgineeDto);

		jbpmService.saceTaskAssignee(newDto);
		
		String submitType ="";
		submitType = taskAssgineeDto.getTransitionName();
		/**
		 * submitType  操作类型
		 *//*
		if("结束".equals(taskAssgineeDto.getTargetName())){
			//结束
			submitType="08";
		}else if("退回".equals(taskAssgineeDto.getTransitionName())){
			//退回
			submitType="02";
		}else{
			//通过
			submitType="01";
		}
		*/
		insertApproveOpninion(modelTwo, muo, nextTaskId,
				submitType, taskAssgineeDto);
		
		
		
        //////////////////////////////////////////////附件上传////////////////////////////////////////////////////
			if(files!=null){
				TModelFile	obj=new TModelFile();
	 	    	 String suffixStr = null;
	 	    	 String address="";
	 	    	String ioioio=	SpringPropertyResourceReader.getProperty("file_model");
	 	    	 address=DictManager.getDictName("ZHPT_FILE_PATH","01");
	 	    	Properties props=System.getProperties();
	 	    	System.out.println(props.getProperty("os.name"));
	 	    	if(address==null||"".equals(address))
	 			     address=ServletActionContext.getServletContext().getRealPath("/uploadfile");
	 	    	else {
	 	    	    	if(props.getProperty("os.name").indexOf("Windows")>=0)
	 	    		    	address=ioioio+address;
	 	    	 }  
	 	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
	 	    		 String fileDate=sdf.format(new Date());//时间
	     	
	 		       	 for(int i=0;i<filesFileName.length;i++){
	 		    		 String uuid = UUID.randomUUID().toString();//UUID
	 		       		 suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名      		 
	 			       		obj.setExecutionId(newDto.getExecutionId());
	 			       		obj.setModeId(String.valueOf(modelTwo.getProcessModelId()));
	 			       		obj.setModeType("mod2");
	 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
							obj.setModeFiles(content);
			       			       		
	 		       		  obj.setFileName(filesFileName[i]);
	 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
	 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

							tModelFileService.insert(obj);
			
	 		       	 }
			}

	}

	/**
	 * 生成流程业务信息表
	 * 
	 * @param modelOne
	 * @param dto
	 * @return
	 */
	public TProcessBusiness insertProcessBus(ProcessModel model,
			TaskAssgineeDto dto) {
		TProcessBusiness processBusiness = new TProcessBusiness();
		try {
			processBusiness.setBusinessKey(model.getProcessModelId());
			processBusiness.setBusinessType(dto.getBusinessType());
			
			//需要客户姓名+流程名  modify  wujiajun
			processBusiness.setBusinessTitle(dto.getProcessName()+"-"+model.getPubCustName());
			processBusiness.setExecutionId(model.getPubFlowId());
		} catch (Exception e) {
			log.error("生成实例标题信息", e);
		}
		return processBusiness;
	}

	/**
	 * 生成任务实体。[jbpm]
	 * 
	 * @return
	 */
	public TaskAssgineeDto makeTaskAssgineeDto(TProcessBusiness pb,
			MUOUserSession muo, TaskAssgineeDto dto) {
		TaskAssgineeDto taskAssgineeDto = new TaskAssgineeDto();
		try {
			taskAssgineeDto.setExecutionId(dto.getExecutionId());
			taskAssgineeDto.setPreTaskAssingee(muo.getEmpid());
			taskAssgineeDto.setPreTaskId(dto.getTaskId());
			taskAssgineeDto.setPreTaskOrg(muo.getOrgid());
			String currDate = TimeUtil
					.getCntDtStr(new Date(), "yyyyMMddHHmmss");
			taskAssgineeDto.setPreTaskTime(currDate);
			taskAssgineeDto.setEmpIds(dto.getEmpIds());
			taskAssgineeDto.setEmpNames(dto.getEmpNames());
			taskAssgineeDto.setNextTaskId(dto.getNextTaskId());
			if(pb != null){
				if (pb.getBusinessKey() != null) {
					taskAssgineeDto.setBusinessKey(pb.getBusinessKey());
				}
			}
			taskAssgineeDto.setBusinessType(dto.getBusinessType());
			taskAssgineeDto.setTargetName(dto.getTargetName());
			// 存储节点配置对象主键
			taskAssgineeDto.setTaskExeConfigId(dto.getTaskExeConfigId());
		} catch (Exception e) {
			log.error("获取任务实体", e);
		}
		return taskAssgineeDto;
	}



	
	/**
	 * 生成意见
	 * 
	 * @param muo
	 * @param taskId
	 */
	@Override
	public void insertApproveOpninion(ProcessModel processModel,
			MUOUserSession muo, String taskId, String type, TaskAssgineeDto dto) {
		/**
		 * type
		 * 01-通过
		 * 02-退回
		 * 03-阅毕
		 * 04-转发
		 * 05-提交
		 * 06-发布
		 * 07-反馈
		 * 08-结束
		 * 09-部室办理
		 * 10-部室反馈
		 * 11-转督办
		 */
		try {
			if (processModel != null
					&& processModel.getProcessModelId() != null
					&& !"".equals(processModel.getProcessModelId())) {
				if (processModel.getOpinion() != null) {
					String currDate = TimeUtil.getCntDtStr(new Date(),
							"yyyyMMddHHmmss");
					TApproveOpninionGP opninion = new TApproveOpninionGP();
					//opninion.setResourceId(processModel.getProcessModelId());
					opninion.setFlowId(dto.getExecutionId());
					opninion.setOperator(muo.getEmpid());
					opninion.setOrgid(String.valueOf(muo.getOrgid()));
					opninion.setResourceType(dto.getBusinessType());
					//操作类型
					opninion.setOperatorType(type);
					opninion.setOperaterDate(currDate.substring(0, 8));
					opninion.setOperaterTime(currDate.substring(8));
					//操作的意见
					opninion.setOpninionContent(processModel.getOpinion());

					opninion.setNextorgname("");
					if (dto.getEmpNames() != null
							&& !"null".equals(dto.getEmpNames())
							&& !"".equals(dto.getEmpNames())) {
						opninion.setNextOprName(dto.getEmpNames());
						List<HashMap<String, Object>> list = this.generalProcessDAO
								.queryOrgName(dto.getEmpIds());
						for (int i = 0; i < list.size(); i++) {
							opninion.setNextorgname(opninion.getNextorgname()
									+ (String) list.get(i).get("ORGNAME"));
							if (i != list.size() - 1) {
								opninion.setNextorgname(opninion
										.getNextorgname() + ",");
							}
						}
					} else
						opninion.setNextOprName("");
					// 需要taskId
					opninion.setNodeId(taskId);
					// opninion.setNodeName(euip.getNodeName1());
					tApproveOpninionDAO.insertOpninionGP(opninion);
				}
			}
		} catch (Exception e) {
			// 保存审核意见失败。
			log.error("保存审核意见失败。", e);
		}
	}

	@Override
	public String isHaveParentOrgId(String orgcode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orgcode", orgcode);
		return this.generalProcessDAO.isHaveParentOrgId(map);
	}

	@Override
	public Omorganization getParentOrgId(String orgcode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orgcode", orgcode);
		return this.generalProcessDAO.getParentOrgId(map);
	}

	@SuppressWarnings("unused")
	@Override
	public List<GeneralprocessDto> queryGeneralprocessList(MUOUserSession muo,
			GeneralprocessDto generalprocessDto, Page page) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		if(generalprocessDto!=null){
			if(generalprocessDto.getOneCategory()!=null && !"".equals(generalprocessDto.getOneCategory())){
				String[] oneCategorys=generalprocessDto.getOneCategory().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("oneCategory",oneCategory);
			}
			if(generalprocessDto.getLoanCategory()!=null && !"".equals(generalprocessDto.getLoanCategory())){
				String[] loanCategorys=generalprocessDto.getLoanCategory().split(", ");
				String loanCategory="";
				try {
					loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("loanCategory",loanCategory);
			}
			if(generalprocessDto.getMinoperaterDateStrat()!=null && !"".equals(generalprocessDto.getMinoperaterDateStrat())){
				map.put("minoperaterDateStrat", generalprocessDto.getMinoperaterDateStrat());
			}
			if(generalprocessDto.getMinoperaterDateEnd()!=null && !"".equals(generalprocessDto.getMinoperaterDateEnd())){
				map.put("minoperaterDateEnd", generalprocessDto.getMinoperaterDateEnd());
			}
			if(generalprocessDto.getAppTimeStrat()!=null && !"".equals(generalprocessDto.getAppTimeStrat())){
				map.put("appTimeStrat", generalprocessDto.getAppTimeStrat());
			}
			if(generalprocessDto.getSupportCategory()!=null && !"".equals(generalprocessDto.getSupportCategory())){
				String[] supportCategorys=generalprocessDto.getSupportCategory().split(", ");
				String supportCategory="";
				try {
					supportCategory = Obj2StrUtils.join(supportCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("supportCategory",supportCategory);
			}
			if(generalprocessDto.getAppTimeEnd()!=null && !"".equals(generalprocessDto.getAppTimeEnd())){
				map.put("appTimeEnd", generalprocessDto.getAppTimeEnd());
			}
			if(generalprocessDto.getReporttimeStrat()!=null && !"".equals(generalprocessDto.getReporttimeStrat())){
				map.put("reporttimeStrat", generalprocessDto.getReporttimeStrat());
			}
			if(generalprocessDto.getReporttimeEnd()!=null && !"".equals(generalprocessDto.getReporttimeEnd())){
				map.put("reporttimeEnd", generalprocessDto.getReporttimeEnd());
			}
			if(generalprocessDto.getOrgCodeOne()!=null && !"".equals(generalprocessDto.getOrgCodeOne())){
				map.put("orgCodeOne", generalprocessDto.getOrgCodeOne());
			}
			if(generalprocessDto.getOrgCodeTwo()!=null && !"".equals(generalprocessDto.getOrgCodeTwo())){
				map.put("orgCodeTwo", generalprocessDto.getOrgCodeTwo());
			}
			if(generalprocessDto.getCust_Name()!=null && !"".equals(generalprocessDto.getCust_Name())){
				map.put("cust_Name", generalprocessDto.getCust_Name());
			}
			if(generalprocessDto.getIsEnd()!=null && !"".equals(generalprocessDto.getIsEnd())){
				map.put("isEnd", generalprocessDto.getIsEnd());
			}
			if(generalprocessDto.getCreator()!=null && !"".equals(generalprocessDto.getCreator())){
				map.put("creator", generalprocessDto.getCreator());
			}
			if(generalprocessDto.getFdxdy()!=null && !"".equals(generalprocessDto.getFdxdy())){
				map.put("fdxdy", generalprocessDto.getFdxdy());
			}
			if(generalprocessDto.getDyApp()!=null && !"".equals(generalprocessDto.getDyApp())){
				map.put("dyApp", generalprocessDto.getDyApp());
			}
			if(generalprocessDto.getDeApp()!=null && !"".equals(generalprocessDto.getDeApp())){
				map.put("deApp", generalprocessDto.getDeApp());
			}
			if(generalprocessDto.getDyCheck()!=null && !"".equals(generalprocessDto.getDyCheck())){
				map.put("dyCheck", generalprocessDto.getDyCheck());
			}
			if(generalprocessDto.getDeCheck()!=null && !"".equals(generalprocessDto.getDeCheck())){
				map.put("deCheck", generalprocessDto.getDeCheck());
			}
			if(generalprocessDto.getProcessName()!=null && !"".equals(generalprocessDto.getProcessName())){
				map.put("processName", generalprocessDto.getProcessName());
			}
		}
		List<GeneralprocessDto> generalprocessDtos=null;
		String orgcode=muo.getOrgcode();
		String parentOrgId = this.isHaveParentOrgId(orgcode);
		Omorganization om = null;
		String empId = String.valueOf(muo.getEmpid());
		String[] positionIdArray = muo.getPosiCode();
		if(Arrays.asList(positionIdArray).contains("xdkhjl")){
			map.put("empId", empId);
			generalprocessDtos=this.generalProcessDAO.queryGeneralprocessList(map,page);
		}else if(parentOrgId != null){
		map.put("orgcode", orgcode);
		generalprocessDtos=this.generalProcessDAO.queryGeneralprocessList(map,page);
		}else {
			generalprocessDtos=this.generalProcessDAO.queryGeneralprocessList(map,page);
		}
		
		return generalprocessDtos;
	}

}
