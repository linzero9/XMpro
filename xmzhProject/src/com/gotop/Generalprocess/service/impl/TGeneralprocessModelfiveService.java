package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfiveDAO;
import com.gotop.Generalprocess.model.ProcessModelFive;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfiveService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

import org.apache.log4j.Logger;

public class TGeneralprocessModelfiveService implements ITGeneralprocessModelfiveService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelfiveService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelfiveDAO tGeneralprocessModelfiveDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelfiveDAO(ITGeneralprocessModelfiveDAO tGeneralprocessModelfiveDAO) throws Exception {
        this.tGeneralprocessModelfiveDAO = tGeneralprocessModelfiveDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelfiveDAO gettGeneralprocessModelfiveDAO() throws Exception {
        return this.tGeneralprocessModelfiveDAO;
    }

	@Override
	public ProcessModelFive queryModelFive(ProcessModelFive modelFive) {
		return null;
	}

	@Override
	public void handleModelFive(MUOUserSession muo, ProcessModelFive modelFive,
			TaskAssgineeDto taskAssgineeDto) {
	}

}