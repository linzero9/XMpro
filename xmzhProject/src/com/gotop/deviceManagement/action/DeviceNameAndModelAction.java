package com.gotop.deviceManagement.action;

import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.deviceManagement.model.DeviceNameAndModel;
import com.gotop.deviceManagement.service.IDeviceNameAndModelService;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.util.Struts2Utils;

public class DeviceNameAndModelAction extends BaseAction {

	private DeviceNameAndModel deviceNameAndModel;
	
	private List<DeviceNameAndModel> deviceNameAndModels;
	
	private String ids;
	
	private String deviceJson;
	
	protected IDeviceNameAndModelService deviceNameAndModelService;

	
	
	
	public String getDeviceJson() {
		return deviceJson;
	}

	public void setDeviceJson(String deviceJson) {
		this.deviceJson = deviceJson;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public DeviceNameAndModel getDeviceNameAndModel() {
		return deviceNameAndModel;
	}

	public void setDeviceNameAndModel(DeviceNameAndModel deviceNameAndModel) {
		this.deviceNameAndModel = deviceNameAndModel;
	}

	public List<DeviceNameAndModel> getDeviceNameAndModels() {
		return deviceNameAndModels;
	}

	public void setDeviceNameAndModels(List<DeviceNameAndModel> deviceNameAndModels) {
		this.deviceNameAndModels = deviceNameAndModels;
	}

	public IDeviceNameAndModelService getDeviceNameAndModelService() {
		return deviceNameAndModelService;
	}

	public void setDeviceNameAndModelService(
			IDeviceNameAndModelService deviceNameAndModelService) {
		this.deviceNameAndModelService = deviceNameAndModelService;
	}
	
	/**
	 * 查询 所有 设备名称与设备型号的对应关系
	 * @author liaomeiting
	 * @return
	 */
	public String queryDeviceNameAndModelList(){
		
		deviceNameAndModels = this.deviceNameAndModelService.queryDeviceNameAndModelList(deviceNameAndModel,this.getPage());
		this.setDeviceNameAndModels(deviceNameAndModels);
		return "deviceNameAndModel_list";
	}
	
	/**
	 * 删除设备名称和型号的对应关系
	 * @author liaomeiting
	 * @throws Exception
	 */
	public void deleteItem() throws Exception{
		String info ="success";
    	try {
    		String[] valueArra = ids.split(",");
			for(int i=0; i<valueArra.length; i++){
				if(deviceNameAndModel == null){
					deviceNameAndModel = new DeviceNameAndModel();
				}
				deviceNameAndModel.setId(Long.valueOf(valueArra[i]) );
				this.deviceNameAndModelService.deleteItem(deviceNameAndModel);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	
	/**
	 * 跳转到 新增 设备名称与型号的 对应关系 页面
	 * @author liaomeiting
	 * @return
	 */
	public String toAddItem(){
		
		return "add_deviceNameAndModel";
	}
	
	/**
	 * 添加 设备名称与型号的 对应关系
	 * @throws Exception 
	 */
	public void addItem() throws Exception{
		String info ="success";
    	try {
    		String devicemodel_str = deviceNameAndModel.getDevicemodel();
    		String[] valueArra = devicemodel_str.split(", ");
    		
    		String devicemodelId_str = deviceNameAndModel.getDevicemodel_id();
    		String[] valueArra2 = devicemodelId_str.split(", ");
    		
			for(int i=0; i<valueArra.length; i++){
				deviceNameAndModel.setDevicemodel(valueArra[i]);
				deviceNameAndModel.setDevicemodel_id(valueArra2[i]);
				this.deviceNameAndModelService.addItem(deviceNameAndModel);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 检验 设备名称与型号的对应关系是否已存在
	 */
	public void checkDeviceNameAndModel(){
		
		String info ="";
		String err_info="";
		
		String devicemodel_str = deviceNameAndModel.getDevicemodel();
		String[] valueArra = devicemodel_str.split(", ");
		for(int i=0; i<valueArra.length; i++){
			deviceNameAndModel.setDevicemodel(valueArra[i]);
			deviceNameAndModels = this.deviceNameAndModelService.checkDeviceNameAndModel(deviceNameAndModel);
			if(deviceNameAndModels.size() >0){
				if("".equals(err_info)){
					err_info = err_info+deviceNameAndModel.getDevicemodel();
				}else{
					err_info = err_info+","+deviceNameAndModel.getDevicemodel();
				}
			}
		}
		if("".equals(err_info)){
			info ="success";
			Struts2Utils.renderText(info);
		}else{
			info="fails";
			Struts2Utils.renderText(err_info);
		}
	}
	
	/**
	 * 设备名称 数据字典 多选
	 * @author liaomeiting 
	 * @return
	 */
	public String showDevicenameDic(){
		System.out.println(deviceJson);
		return "show_devicenameDic";
	}
	
	/**
	 * 设备名称 数据字典 多选
	 * @author liaomeiting 
	 * @return
	 */
	public String showDevicemodelDic(){
		System.out.println(deviceJson);
		return "show_devicemodelDic";
	}
	
}
