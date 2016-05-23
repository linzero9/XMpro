package com.gotop.timeMachine.action;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;






public class TimeMachineJob {
	
	
	
	private  TModelTimedayAction  TimedayAction;

	public TModelTimedayAction getTimedayAction() {
		return TimedayAction;
	}

	public void setTimedayAction(TModelTimedayAction timedayAction) {
		TimedayAction = timedayAction;
	}
	
	
	protected void executeExcel(JobExecutionContext context)
	throws JobExecutionException {
 
		try {
			TimedayAction.queryOvertimeReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			System.out.println("执行超限时长报表 出错  ERROR!!");
		}
 
	}
	
	
	
	
	
	
	
	

}
