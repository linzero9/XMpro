package com.gotop.Generalprocess.service.impl;

import com.eos.server.dict.DictManager;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModeloneDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelthreeDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelthreeService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.service.ITModelFileService;
import com.gotop.util.FileUploadUtil;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

public class TGeneralprocessModelthreeService implements ITGeneralprocessModelthreeService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelthreeService.class);

    
    protected JbpmService jbpmService;
    
    protected ITGeneralprocessMainDAO generalprocessMainDAO;
    
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
     * 模式一DAO
     */
    protected ITGeneralprocessModeloneDAO generalprocessModeloneDAO;
    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelthreeDAO tGeneralprocessModelthreeDAO;
    
    protected IGeneralprocessService generalprocessService;

    public ITGeneralprocessModeloneDAO getGeneralprocessModeloneDAO() {
		return generalprocessModeloneDAO;
	}

	public void setGeneralprocessModeloneDAO(
			ITGeneralprocessModeloneDAO generalprocessModeloneDAO) {
		this.generalprocessModeloneDAO = generalprocessModeloneDAO;
	}

	public IGeneralprocessService getGeneralprocessService() {
		return generalprocessService;
	}

	public void setGeneralprocessService(
			IGeneralprocessService generalprocessService) {
		this.generalprocessService = generalprocessService;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public ITGeneralprocessMainDAO getGeneralprocessMainDAO() {
		return generalprocessMainDAO;
	}

	public void setGeneralprocessMainDAO(
			ITGeneralprocessMainDAO generalprocessMainDAO) {
		this.generalprocessMainDAO = generalprocessMainDAO;
	}

	/**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelthreeDAO(ITGeneralprocessModelthreeDAO tGeneralprocessModelthreeDAO) throws Exception {
        this.tGeneralprocessModelthreeDAO = tGeneralprocessModelthreeDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelthreeDAO gettGeneralprocessModelthreeDAO() throws Exception {
        return this.tGeneralprocessModelthreeDAO;
    }


	@Override
	public void handleModelThree(MUOUserSession muo,
			ProcessModelThree modelThree,ProcessModelOne modelOne, TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName) throws Exception {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelThree.setTaskName(taskName);
		modelThree.setFlow_id(taskAssgineeDto.getExecutionId());
		
		
		//更新模式一
		
		if(modelOne != null){
			if (modelOne.getProcessModelId() != null
					&& !"".equals(modelOne.getProcessModelId())){
				String uptDate = TimeUtil.getCntDtStr(new Date(), "yyyyMMddHHmmss");
				// 赋值最后修改时间
				modelOne.setLast_up_time(uptDate);
				// 赋值最后修改人empid
				modelOne.setLast_up_name(String.valueOf(muo.getEmpid()));
				this.generalprocessModeloneDAO.uptModelOne(modelOne);
			}
		}
		if (modelThree.getProcessModelId() != null
				&& !"".equals(modelThree.getProcessModelId())){
			//更新模式三
			this.tGeneralprocessModelthreeDAO.uptModelThree(modelThree);
		}else{
			//保存模式三
			this.tGeneralprocessModelthreeDAO.addModelThree(modelThree);
		}

		
		// 保存模式三表单内容
		

		modelThree.setOpinion(modelThree.getOpninion_content());

		// 获取流程实例id
		String executionId = taskAssgineeDto.getExecutionId();

		// 查询模式主表信息
		TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);

		// 新增或更新模式主板的rule和id
		if (main != null) {
			// 修改
			this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelThree, main, ProcessModelThree.class);
		} else {
			// 新增
			this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelThree, ProcessModelThree.class);
		}

		//String btnType = taskAssgineeDto.getBtnType();
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

		TaskAssgineeDto newDto = makeTaskAssgineeDtoNoPd(muo, taskAssgineeDto);

		jbpmService.saceTaskAssignee(newDto);

		String submitType = "";
		
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
		}*/
		
		this.generalprocessService.insertApproveOpninion(modelThree, muo, nextTaskId,
				submitType, taskAssgineeDto);
		
		
        //////////////////////////////////////////////附件上传////////////////////////////////////////////////////
			if(files!=null){
				TModelFile	obj=new TModelFile();
	 	    	 String suffixStr = null;
	 	    	 String address="";

	 	    	 address=DictManager.getDictName("ZHPT_FILE_PATH","01");
	 	    	Properties props=System.getProperties();
	 	    	System.out.println(props.getProperty("os.name"));
	 	    	if(address==null||"".equals(address))
	 			     address=ServletActionContext.getServletContext().getRealPath("/uploadfile");
	 	    	else {
	 	    	    	if(props.getProperty("os.name").indexOf("Windows")>=0)
	 	    		    	address="f:"+address;
	 	    	 }  
	 	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
	 	    		 String fileDate=sdf.format(new Date());//时间
	     	
	 		       	 for(int i=0;i<filesFileName.length;i++){
	 		    		 String uuid = UUID.randomUUID().toString();//UUID
	 		       		 suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名      		 
	 			       		obj.setExecutionId(newDto.getExecutionId());
	 			       		obj.setModeId(String.valueOf(modelThree.getProcessModelId()));
	 			       		obj.setModeType("mod3");
	 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
							obj.setModeFiles(content);
			       			       		
	 		       		  obj.setFileName(filesFileName[i]);
	 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
	 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

							tModelFileService.insert(obj);
			
	 		       	 }
			}
		
		
	}

	@Override
	public ProcessModelThree queryModelThree(ProcessModelThree modelThree) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelThree != null){
			if(modelThree.getFlow_id() != null && !"".equals(modelThree.getFlow_id())){
				map.put("flow_id", modelThree.getFlow_id());
			}
			if(modelThree.getTaskName() != null && !"".equals(modelThree.getTaskName())){
				map.put("taskName", modelThree.getTaskName());
			}
		}
		return this.tGeneralprocessModelthreeDAO.queryModelThree(map);
	}
	
	
	public TaskAssgineeDto makeTaskAssgineeDtoNoPd(MUOUserSession muo,
			TaskAssgineeDto dto) {
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
			// taskAssgineeDto.setBusinessKey(pb.getBusinessKey());
			taskAssgineeDto.setBusinessType(dto.getBusinessType());
			taskAssgineeDto.setTargetName(dto.getTargetName());
			// 存储节点配置对象主键
			taskAssgineeDto.setTaskExeConfigId(dto.getTaskExeConfigId());
		} catch (Exception e) {
			log.error("获取任务实体", e);
		}
		return taskAssgineeDto;
	}
}