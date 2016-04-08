package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessModeleightDAO;
import com.gotop.Generalprocess.model.ProcessModelEight;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModeleightService {
    

	ProcessModelEight queryModelEight(ProcessModelEight modelEight2);

	void handleModelEight(MUOUserSession muo, ProcessModelEight modelEight,
			TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName )throws Exception;

    
}