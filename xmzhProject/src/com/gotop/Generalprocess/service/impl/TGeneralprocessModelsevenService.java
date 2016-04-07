package com.gotop.Generalprocess.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import com.eos.server.dict.DictManager;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelsevenDAO;
import com.gotop.Generalprocess.model.ProcessModelFive;
import com.gotop.Generalprocess.model.ProcessModelSeven;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsevenService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.service.ITModelFileService;
import com.gotop.util.FileUploadUtil;
import com.gotop.vo.system.MUOUserSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

public class TGeneralprocessModelsevenService implements ITGeneralprocessModelsevenService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelsevenService.class);

	/**
	 * jbpm服务
	 */
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
	
	
    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsevenDAO tGeneralprocessModelsevenDAO;

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
    public void settGeneralprocessModelsevenDAO(ITGeneralprocessModelsevenDAO tGeneralprocessModelsevenDAO) throws Exception {
        this.tGeneralprocessModelsevenDAO = tGeneralprocessModelsevenDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelsevenDAO gettGeneralprocessModelsevenDAO() throws Exception {
        return this.tGeneralprocessModelsevenDAO;
    }

	@Override
	public ProcessModelSeven queryModelSeven(ProcessModelSeven modelSeven) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (modelSeven != null) {
			if (modelSeven.getFlowId() != null
					&& !"".equals(modelSeven.getFlowId())) {
				map.put("flow_id", modelSeven.getFlowId());
			}
			if (modelSeven.getTaskName() != null
					&& !"".equals(modelSeven.getTaskName())) {
				map.put("taskName", modelSeven.getTaskName());
			}
		}
		return this.tGeneralprocessModelsevenDAO.queryModelSeven(map);
	}

	@Override
	public void handleModelSeven(MUOUserSession muo,
			ProcessModelSeven modelSeven, TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName )throws Exception {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		TaskAssgineeDto newDto =null;
		
		modelSeven.setTaskName(taskName);
		modelSeven.setFlowId(taskAssgineeDto.getExecutionId());
		
		if (modelSeven.getProcessModelId() != null
				&& !"".equals(modelSeven.getProcessModelId())) {
			// 修改模式五表单内容
			this.tGeneralprocessModelsevenDAO.uptModelSeven(modelSeven);

		} else {
			// 保存模式五表单内容
			
			this.tGeneralprocessModelsevenDAO.addModelSeven(modelSeven);
		}

		modelSeven.setOpinion(modelSeven.getOptionNews());
		
		if(taskAssgineeDto != null){
		String executionId = taskAssgineeDto.getExecutionId();
		
		// 查询模式主板信息
		TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);
		
		// 新增或更新模式主板的rule和id
		if (main != null) {
			// 修改
			this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelSeven, main, ProcessModelSeven.class);
		} else {
			// 新增
			this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelSeven, ProcessModelSeven.class);
		}
			if(taskAssgineeDto.getBtnType() != null && !"1".equals(taskAssgineeDto.getBtnType())){

				// 模式七-提交操作
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

				 newDto = this.generalprocessService
						.makeTaskAssgineeDto(null, muo, taskAssgineeDto);

				jbpmService.saceTaskAssignee(newDto);

				String submitType = taskAssgineeDto.getTransitionName();

				this.generalprocessService.insertApproveOpninion(modelSeven, muo,
						nextTaskId, submitType, taskAssgineeDto);
			}
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
		 			       		obj.setModeId(String.valueOf(modelSeven.getProcessModelId()));
		 			       		obj.setModeType("mod7");
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