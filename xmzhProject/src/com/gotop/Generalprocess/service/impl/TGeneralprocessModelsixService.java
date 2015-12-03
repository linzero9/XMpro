package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelsixDAO;

import com.gotop.Generalprocess.model.ProcessModelSix;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

import java.util.HashMap;

import org.apache.log4j.Logger;
/**
 * 
 * @author wujiajun
 * 
 *
 */
public class TGeneralprocessModelsixService implements ITGeneralprocessModelsixService {
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
			ProcessModelSix six, TaskAssgineeDto taskAssgineeDto,
			String... otherParam) {
		// TODO Auto-generated method stub
		
		/**
		 * ★★★★★★★★★★★★★★★★★★★★
		 //1.获取teskid----从而获取name
		//2.获取 flowid
		 */

		
		/**
		 * ★★★★★★★★★★★★★★★★★★★★
		 * 判断是否存在  这个model对象 
		 * 存在：update
		 * 不存在： insert
		 * 
		 */
		
		
		/**
		 * ★★★★★★★★★★★★★★★★★★★★
		 * 获取流程实例id  更新 主模板main的信息   （rule----类名和id--当前模式的主键id）
		 * 已存在：update  PS：一个实例就一条记录
		 * 不存在： insert
		 */
		
		
		/**
		 * ★★★★★★★★★★★★★★★★★★★★
		 * 
		 */
		
		
		/**
		 * ★★★★★★★★★★★★★★★★★★★★
		 * 流程通用的一些操作   ---
		 * 1.获取下一个选择的节点的名字--存成  提交类型
		 */
		
		
		
		/**
		 * ★★★★★★★★★★★★★★★★★★★★
		 * 显示操作记录-的部分 
		 */
		
		
		System.out.println(otherParam);
		
	}
    
    
    
    
    
    
    
    
    

}