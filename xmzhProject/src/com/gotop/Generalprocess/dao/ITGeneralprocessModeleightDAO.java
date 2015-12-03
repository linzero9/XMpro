package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModelEight;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModeleightDAO {

	ProcessModelEight queryModelEight(HashMap<String, Object> map);

	void uptModelEight(ProcessModelEight modelEight);

	void addModelEight(ProcessModelEight modelEight);

	ProcessModelEight queryModelEightById(String processModelId);
  
}