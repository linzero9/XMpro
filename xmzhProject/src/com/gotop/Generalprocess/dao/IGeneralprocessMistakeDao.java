package com.gotop.Generalprocess.dao;

import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessSubmitter;

public interface IGeneralprocessMistakeDao {

	List<ProcessMistake> queryProcessMistake(Map<String, Object> map);

	void updateProcessMistake(List<ProcessMistake> processMistakes);

	ProcessSubmitter querySubmitter(Map<String, Object> map);

	

}
