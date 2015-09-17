package com.gotop.lmt_test.action;

import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.lmt_test.model.OmEmployee;
import com.gotop.lmt_test.service.IOmEmployeeService;
import com.gotop.util.Struts2Utils;

public class OmEmployeeAction extends BaseAction{

	private OmEmployee employee ;
	private List<OmEmployee> employees ;
	private IOmEmployeeService omEmployeeService;
	
	
	public OmEmployee getEmployee() {
		return employee;
	}


	public void setEmployee(OmEmployee employee) {
		this.employee = employee;
	}


	public List<OmEmployee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<OmEmployee> employees) {
		this.employees = employees;
	}


	public IOmEmployeeService getOmEmployeeService() {
		return omEmployeeService;
	}


	public void setOmEmployeeService(IOmEmployeeService omEmployeeService) {
		this.omEmployeeService = omEmployeeService;
	}


	 /**
     * 路径：
     * 					我的员工
     * 功能描述：
     * 					跳转到我的员工列表页面，查询所有的员工列表信息
     * 备注说明：
     * 
     * @return
	 * @throws Exception 
     */
	public String myEmployeeList() throws Exception{
		if(employee == null){
			employee = new OmEmployee();
		}
		employees=omEmployeeService.myEmployeeList(employee,this.getPage());
		this.setEmployees(employees);
		return "myEmployeeList";
	}
	
	/**
     * 跳转到增加员工界面
     * @return
	 * @throws Exception 
     */
	public String toEmployee() throws Exception{
		if(employee != null){
			employee = omEmployeeService.getEmployeeByEmpid(employee);
		}
		this.setEmployee(employee);
		return "employee";
	}
	
	/**
     * 新增或修改员工信息
     * @throws Exception 
     */
	public void save() throws Exception{
		String info ="success";
		try {
			this.omEmployeeService.save(employee);
		} catch (Exception e) {
			info="fails";
			log.error("[保存员工信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	public void delete() throws Exception{
    	String info ="success";
    	try {
    		this.omEmployeeService.delete(employee);
    	} catch (Exception e) {
			info="fails";
			log.error("[删除员工信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
	
	
	public void empcodeIExist() throws Exception{
    	String info ="success";
    	try {
    		int count = this.omEmployeeService.queryListByEmpcode(employee);
    		if(count>0){
    			info="isExist";
    		}
    	} catch (Exception e) {
			info="fails";
			log.error("[保存员工信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
}
