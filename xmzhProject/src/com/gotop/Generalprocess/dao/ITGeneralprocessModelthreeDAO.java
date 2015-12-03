package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessModeltwo;
import com.gotop.Generalprocess.model.TGeneralprocessModeltwoExample;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import com.gotop.Generalprocess.model.TGeneralprocessModelthree;
import com.gotop.Generalprocess.model.TGeneralprocessModelthreeExample;

public interface ITGeneralprocessModelthreeDAO {

	ProcessModelThree queryModelThree(HashMap<String, Object> map);

	void addModelThree(ProcessModelThree modelThree);

	ProcessModelThree queryModelThreeById(String processModelId);

	void uptModelThree(ProcessModelThree modelThree);
}