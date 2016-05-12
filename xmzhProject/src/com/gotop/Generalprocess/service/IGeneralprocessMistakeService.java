package com.gotop.Generalprocess.service;

import java.util.List;

import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessSubmitter;

public interface IGeneralprocessMistakeService {

	ProcessSubmitter querySubmitter(ProcessSubmitter processSubmitter);

	List<ProcessMistake> queryProcessMistake(ProcessMistake processMistake);

	void updateProcessMistake(List<ProcessMistake> processMistakes);

}
