package com.gotop.timeMachine.service;

import java.util.Date;

import com.gotop.timeMachine.dao.ITModelTimedayDAO;

public interface ITimeService {
	
	
	int getTime(Date start,Date end) throws Exception;

}
