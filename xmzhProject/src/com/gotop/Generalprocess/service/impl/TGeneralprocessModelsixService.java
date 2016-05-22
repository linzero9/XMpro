package com.gotop.Generalprocess.service.impl;

import com.eos.server.dict.DictManager;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelsixDAO;

import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelSix;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.gotop.Generalprocess.util.SpringPropertyResourceReader;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.model.TProcessBusiness;
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

import org.apache.derby.tools.sysinfo;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;
/**
 * 
 * @author wujiajun
 * 
 *
 */
public class TGeneralprocessModelsixService implements ITGeneralprocessModelsixService {
	
	
	

    private JbpmService jbpmService;
    
    
    private ITGeneralprocessMainDAO generalprocessMainDAO;
    
    private IGeneralprocessService generalprocessService;
    

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
    
	
	
	
	
	
	
    public IGeneralprocessService getGeneralprocessService() {
		return generalprocessService;
	}

	public void setGeneralprocessService(
			IGeneralprocessService generalprocessService) {
		this.generalprocessService = generalprocessService;
	}

	public ITGeneralprocessMainDAO getGeneralprocessMainDAO() {
		return generalprocessMainDAO;
	}

	public void setGeneralprocessMainDAO(
			ITGeneralprocessMainDAO generalprocessMainDAO) {
		this.generalprocessMainDAO = generalprocessMainDAO;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	/**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelsixService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsixDAO tGeneralprocessModelsixDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelsixDAO(ITGeneralprocessModelsixDAO tGeneralprocessModelsixDAO) throws Exception {
        this.tGeneralprocessModelsixDAO = tGeneralprocessModelsixDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelsixDAO gettGeneralprocessModelsixDAO() throws Exception {
        return this.tGeneralprocessModelsixDAO;
    }
    
    
    public   ProcessModelSix queryModelSix(HashMap<String, Object> map){
    return 	tGeneralprocessModelsixDAO.queryModelSix(map);
    }

    public  void addModelSix(ProcessModelSix modelSix){
    	tGeneralprocessModelsixDAO.addModelSix(modelSix);
    }

    
    public void uptModelSix(ProcessModelSix modelSix){
    	tGeneralprocessModelsixDAO.uptModelSix(modelSix);
    }

    
    public ProcessModelSix queryModelSixById(String processModelId){
    	return   tGeneralprocessModelsixDAO.queryModelSixById(processModelId);
    }

	@Override
	public ProcessModelSix queryModelSixByFlowIdAndTaskName(ProcessModelSix six) {
		return   tGeneralprocessModelsixDAO.queryModelSixByFlowIdAndTaskName(six);
	}

	@Override
	public void handleModelSix(MUOUserSession muo,
			ProcessModelSix Six, TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName,
			String... otherParam) throws Exception {

		String taskId = "";
		String preTaskId = "";
		String nextTaskId = "";
		String submitType = "";
		TaskAssgineeDto dto1 = null;
		TProcessBusiness pb = null;	
		//.首先判断是不是第一次发起  
		//是：创建流程start 保存模式6 
		//否：｛1.有数据 更新 模式6  2. 没数据 新增  模式6｝
		
		if("start".equals(taskAssgineeDto.getStartFlag())){
			//表示第一次发起  
           //第一次发起
			// 新增模式
			// 新增模式表单
			HashMap<String, Object> map = new HashMap<String, Object>();
			// 办理人为当前登录者
			map.put("user", String.valueOf(muo.getEmpid()));
			// 启动流程,获得TaskAssgineeDto对象,获得ExecutionId流程实例id和NextTaskId当前节点的taskid
			dto1 = jbpmService.startProcessByDefinition(
					taskAssgineeDto.getDefinitionId(), map);		
			// 获取当前节点的taskid
			preTaskId = dto1.getNextTaskId();
			taskId = preTaskId;
			taskAssgineeDto.setExecutionId(dto1.getExecutionId());
			String taskName = jbpmService.getTaskNameById(preTaskId);
			Six.setTaskName(taskName);

			/**
			 * flowId  要赋值
			 */
			Six.setFlowId(dto1.getExecutionId());
			
			// 保存流程业务关系的信息	
			Six.setPubCustName(Six.getCustName());
			Six.setPubFlowId(Six.getFlowId());
			
			/**
			 * 这样待办、已办才能关联的到
			 */
			pb =generalprocessService.insertProcessBus(Six, taskAssgineeDto);
			jbpmService.saveProcessBusiness(muo, pb);		
			Six.setOpinion(Six.getProcessingOpinion());
			//////////////////////////	
			if (Six.getProcessModelId() != null
					&& !"".equals(Six.getProcessModelId())){
				// 修改模式6表单内容
				this.tGeneralprocessModelsixDAO.uptModelSix(Six);
			}else{
				// 保存模式6表单内容
				this.tGeneralprocessModelsixDAO.addModelSix(Six);
			}
			/**
			 * ★★★★★★★★★★★★★★★★★★★★
			 * 获取流程实例id  更新 主模板main的信息   （rule----类名和id--当前模式的主键id）
			 * 已存在：update  PS：一个实例就一条记录
			 * 不存在： insert
			 */
			// 获取流程实例id
			String executionId = taskAssgineeDto.getExecutionId();

			// 查询模式主板信息
			TGeneralprocessMain main = this.generalprocessMainDAO
					.queryMainByBusinessId(executionId);

			// 新增或更新模式主板的rule和id
			if (main != null) {
				// 修改
				this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
						Six, main, ProcessModelSix.class);
			} else {
				// 新增
				this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
						Six, ProcessModelSix.class);
			}
			/**
			 * ★★★★★★★★★★★★★★★★★★★★
			 * 流程通用的一些操作   ---
			 * 1.获取下一个选择的节点的名字--存成  提交类型
			 */		
			String btnType = taskAssgineeDto.getBtnType();
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
				TaskAssgineeDto newDto = this.generalprocessService.makeTaskAssgineeDto(pb,muo, taskAssgineeDto);
				jbpmService.saceTaskAssignee(newDto);
				 submitType =taskAssgineeDto.getTransitionName();
				this.generalprocessService.insertApproveOpninion(Six, muo, nextTaskId,
						submitType, taskAssgineeDto);

			}
		}else{
			//正常发起
			/**
			 * ★★★★★★★★★★★★★★★★★★★★
			 //1.获取teskid----从而获取name
			//2.获取 flowid
			 */
			 taskId = taskAssgineeDto.getNextTaskId();
			 String taskName = jbpmService.getTaskNameById(taskId);
			Six.setTaskName(taskName);
			Six.setFlowId(taskAssgineeDto.getExecutionId());
			/**
			 * ★★★★★★★★★★★★★★★★★★★★
			 * 判断是否存在  这个model对象 
			 * 存在：update
			 * 不存在： insert
			 * 
			 */
			
			if (Six.getProcessModelId() != null
					&& !"".equals(Six.getProcessModelId())){
				// 修改模式6表单内容
				this.tGeneralprocessModelsixDAO.uptModelSix(Six);
		          //////////////////////////////////////////////附件上传////////////////////////////////////////////////////
/*				if(files!=null){
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
		 			       		obj.setExecutionId(Six.getFlowId());
		 			       		obj.setModeId(String.valueOf(Six.getProcessModelId()));
		 			       		obj.setModeType("mod6");
		 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
								obj.setModeFiles(content);
				       			       		
		 		       		  obj.setFileName(filesFileName[i]);
		 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
		 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

								tModelFileService.insert(obj);
				
		 		       	 }
				}*/
				
			}else{
				// 保存模式6表单内容
				this.tGeneralprocessModelsixDAO.addModelSix(Six);
				
		          //////////////////////////////////////////////附件上传////////////////////////////////////////////////////
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
		 			       		obj.setExecutionId(Six.getFlowId());
		 			       		obj.setModeId(String.valueOf(Six.getProcessModelId()));
		 			       		obj.setModeType("mod6");
		 			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);
								obj.setModeFiles(content);
				       			       		
		 		       		  obj.setFileName(filesFileName[i]);
		 		       		  obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 	       		
		 		    		  FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);

								tModelFileService.insert(obj);
				
		 		       	 }
				}
				
				
			}
			Six.setOpinion(Six.getProcessingOpinion());
			
			
			/**
			 * ★★★★★★★★★★★★★★★★★★★★
			 * 获取流程实例id  更新 主模板main的信息   （rule----类名和id--当前模式的主键id）
			 * 已存在：update  PS：一个实例就一条记录
			 * 不存在： insert
			 */
			// 获取流程实例id
			String executionId = taskAssgineeDto.getExecutionId();

			// 查询模式主板信息
			TGeneralprocessMain main = this.generalprocessMainDAO
					.queryMainByBusinessId(executionId);

			// 新增或更新模式主板的rule和id
			if (main != null) {
				// 修改
				this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
						Six, main, ProcessModelSix.class);
			} else {
				// 新增
				this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
						Six, ProcessModelSix.class);
			}


			
			String btnType = taskAssgineeDto.getBtnType();
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
				

				TaskAssgineeDto newDto = this.generalprocessService.makeTaskAssgineeDto(pb,muo, taskAssgineeDto);

				jbpmService.saceTaskAssignee(newDto);
				

				 submitType =taskAssgineeDto.getTransitionName();

				

				this.generalprocessService.insertApproveOpninion(Six, muo, nextTaskId,
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
		 			       		obj.setModeId(String.valueOf(Six.getProcessModelId()));
		 			       		obj.setModeType("mod6");
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
    
    
    
    
    
    
    
    
    

}