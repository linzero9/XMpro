package com.gotop.Generalprocess.dao;



import com.gotop.Generalprocess.model.ProcessModelSix;

import java.util.HashMap;

/**
 * 
 * @author wujiajun
 * 
 *
 */
public interface ITGeneralprocessModelsixDAO {	

ProcessModelSix queryModelSix(HashMap<String, Object> map);

void addModelSix(ProcessModelSix modelSix);

void uptModelSix(ProcessModelSix modelSix);

ProcessModelSix queryModelSixById(String processModelId);

 ProcessModelSix queryModelSixByFlowIdAndTaskName(ProcessModelSix six);




}