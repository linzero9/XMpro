package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModelFive;
import java.util.HashMap;

public interface ITGeneralprocessModelfiveDAO {
	
	ProcessModelFive queryModelFive(HashMap<String, Object> map);

	void addModelFive(ProcessModelFive modelFive);

	void uptModelFive(ProcessModelFive modelFive);
	
	ProcessModelFive queryModelFiveById(String processModelId);

}