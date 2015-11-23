package com.gotop.Generalprocess.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModeloneDAO;
import com.gotop.Generalprocess.model.ProcessModel;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.model.TProcessBusiness;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.dao.ITApproveOpninionDAO;
import com.gotop.opinion.model.TApproveOpninion;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;

public class GeneralprocessService implements IGeneralprocessService {

	protected Logger log = Logger.getLogger(GeneralprocessService.class);

	private IGeneralprocessDAO generalProcessDAO;
	
	private ITGeneralprocessMainDAO generalprocessMainDAO;
	
	/**
	 * 模式一的DAO
	 */
	private ITGeneralprocessModeloneDAO generalprocessModeloneDAO;

	protected ITApproveOpninionDAO tApproveOpninionDAO;
	
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
			TaskAssgineeDto taskAssgineeDto) {
		String preTaskId = "";
		String nextTaskId = "";
		String submitType = "";
		TaskAssgineeDto dto1 = null;
		TProcessBusiness pb = null;
		if (modelOne.getProcessModelOneID() != null
				&& !"".equals(modelOne.getProcessModelOneID())) {
			// 更新模式一表单

		} else {
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
			taskAssgineeDto.setExecutionId(dto1.getExecutionId());
			// 模式一赋值流程id
			modelOne.setFlow_Id(dto1.getExecutionId());
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
			// 保存流程的信息

			// 构建流程业务关系信息
			pb = insertProcessBus(modelOne, taskAssgineeDto);
			// 提交
			submitType = "05";
			// 保存流程业务关系的信息
			jbpmService.saveProcessBusiness(muo, pb);
		}

		// 文件上传

		String btnType = taskAssgineeDto.getBtnType();

		String isFirst = taskAssgineeDto.getIsFirst();

		// 根据按钮类型
		if (!"1".equals(btnType)) {
			// 不为保存状态
			// euip.setNodeName1(jbpmService.getTaskById(taskId).getName());
			//
			taskAssgineeDto.setTaskExeAssginee(String.valueOf(muo.getEmpid()));
			taskAssgineeDto.setTaskId(preTaskId);
			// 节点签收人
			jbpmService.assignTask(taskAssgineeDto);
			// 节点完成
			jbpmService.completeTask(preTaskId,
					taskAssgineeDto.getTransitionName(), null);

			if (!"退回".equals(taskAssgineeDto.getTransitionName())) {
				// 节点完成,执行下一步
				if (isFirst == null && taskAssgineeDto.getEmpIds() != null
						&& !"".equals(taskAssgineeDto.getEmpIds()))
					submitType = "01";
				if ("采购".equals(taskAssgineeDto.getTransitionName())) {
					//
					
				} else {
					// 正常下一步
					nextTaskId = jbpmService
							.getNextTaskId(taskAssgineeDto.getExecutionId());
					taskAssgineeDto.setNextTaskId(nextTaskId);
					jbpmService.saceTaskAssignee(makeTaskAssgineeDto(pb, muo,
							taskAssgineeDto));
				}

				generalprocessMainDAO.addGeneralProcessMain(taskAssgineeDto,modelOne,ProcessModelOne.class);
				
				insertApproveOpninion(modelOne, muo, nextTaskId, submitType, taskAssgineeDto);
			} else {
				// 退回上一步操作
				// insertApproveOpninion(euip, muo,
				// taskId,"02",taskAssgineeDto);
				// jbpmService.turnBackTaskAssignee(makeTaskAssgineeDtoBack(taskAssgineeDto,
				// euip, muo));
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
	private TProcessBusiness insertProcessBus(ProcessModelOne modelOne,
			TaskAssgineeDto dto) {
		TProcessBusiness processBusiness = new TProcessBusiness();
		try {
			processBusiness.setBusinessKey(modelOne.getProcessModelOneID());
			processBusiness.setBusinessType(dto.getBusinessType());
			processBusiness.setBusinessTitle("受理调查表");
			processBusiness.setExecutionId(modelOne.getFlow_Id());
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
			taskAssgineeDto.setBusinessKey(pb.getBusinessKey());
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
	 * @param muo
	 * @param taskId
	 */
	public void insertApproveOpninion(ProcessModel processModel,MUOUserSession muo,String taskId,String type,TaskAssgineeDto dto){
		try {
			if(processModel!=null&&processModel.getProcessModelId()!=null&&!"".equals(processModel.getProcessModelId())){
				if(processModel.getOpinion()!=null){
					String currDate=TimeUtil.getCntDtStr(new Date(), "yyyyMMddHHmmss");
			    	TApproveOpninion opninion=new TApproveOpninion();
			    	opninion.setResourceId(processModel.getProcessModelId());
			    	opninion.setOperator(muo.getEmpid());
			    	opninion.setOrgid(String.valueOf(muo.getOrgid()));
			    	opninion.setResourceType(dto.getBusinessType());
			    	opninion.setOperatorType(type);
			    	opninion.setOperaterDate(currDate.substring(0, 8));
			    	opninion.setOperaterTime(currDate.substring( 8));
			    	opninion.setOpninionContent(processModel.getOpinion());

			    	opninion.setNextorgname("");
			    	if(dto.getEmpNames()!=null&&!"null".equals(dto.getEmpNames())){
			    		opninion.setNextOprName(dto.getEmpNames());
			    		List<HashMap<String,Object>> list = this.generalProcessDAO.queryOrgName(dto.getEmpIds());
			    		for(int i=0;i<list.size();i++){
			    			opninion.setNextorgname(opninion.getNextorgname()+(String) list.get(i).get("ORGNAME"));
			    			if(i!=list.size()-1){
			    				opninion.setNextorgname(opninion.getNextorgname()+",");
			    			}
			    		}
			    		
			    	}
			    	else
			    		opninion.setNextOprName("");
			    	//需要taskId
			    	opninion.setNodeId(taskId);
			    	//opninion.setNodeName(euip.getNodeName1());
			    	tApproveOpninionDAO.insert(opninion);
				}
			}
		} catch (Exception e) {
			//保存审核意见失败。
			log.error("保存审核意见失败。", e);
		}
	}

}
