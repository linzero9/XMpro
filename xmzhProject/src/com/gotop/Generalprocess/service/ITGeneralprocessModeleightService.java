package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessModeleightDAO;
import com.gotop.Generalprocess.model.ProcessModelEight;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModeleightService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessModeleigthDAO(ITGeneralprocessModeleightDAO tGeneralprocessModeleigthDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessModeleightDAO gettGeneralprocessModeleigthDAO() throws Exception;

	ProcessModelEight queryModelEight(ProcessModelEight modelEight2);

	void handleModelEight(MUOUserSession muo, ProcessModelEight modelEight,
			TaskAssgineeDto taskAssgineeDto);

    
}