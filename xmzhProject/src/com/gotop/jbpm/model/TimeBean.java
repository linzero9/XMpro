package com.gotop.jbpm.model;

import java.io.Serializable;

public class TimeBean  implements Serializable{
	
	private Long mianID;  //有效日对应的ID
	private Long id1;
	private Long id2;
	private Long id3;
	
	
	public Long getId1() {
		return id1;
	}
	public void setId1(Long id1) {
		this.id1 = id1;
	}
	public Long getId2() {
		return id2;
	}
	public void setId2(Long id2) {
		this.id2 = id2;
	}
	public Long getId3() {
		return id3;
	}
	public void setId3(Long id3) {
		this.id3 = id3;
	}
	private String startTime1; //上午开始时间
	private String endTime1; //上午结束时间
	
	private String startTime2; //下午开始时间
	private String endTime2; //下午结束时间
	
	private String startTime3; //晚上开始时间
	private String endTime3; //晚上结束时间
	public Long getMianID() {
		return mianID;
	}
	public void setMianID(Long mianID) {
		this.mianID = mianID;
	}
	public String getStartTime1() {
		return startTime1;
	}
	public void setStartTime1(String startTime1) {
		this.startTime1 = startTime1;
	}
	public String getEndTime1() {
		return endTime1;
	}
	public void setEndTime1(String endTime1) {
		this.endTime1 = endTime1;
	}
	public String getStartTime2() {
		return startTime2;
	}
	public void setStartTime2(String startTime2) {
		this.startTime2 = startTime2;
	}
	public String getEndTime2() {
		return endTime2;
	}
	public void setEndTime2(String endTime2) {
		this.endTime2 = endTime2;
	}
	public String getStartTime3() {
		return startTime3;
	}
	public void setStartTime3(String startTime3) {
		this.startTime3 = startTime3;
	}
	public String getEndTime3() {
		return endTime3;
	}
	public void setEndTime3(String endTime3) {
		this.endTime3 = endTime3;
	}
	
	

}
