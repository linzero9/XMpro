package com.gotop.Generalprocess.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import com.eos.server.dict.DictManager;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelfiveDAO;
import com.gotop.Generalprocess.model.ProcessModelFive;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfiveService;
import com.gotop.Generalprocess.util.SpringPropertyResourceReader;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.service.ITModelFileService;
import com.gotop.util.FileUploadUtil;
import com.gotop.vo.system.MUOUserSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

public class TGeneralprocessModelfiveService implements
		ITGeneralprocessModelfiveService {
	/**
	 * 
	 * @abatorgenerated
	 */
	protected Logger log = Logger
			.getLogger(TGeneralprocessModelfiveService.class);

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	private ITGeneralprocessMainDAO generalprocessMainDAO;

	protected IGeneralprocessService generalprocessService;

	/**
	 * 通过spring注入的DAO对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModelfiveDAO tGeneralprocessModelfiveDAO;

	/**
	 * 通过spring注入DAO的set类.
	 * 
	 * @abatorgenerated
	 */
	public void settGeneralprocessModelfiveDAO(
			ITGeneralprocessModelfiveDAO tGeneralprocessModelfiveDAO)
			throws Exception {
		this.tGeneralprocessModelfiveDAO = tGeneralprocessModelfiveDAO;
	}
	
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
	 * 通过spring注入DAO的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModelfiveDAO gettGeneralprocessModelfiveDAO()
			throws Exception {
		return this.tGeneralprocessModelfiveDAO;
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
	public ProcessModelFive queryModelFive(ProcessModelFive modelFive) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (modelFive != null) {
			if (modelFive.getFlowId() != null
					&& !"".equals(modelFive.getFlowId())) {
				map.put("flow_id", modelFive.getFlowId());
			}
			if (modelFive.getTaskName() != null
					&& !"".equals(modelFive.getTaskName())) {
				map.put("taskName", modelFive.getTaskName());
			}
		}
		return this.tGeneralprocessModelfiveDAO.queryModelFive(map);
	}

	@Override
	public void handleModelFive(MUOUserSession muo, ProcessModelFive modelFive,
			TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName) throws Exception {
		
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		TaskAssgineeDto d1=null;
		TaskAssgineeDto newDto =null;
		
		modelFive.setTaskName(taskName);
		modelFive.setFlowId(taskAssgineeDto.getExecutionId());
		String conMatter = modelFive.getConMatter();
		if(conMatter != null){
			conMatter = conMatter.replace(" ", "");
		}
		modelFive.setConMatter(conMatter);
		if (modelFive.getProcessModelId() != null
				&& !"".equals(modelFive.getProcessModelId())) {
			// 修改模式五表单内容
			this.tGeneralprocessModelfiveDAO.uptModelFive(modelFive);

		} else {
			// 保存模式五表单内容
			
			this.tGeneralprocessModelfiveDAO.addModelFive(modelFive);
		}

		modelFive.setOpinion(modelFive.getOptionNew());

		// 获取流程实例id
		if(taskAssgineeDto != null){
		String executionId = taskAssgineeDto.getExecutionId();
		
		// 查询模式主板信息
		TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);
		
		// 新增或更新模式主板的rule和id
		if (main != null) {
			// 修改
			this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelFive, main, ProcessModelFive.class);
		} else {
			// 新增
			this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelFive, ProcessModelFive.class);
		}
			if(taskAssgineeDto.getBtnType() != null && !"1".equals(taskAssgineeDto.getBtnType())){

				// 模式五-提交操作
				// 审核通过
				// 提交下个节点
				 d1 = new TaskAssgineeDto();

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

				 newDto = this.generalprocessService
						.makeTaskAssgineeDto(null, muo, taskAssgineeDto);

				jbpmService.saceTaskAssignee(newDto);

				String submitType = taskAssgineeDto.getTransitionName();

				this.generalprocessService.insertApproveOpninion(modelFive, muo,
						nextTaskId, submitType, taskAssgineeDto);
			}
			
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
		 			       		obj.setModeId(String.valueOf(modelFive.getProcessModelId()));
		 			       		obj.setModeType("mod5");
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

}