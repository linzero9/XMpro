package com.gotop.Generalprocess.service;

import java.util.HashMap;
import java.util.Map;

import com.gotop.Generalprocess.model.ProcessModelSix;


/**
 * 
 * @author wujiajun
 * 
 *
 */
public interface ITGeneralprocessModelsixService {
   
    
  ProcessModelSix queryModelSix(HashMap<String, Object> map);

      void addModelSix(ProcessModelSix modelSix);

    
     void uptModelSix(ProcessModelSix modelSix);

    
     ProcessModelSix queryModelSixById(String processModelId);
     
     ProcessModelSix queryModelSixByFlowIdAndTaskName(ProcessModelSix six);
     
	
	
}