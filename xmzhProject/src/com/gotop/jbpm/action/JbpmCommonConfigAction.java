package com.gotop.jbpm.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;

import org.jbpm.api.ProcessDefinition;
import org.json.JSONException;
import org.json.JSONObject;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.jpdl.JpdlModelDrawer;
import com.gotop.jbpm.jpdl.model.JpdlModel;
import com.gotop.jbpm.model.TProcessConfig;
import com.gotop.jbpm.service.ITProcessConfigService;
import com.gotop.jbpm.service.JbpmCommonService;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;

public class JbpmCommonConfigAction extends BaseAction{

	/**
	 * JBPM4.4	通用流程配置Action
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 通用流程页面配置数据
	 */
	private String data;
	
	/**
	 * JBPM 通用流程服务
	 */
	private JbpmCommonService jbpmCommonService;
	
	/**
	 * 调用原系统的JBPM 部署服务
	 */
	private JbpmService jbpmService;
	
	/**
	 * 流程配置服务
	 */
	protected ITProcessConfigService processConfigService;
	
	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public JbpmCommonService getJbpmCommonService() {
		return jbpmCommonService;
	}

	public void setJbpmCommonService(JbpmCommonService jbpmCommonService) {
		this.jbpmCommonService = jbpmCommonService;
	}

	public ITProcessConfigService getProcessConfigService() {
		return processConfigService;
	}

	public void setProcessConfigService(ITProcessConfigService processConfigService) {
		this.processConfigService = processConfigService;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 跳转到通用流程配置界面
	 * @return
	 */
	public String toJbpmCommonConfig(){
		return "toJbpmCommonConfig";
	}
	
	/**
	 * 跳转到新增流程配置界面
	 * @return
	 */
	public String toAddProcessConfig(){
		return "toAddProcessConfig";
	}
	
	/**
	 * 通过流程图配置页面
	 * 生成流程图配置文件
	 * 生成流程图
	 * 打包部署流程
	 * @return
	 * @throws Exception 
	 */
	public String makeJbpm() throws Exception{
		
		String info ="success";
		BufferedWriter buffWri = null;
		String str = null;
		
		String xmlPath = "d:/jbpmOut.jpdl.xml";
		String pName = "";
		//生成JBPM XML文件
		try {
			File f = new File(xmlPath);
			if (!f.exists()) {
				f.createNewFile();
			}
			// 解决xml中文乱码问题
			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(f), "UTF-8");
			buffWri = new BufferedWriter(write);
			// 将data数据转换成符合jbpm的JsonObject
			if (data != null) {
				JSONObject jsonObject = new JSONObject(data);
				JSONObject propsPJson = jsonObject.getJSONObject("props");
				pName = propsPJson.getJSONObject("props").getJSONObject("name").getString("value");
				str = jbpmCommonService.makeJbpmJsonByData(data);
			}
			// jbpm xml文件的开头
			buffWri.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			buffWri.newLine();
			// jbpm xml文件的结尾
			buffWri.write(str);
			buffWri.newLine();
			buffWri.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffWri != null)
					buffWri.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//生成JBPM PNG文件
		String pngPath="";
		String pngPath2 = "";
		File file2 = null;
		try {
			/*pngPath = this.jbpmService.getPngPath();
			File file=new File(pngPath);
			if(!file.isDirectory()){
				file.mkdir();
			}*/
			file2 = new File("d:/jbpmOut.png");
			file2.createNewFile();
			//生成流程图片
			JpdlModel jpdlModel;
			try {
				  jpdlModel = new JpdlModel (xmlPath);
				  ImageIO.write(new JpdlModelDrawer().draw(jpdlModel), "png", file2);  
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		pngPath2 = file2.getPath();
		
	    File xmlFile = new File(xmlPath);
		File pngFile = new File(pngPath2);
		
		ProcessDefinition definition = null;
		try {
			definition = jbpmService.deployProcess(xmlFile, pngFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String definitionId = definition.getId();
		TProcessConfig processConfig = new TProcessConfig();
		processConfig.setDefinitionId(definitionId);
		processConfig.setProcessName(pName);
		//状态-可用
		processConfig.setState("01");
		//通用流程
		processConfig.setBusinessType("99");
		processConfig.setUploadOrg(this.getCurrentOnlineUser().getOrgid());
		processConfig.setUserId(this.getCurrentOnlineUser().getEmpid());
		processConfigService.insert(processConfig);
		Struts2Utils.renderText(info);
		return null;
	}
	
}
