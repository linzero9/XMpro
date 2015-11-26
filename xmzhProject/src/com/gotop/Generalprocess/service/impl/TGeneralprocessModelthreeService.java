package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelthreeDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.model.TGeneralprocessModelthree;
import com.gotop.Generalprocess.model.TGeneralprocessModelthreeExample;
import com.gotop.Generalprocess.service.ITGeneralprocessModelthreeService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TGeneralprocessModelthreeService implements ITGeneralprocessModelthreeService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelthreeService.class);

    
    private JbpmService jbpmService;
    private ITGeneralprocessMainDAO generalprocessMainDAO;
    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelthreeDAO tGeneralprocessModelthreeDAO;

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
			ProcessModelThree modelThree, TaskAssgineeDto taskAssgineeDto) {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelThree.setTaskName(taskName);
		modelThree.setFlow_id(taskAssgineeDto.getExecutionId());
		// 保存模式二表单内容
		this.tGeneralprocessModelthreeDAO.addModelThree(modelThree);

		modelThree.setOpinion(modelThree.getOpninion_content());

		// 获取流程实例id
		String executionId = taskAssgineeDto.getExecutionId();

		// 查询模式主板信息
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

		TaskAssgineeDto newDto = makeTaskAssgineeDtoNoPd(muo, taskAssgineeDto);

		jbpmService.saceTaskAssignee(newDto);

		// insertApproveOpninion(modelTwo, muo, taskId, "01", newDto);
		/*
		 * }else if (btnType.equals("3")){ //模式二-回退操作 //退回 //回退上个节点 }
		 */

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