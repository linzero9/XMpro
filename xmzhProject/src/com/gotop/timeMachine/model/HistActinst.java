package com.gotop.timeMachine.model;

import java.io.Serializable;

import com.sun.jna.platform.win32.WinDef.LONG;

public class HistActinst  implements Serializable {

	
	private Long  dbid;
	private String  type;  //节点任务类型
	private String  execution;  //流程id
	private String  activity_name;  //几点名称
	private String  start;  //节点的开始时间
	private String  end;  //节点的结束时间
	private String  transition;
	private Long  htask;  //任务id， 对应JBPM4_HIST_TASK表的dbid_
	
	private Integer rn ;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	
	public Long getDbid() {
		return dbid;
	}

	public void setDbid(Long dbid) {
		this.dbid = dbid;
	}

	public Long getHtask() {
		return htask;
	}

	public void setHtask(Long htask) {
		this.htask = htask;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}
	
	
	
	
}
