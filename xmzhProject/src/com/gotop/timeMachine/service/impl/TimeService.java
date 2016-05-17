package com.gotop.timeMachine.service.impl;

import java.util.Date;

import com.gotop.timeMachine.service.ITModelTimedayService;
import com.gotop.timeMachine.service.ITimeService;

public class TimeService   implements  ITimeService{

	@Override
	public int getTime(Date start, Date end) throws Exception {
		// TODO Auto-generated method stub
		
		

int result = 0;  
java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");  
while (start.compareTo(end) <= 0) {  
if (start.getDay() != 6 && start.getDay() != 0)  
result++;  
start.setDate(start.getDate() + 1);  
}  
return result;  
		
		
	
	}
	
	public static void main(String[] args) {
		
		Date start =  new Date(2016,5,1);
		
		Date end =  new Date(2016,5,16);
		
		
		int result = 0;  
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");  
		while (start.compareTo(end) <= 0) {
		if (start.getDay() != 6 && start.getDay() != 0){
			result++;  
		}

		start.setDate(start.getDate() + 1);  
		
		
		}  
		System.out.println(result);
		
	}

}
