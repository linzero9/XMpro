package com.gotop.timeMachine.action;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.gotop.Generalprocess.util.SpringContextUtil;




/**
 * 
 * @author WUJIAJUN
 * @desc   to  Job
 */

public class TimeMachineJob   {
	
	
	
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

	
	private void executeInternal() {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("+++++++++++++开始执行 超限时长报表  START+++++++++++");
			
		Object bean = SpringContextUtil.getBean("tModelTimedayaction"); 
		
		Class<?> classes = Class.forName("com.gotop.timeMachine.action.TModelTimedayAction");

		// 目前只有值，需要加入加入 @ 注解的 值

		Method thismethod = classes.getDeclaredMethod("handleTimeReport");

		// bean
		String  back = (String) thismethod.invoke(bean);
		
		
		
		
		System.out.println("+++++++++++++ 超限时长报表   END+++++++++++");
		
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}

		
	}
	
	
	
	
	
	
	
	

}
