package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfourDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

import java.io.File;
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
			TaskAssgineeDto taskAssgineeDto,File[] files2,String[] filesFileName )throws Exception;

	List<ProcessModelFourMistake> queryFourMistake(ProcessModelFour modelFour);

	List<ProcessModelFourMistake> queryFourMistakeByFlowId(String busId,
			ProcessModelFour modelFour);
/**
 * 保存单个错误内容
 * @param muo
 * @param modelFour
 * @param map
 * @param taskAssgineeDto 
 */
	void saveMistakeInfo(MUOUserSession muo, ProcessModelFour modelFour,
			Map<String, Object> map, TaskAssgineeDto taskAssgineeDto);

ProcessModelFour queryProceeModelId(ProcessModelFour modelFour,
		TaskAssgineeDto taskAssgineeDto);

void saveProcessModelFour(ProcessModelFour modelFour,
		TaskAssgineeDto taskAssgineeDto);

}