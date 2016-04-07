package com.gotop.Generalprocess.service;

import java.io.File;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelsevenDAO;
import com.gotop.Generalprocess.model.ProcessModelSeven;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

public interface ITGeneralprocessModelsevenService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessModelsevenDAO(ITGeneralprocessModelsevenDAO tGeneralprocessModelsevenDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessModelsevenDAO gettGeneralprocessModelsevenDAO() throws Exception;

    ProcessModelSeven queryModelSeven(ProcessModelSeven modelSeven);
    
    void handleModelSeven(MUOUserSession muo, ProcessModelSeven modelSeven,TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName )throws Exception;
    
    
}