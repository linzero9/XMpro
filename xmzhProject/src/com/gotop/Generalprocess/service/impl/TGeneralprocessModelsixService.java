package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelsixDAO;

import com.gotop.Generalprocess.model.ProcessModelSix;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;

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
    
    
    
    
    
    
    
    
    

}