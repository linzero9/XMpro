package com.gotop.Generalprocess.service;

import java.io.File;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfiveDAO;
import com.gotop.Generalprocess.model.ProcessModelFive;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

public interface ITGeneralprocessModelfiveService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessModelfiveDAO(ITGeneralprocessModelfiveDAO tGeneralprocessModelfiveDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessModelfiveDAO gettGeneralprocessModelfiveDAO() throws Exception;

    /**
     * 根据流程id和taskName查询出模式五对象
     * @param modelFour
     * @return
     */
	ProcessModelFive queryModelFive(ProcessModelFive modelFive);

	/**
	 * 处理模式五对象
	 * @param muo
	 * @param modelFour
	 * @param taskAssgineeDto
	 */
	void handleModelFive(MUOUserSession muo, ProcessModelFive modelFive,TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName) throws Exception;
}