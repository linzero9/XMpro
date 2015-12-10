package com.gotop.Generalprocess.dao;

import java.util.HashMap;
import com.gotop.Generalprocess.model.ProcessModelSeven;

public interface ITGeneralprocessModelsevenDAO {

	ProcessModelSeven queryModelSeven(HashMap<String, Object> map);

	void addModelSeven(ProcessModelSeven modelSeven);

	void uptModelSeven(ProcessModelSeven modelSeven);
    
	ProcessModelSeven queryModelSevenById(String processModelId);
}