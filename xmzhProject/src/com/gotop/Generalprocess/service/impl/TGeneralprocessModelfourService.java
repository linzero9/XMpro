package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelfourDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfourService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TGeneralprocessModelfourService implements ITGeneralprocessModelfourService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelfourService.class);

    /**
     * jbpm服务
     */
    private JbpmService jbpmService;
    
    private ITGeneralprocessMainDAO generalprocessMainDAO;
    
    protected IGeneralprocessService generalprocessService;
    
    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelfourDAO tGeneralprocessModelfourDAO;

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

	/**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelfourDAO(ITGeneralprocessModelfourDAO tGeneralprocessModelfourDAO) throws Exception {
        this.tGeneralprocessModelfourDAO = tGeneralprocessModelfourDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelfourDAO gettGeneralprocessModelfourDAO() throws Exception {
        return this.tGeneralprocessModelfourDAO;
    }
  
	@Override
	public ProcessModelFour queryModelFour(ProcessModelFour modelFour) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelFour != null){
			if(modelFour.getFlowId() != null && !"".equals(modelFour.getFlowId())){
				map.put("flow_id", modelFour.getFlowId());
			}
			if(modelFour.getTaskName() != null && !"".equals(modelFour.getTaskName())){
				map.put("taskName", modelFour.getTaskName());
			}
		}
		return this.tGeneralprocessModelfourDAO.queryModelFour(map);
	}

	@Override
	public void handleModelFour(MUOUserSession muo, ProcessModelFour modelFour,Map<String, Object> map,
			TaskAssgineeDto taskAssgineeDto) {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelFour.setTaskName(taskName);
		modelFour.setFlowId(taskAssgineeDto.getExecutionId());
		String[] hiAddTimeAr = null;
		String[] hiProFourAr = null;
		String[] hiTaskNameAr = null;
		String[] hiEmpIdAr = null;
		String[] hiFlowIdAr = null;
		String[] hiJeesAr = null;
		String[] hiFilesAr = null;
		
		String hiAddTime = null;
		String hiProFour = null;
		String hiTaskName = null;
		String hiEmpId = null;
		String hiFlowId = null;
		String hiJees = null;
		String hiFiles = null;
		
		if(map.get("hiAddTime") != null){
			hiAddTime = (String) map.get("hiAddTime");
			hiAddTime=hiAddTime.replace(" ", "");
			hiAddTimeAr = hiAddTime.split(",");
		}
		
		if(map.get("hiProFour") != null){
			hiProFour = (String) map.get("hiProFour");
			hiProFour=hiProFour.replace(" ", "");
			hiProFourAr = hiProFour.split(",");
		}
		
		if(map.get("hiTaskName") != null){
			hiTaskName = (String) map.get("hiTaskName");
			hiTaskName=hiTaskName.replace(" ", "");
			hiTaskNameAr = hiTaskName.split(",");
		}
		
		if(map.get("hiEmpId") != null){
			hiEmpId = (String) map.get("hiEmpId");
			hiEmpId=hiEmpId.replace(" ", "");
			hiEmpIdAr = hiEmpId.split(",");
		}
		
		if(map.get("hiFlowId") != null){
			hiFlowId = (String) map.get("hiFlowId");
			hiFlowId=hiFlowId.replace(" ", "");
			hiFlowIdAr = hiFlowId.split(",");
		}
		
		if(map.get("hiJees") != null){
			hiJees = (String) map.get("hiJees");
			hiJees=hiJees.replace(" ", "");
			hiJeesAr = hiJees.split(",");
		}
		
		if(map.get("hiFiles") != null){
			hiFiles = (String) map.get("hiFiles");
			hiFiles=hiFiles.replace(" ", "");
			hiFilesAr = hiFiles.split(",");
		}
		
		if(hiProFourAr !=null){
		if(hiProFourAr.length !=0 && hiProFourAr != null){
			for (int i = 0; i < hiProFourAr.length; i++) {
				ProcessModelFour mf = new ProcessModelFour();
				mf.setProcessModelId(Long.valueOf(hiProFourAr[i]));
				this.tGeneralprocessModelfourDAO.deleteModelFourMistake(mf);
			}
		}
		}
		
		if(hiAddTimeAr !=null && hiProFourAr != null && hiTaskNameAr != null && hiEmpIdAr != null && hiFlowIdAr != null && hiJeesAr != null && hiFilesAr != null){
				for (int i = 0; i < hiAddTimeAr.length; i++) {
					ProcessModelFourMistake mistake =new ProcessModelFourMistake();
					mistake.setEmpid(hiEmpIdAr[i]);
					mistake.setFlowId(hiFlowIdAr[i]);
					mistake.setTaskName(hiTaskNameAr[i]);
					mistake.setMistakeContent(hiFilesAr[i]);
					mistake.setPunishBal(hiJeesAr[i]);
					mistake.setProcessModelIdFour(hiProFourAr[i]);
					mistake.setAddTime(hiAddTimeAr[i]);
					this.tGeneralprocessModelfourDAO.addModelFourMistake(mistake);
				}
		}
		
		
		String[] fileArray = null;
		String[] jeArray = null;
		String files = null;
		String jees = null;
		if(map.get("files") != null){
			files = (String) map.get("files");
			files=files.replace(" ", "");
		}
		if(map.get("jees") != null){
			jees = (String) map.get("jees");
			jees=jees.replace(" ", "");
		}
		if(files != null && !"".equals(files)){
			fileArray = files.split(",");
		}
		if(jees != null && !"".equals(jees)){
			jeArray = jees.split(",");
		}
		if (modelFour.getProcessModelId() != null
				&& !"".equals(modelFour.getProcessModelId())){
			// 修改模式四表单内容
			this.tGeneralprocessModelfourDAO.uptModelFour(modelFour);
			
			this.tGeneralprocessModelfourDAO.deleteModelFourMistake(modelFour);
		}else{
			// 保存模式四表单内容
			this.tGeneralprocessModelfourDAO.addModelFour(modelFour);
		}
		
		if(fileArray !=null && jeArray != null){
			if(fileArray.length !=0 && jeArray.length !=0){
				for (int i = 0; i < fileArray.length; i++) {
					ProcessModelFourMistake mistake =new ProcessModelFourMistake();
					mistake.setEmpid(String.valueOf(muo.getEmpid()));
					mistake.setFlowId(modelFour.getFlowId());
					mistake.setTaskName(modelFour.getTaskName());
					mistake.setMistakeContent(fileArray[i]);
					mistake.setPunishBal(jeArray[i]);
					mistake.setProcessModelIdFour(String.valueOf(modelFour.getProcessModelId()));
					String currDate = TimeUtil.getCntDtStr(new Date(),
							"yyyyMMddHHmmss");
					mistake.setAddTime(currDate);
					this.tGeneralprocessModelfourDAO.addModelFourMistake(mistake);
				}
			}
		}
		

		modelFour.setOpinion(modelFour.getOpninionContent());

		// 获取流程实例id
		String executionId = taskAssgineeDto.getExecutionId();

		// 查询模式主板信息
		TGeneralprocessMain main = this.generalprocessMainDAO
				.queryMainByBusinessId(executionId);

		// 新增或更新模式主板的rule和id
		if (main != null) {
			// 修改
			this.generalprocessMainDAO.uptGeneralProcessMain(taskAssgineeDto,
					modelFour, main, ProcessModelFour.class);
		} else {
			// 新增
			this.generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,
					modelFour, ProcessModelFour.class);
		}

		// 模式四-提交操作
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

		TaskAssgineeDto newDto = this.generalprocessService.makeTaskAssgineeDto(null,muo, taskAssgineeDto);

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
		}*/
		
		this.generalprocessService.insertApproveOpninion(modelFour, muo, nextTaskId,
				submitType, taskAssgineeDto);
	}

	@Override
	public List<ProcessModelFourMistake> queryFourMistake(
			ProcessModelFour modelFour) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelFour != null){
			if(modelFour.getProcessModelId() != null && !"".equals(modelFour.getProcessModelId())){
				map.put("processModelId", modelFour.getProcessModelId());
			}
		}
		return this.tGeneralprocessModelfourDAO.queryFourMistake(map);
	}

	@Override
	public List<ProcessModelFourMistake> queryFourMistakeByFlowId(String busId,
			ProcessModelFour modelFour) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("busId", busId);
		if(modelFour != null){
			if(modelFour.getProcessModelId() != null){
				map.put("processModelId", modelFour.getProcessModelId());
			}
		}
		return this.tGeneralprocessModelfourDAO.queryFourMistakeByFlowId(map);
	}
	
}