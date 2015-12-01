package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessMainDAO;
import com.gotop.Generalprocess.dao.ITGeneralprocessModelfourDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.model.TGeneralprocessModelfour;
import com.gotop.Generalprocess.model.TGeneralprocessModelfourExample;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfourService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
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

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    public List queryDataGrid(HashMap map, Page page) throws Exception {
        TGeneralprocessModelfourExample example = new TGeneralprocessModelfourExample();
        TGeneralprocessModelfourExample.Criteria criteria = example.createCriteria();
        example.setOracleStart(page.getBegin());
        example.setOracleEnd(page.getBegin()+page.getLength());
        TGeneralprocessModelfour record = new TGeneralprocessModelfour();
        List list = tGeneralprocessModelfourDAO.selectByExampleAndPage(record,example,page);
        return list;
    }

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TGeneralprocessModelfour obj) throws Exception {
        this.tGeneralprocessModelfourDAO.insert(obj);
    }

    /**
     * 删除单条记录
     * @abatorgenerated
     */
    public void delete(TGeneralprocessModelfour obj) throws Exception {
        
        //this.tGeneralprocessModelfourDAO.deleteByPrimaryKey(key);
    }

    /**
     * 批量更新数据
     * @abatorgenerated
     */
    public void updateBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelfour tObject = (TGeneralprocessModelfour)abs.get(i);
            //  没有主键的表，请自行处理
        }
    }

    /**
     * 批量插入数据
     * @abatorgenerated
     */
    public void insertBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelfour tObject = (TGeneralprocessModelfour)abs.get(i);
            	this.insert(tObject);
        }
    }

    /**
     * 批量删除数据
     * @abatorgenerated
     */
    public void deleteBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TGeneralprocessModelfour tObject = (TGeneralprocessModelfour)abs.get(i);
            	this.delete(tObject);
        }
    }

    /**
     * datacell方式批量更新数据
     * @abatorgenerated
     */
    public void updateDataGrid(HashMap hmp) throws Exception {
        this.tGeneralprocessModelfourDAO.startBatch();
        List insertEntities = (List) hmp.get("insertEntities");
        List deleteEntities = (List) hmp.get("deleteEntities");
        List updateEntities = (List) hmp.get("updateEntities");
        this.updateBatch(updateEntities);
        this.insertBatch(insertEntities);
        this.deleteBatch(deleteEntities);
        this.tGeneralprocessModelfourDAO.executeBatch();
    }

    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    public List queryAllDataList(HashMap map) throws Exception {
        TGeneralprocessModelfourExample example = new TGeneralprocessModelfourExample();
        TGeneralprocessModelfourExample.Criteria criteria = example.createCriteria();
        List list = tGeneralprocessModelfourDAO.selectByExample(example);
        return list;
    }

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryPageDataList(HashMap map, Page page) throws Exception {
        List list = tGeneralprocessModelfourDAO.selectByDynamic(map,page);
        return list;
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
	public void handleModelFour(MUOUserSession muo, ProcessModelFour modelFour,
			TaskAssgineeDto taskAssgineeDto) {
		String taskId = taskAssgineeDto.getNextTaskId();
		String taskName = jbpmService.getTaskNameById(taskId);
		modelFour.setTaskName(taskName);
		modelFour.setFlowId(taskAssgineeDto.getExecutionId());
		
		if (modelFour.getProcessModelId() != null
				&& !"".equals(modelFour.getProcessModelId())){
			// 修改模式四表单内容
			this.tGeneralprocessModelfourDAO.uptModelFour(modelFour);
		}else{
			// 保存模式四表单内容
			this.tGeneralprocessModelfourDAO.addModelFour(modelFour);
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
	
}