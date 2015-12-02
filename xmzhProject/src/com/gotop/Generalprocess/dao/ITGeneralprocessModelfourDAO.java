package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModelfourDAO {

	ProcessModelFour queryModelFour(HashMap<String, Object> map);

	void addModelFour(ProcessModelFour modelFour);

	void uptModelFour(ProcessModelFour modelFour);
	
	ProcessModelFour queryModelFourById(String processModelId);

	void addModelFourMistake(ProcessModelFourMistake mistake);

	List<ProcessModelFourMistake> queryFourMistake(HashMap<String, Object> map);

	void deleteModelFourMistake(ProcessModelFour modelFour);
}