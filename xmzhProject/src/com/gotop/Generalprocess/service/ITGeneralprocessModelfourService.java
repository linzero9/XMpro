package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfourDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import java.util.List;
import java.util.Map;

public interface ITGeneralprocessModelfourService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessModelfourDAO(ITGeneralprocessModelfourDAO tGeneralprocessModelfourDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessModelfourDAO gettGeneralprocessModelfourDAO() throws Exception;

    /**
     * 根据流程id和taskName查询出模式四对象
     * @param modelFour
     * @return
     */
	ProcessModelFour queryModelFour(ProcessModelFour modelFour);

	/**
	 * 处理模式四对象
	 * @param muo
	 * @param modelFour
	 * @param taskAssgineeDto
	 */
	void handleModelFour(MUOUserSession muo, ProcessModelFour modelFour,Map<String, Object> map,
			TaskAssgineeDto taskAssgineeDto);

	List<ProcessModelFourMistake> queryFourMistake(ProcessModelFour modelFour);

	List<ProcessModelFourMistake> queryFourMistakeByFlowId(String busId,
			ProcessModelFour modelFour);

}