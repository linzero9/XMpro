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
	public void handleModelFour(MUOUserSession muo, ProcessModelFour modelFour,String files, String jees,
			TaskAssgineeDto taskAssgineeDto) {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelFour.setTaskName(taskName);
		modelFour.setFlowId(taskAssgineeDto.getExecutionId());
		
		String[] fileArray = null;
		String[] jeArray = null;
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
		if(fileArray.length !=0 && fileArray !=null && jeArray.length !=0 && jeArray != null){
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
		
		/**
		 * submitType  操作类型
		 */
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
	
}