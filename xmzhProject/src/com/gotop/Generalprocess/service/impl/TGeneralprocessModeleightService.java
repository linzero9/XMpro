package com.gotop.Generalprocess.service.impl;

import com.eos.server.dict.DictManager;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModeleightDAO;
import com.gotop.Generalprocess.model.ProcessModelEight;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeleightService;
import com.gotop.Generalprocess.util.SpringPropertyResourceReader;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.service.ITModelFileService;
import com.gotop.util.FileUploadUtil;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

public class TGeneralprocessModeleightService implements ITGeneralprocessModeleightService {
    /**
	 * @abatorgenerated
	 */
	protected Logger log = Logger
			.getLogger(TGeneralprocessModeleightService.class);
	/**
	 * 通过spring注入的DAO对象.
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModeleightDAO tGeneralprocessModeleightDAO;
	
	private JbpmService jbpmService;
    private ITGeneralprocessMainDAO generalprocessMainDAO;
    protected IGeneralprocessService generalprocessService;
	
	
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

    
    
	public ITGeneralprocessModeleightDAO gettGeneralprocessModeleightDAO() {
		return tGeneralprocessModeleightDAO;
	}

	public void settGeneralprocessModeleightDAO(
			ITGeneralprocessModeleightDAO tGeneralprocessModeleightDAO) {
		this.tGeneralprocessModeleightDAO = tGeneralprocessModeleightDAO;
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

	public IGeneralprocessService getGeneralprocessService() {
		return generalprocessService;
	}

	public void setGeneralprocessService(
			IGeneralprocessService generalprocessService) {
		this.generalprocessService = generalprocessService;
	}

	@Override
	public ProcessModelEight queryModelEight(ProcessModelEight modelEight2) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelEight2 != null){
			if(modelEight2.getFlow_id() != null && !"".equals(modelEight2.getFlow_id())){
				map.put("flow_id", modelEight2.getFlow_id());
			}
			if(modelEight2.getTaskName() != null && !"".equals(modelEight2.getTaskName())){
				map.put("taskName", modelEight2.getTaskName());
			}
		}
		return this.tGeneralprocessModeleightDAO.queryModelEight(map);
	}

	@Override
	public void handleModelEight(MUOUserSession muo,
			ProcessModelEight modelEight, TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName )throws Exception {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelEight.setTaskName(taskName);
		modelEight.setFlow_id(taskAssgineeDto.getExecutionId());
		
		if (modelEight.getProcessModelId() != null
				&& !"".equals(modelEight.getProcessModelId())){
			//更新模式三
			this.tGeneralprocessModeleightDAO.uptModelEight(modelEight);
		}else{
			//保存模式三
			this.tGeneralprocessModeleightDAO.addModelEight(modelEight);
		}

		// 保存模式三表单内容
		

		modelEight.setOpinion(modelEight.getOpninion_content());

		// 获取流程实例id
		String executionId = taskAssgineeDto.getExecutionId();

		// 查询模式主表信息
		TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);

		// 新增或更新模式主板的rule和id
		if (main != null) {
			// 修改
			this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelEight, main, ProcessModelEight.class);
		} else {
			// 新增
			this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelEight, ProcessModelEight.class);
		}

		String btnType = taskAssgineeDto.getBtnType();
		/* if(btnType.equals("2")){ */
		// 模式二-提交操作
		// 审核通过
		// 提交下个节点
		if (!"1".equals(btnType)) {
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
		 */
/*		if("结束".equals(taskAssgineeDto.getTargetName())){
			//结束
			submitType="08";
		}else if("退回".equals(taskAssgineeDto.getTransitionName())){
			//退回
			submitType="02";
		}else{
			//通过
			submitType="01";
		}*/
		
		this.generalprocessService.insertApproveOpninion(modelEight, muo, nextTaskId,
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
	 			       		obj.setModeId(String.valueOf(modelEight.getProcessModelId()));
	 			       		obj.setModeType("mod8");
	 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
							obj.setModeFiles(content);
			       			       		
	 		       		  obj.setFileName(filesFileName[i]);
	 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
	 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

							tModelFileService.insert(obj);
			
	 		       	 }
			}
		
		}
		
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