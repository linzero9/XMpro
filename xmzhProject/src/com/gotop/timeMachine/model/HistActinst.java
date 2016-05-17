package com.gotop.timeMachine.model;

import java.io.Serializable;

import com.sun.jna.platform.win32.WinDef.LONG;

public class HistActinst  implements Serializable {

	 
	private LONG  dbid_  ;
	private String  type_ ;  //节点任务类型
	private String  execution_   ;  //流程id
	private String  activity_name_ ;  //几点名称
	private String  start_ ;  //节点的开始时间
	private String  end_  ;  //节点的结束时间
	private String  transition_   ;
	private LONG  htask_ ;  //任务id， 对应JBPM4_HIST_TASK表的dbid_
	
	private Integer rn ;
	
	
	public LONG getDbid_() {
		return dbid_;
	}
	public void setDbid_(LONG dbid_) {
		this.dbid_ = dbid_;
	}
	public String getType_() {
		return type_;
	}
	public void setType_(String type_) {
		this.type_ = type_;
	}
	public String getExecution_() {
		return execution_;
	}
	public void setExecution_(String execution_) {
		this.execution_ = execution_;
	}
	public String getActivity_name_() {
		return activity_name_;
	}
	public void setActivity_name_(String activity_name_) {
		this.activity_name_ = activity_name_;
	}
	public String getStart_() {
		return start_;
	}
	public void setStart_(String start_) {
		this.start_ = start_;
	}
	public String getEnd_() {
		return end_;
	}
	public void setEnd_(String end_) {
		this.end_ = end_;
	}
	public String getTransition_() {
		return transition_;
	}
	public void setTransition_(String transition_) {
		this.transition_ = transition_;
	}
	public LONG getHtask_() {
		return htask_;
	}
	public void setHtask_(LONG htask_) {
		this.htask_ = htask_;
	}
	public Integer getRn() {
		return rn;
	}
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	
	
	
}
