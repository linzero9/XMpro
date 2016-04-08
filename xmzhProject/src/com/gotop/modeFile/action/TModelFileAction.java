package com.gotop.modeFile.action;

import com.eos.server.dict.DictManager;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.file.model.TFileResourceTable;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.service.ITModelFileService;
import com.gotop.modeFile.service.impl.TModelFileService;
import com.gotop.util.FileUploadUtil;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

public class TModelFileAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected     ITModelFileService tModelFileService;
    
   // private TModelFile obj=null;
	private File[] files;
	private String[] filesFileName;
 
	private List<TModelFile> modelFiles;
	
	private String modeId;
	private String executionId;
	private  String modeType;
	
	private String fileId;
	
	
    public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getModeId() {
		return modeId;
	}

	public void setModeId(String modeId) {
		this.modeId = modeId;
	}

	public List<TModelFile> getModelFiles() {
		return modelFiles;
	}

	public void setModelFiles(List<TModelFile> modelFiles) {
		this.modelFiles = modelFiles;
	}

/*	public TModelFile getObj() {
		return obj;
	}

	public void setObj(TModelFile obj) {
		this.obj = obj;
	}*/

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	/**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settModelFileService(ITModelFileService tModelFileService) {
        this.tModelFileService = tModelFileService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITModelFileService gettModelFileService() {
        return this.tModelFileService;
    }


    public String insertFiletest() throws Exception {
    	

    	 TModelFile	obj=new TModelFile();
    	
    	List<TModelFile>  objs = new ArrayList<TModelFile>();
    	

	    	 String suffixStr = null;
	    	 String address="";

	    	 address=DictManager.getDictName("ZHPT_FILE_PATH","01");
	    	Properties props=System.getProperties();
	    	System.out.println(props.getProperty("os.name"));
	    	if(address==null||"".equals(address))
			     address=ServletActionContext.getServletContext().getRealPath("/uploadfile");
	    	else {
	    	    	if(props.getProperty("os.name").indexOf("Windows")>=0)
	    		    	address="f:"+address;
	    	 }  
	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
	    		 String fileDate=sdf.format(new Date());//时间
    	
		       	 for(int i=0;i<filesFileName.length;i++){
		    		 String uuid = UUID.randomUUID().toString();//UUID
		       		 suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名      		 
			       		obj.setExecutionId("002");
			       		obj.setModeId("5");
			       		obj.setModeType("mod1");
			       		
			       		byte[] content = FileCopyUtils.copyToByteArray(files[i]);		       		
			       		obj.setModeFiles( content);
			       		
		       		obj.setFileName(filesFileName[i]);
		       		obj.setFilePath(address+File.separator+fileDate+File.separator+uuid+suffixStr); 
		       		
		       		
		    		 FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);
				   //  tModelFilesDAO.insertTFileResource(tfile);	    
		    		 tModelFileService.insert(obj);
		    		 objs.add(obj);
		       	 }
		       	//modelFiles = objs;

		return "testfile";	
    }

    public String selectFiletest() throws Exception {
    	
/*    	executionId="001";
    	modeId="4";
    	modeType="mod1";*/
    	
    	modelFiles=tModelFileService.queryFileById(executionId, modeId, modeType);
    	
		return "list1";
    	
    }
    
	/**
	 * 下载文件
	 */
	public void downLoadFile()throws Exception{
		HttpServletResponse response=getResponse();
		if(fileId==null||"".equals(fileId.trim())){
			throw new Exception("要下载是文件编号为空！");
		}
		BufferedInputStream instream = null;
		ServletOutputStream out = response.getOutputStream();
		try{
//			TFileResourceTable tfile=tFileResourceTableService.getFileResource(fileId);
			TModelFile tfile=tModelFileService.getFileResource(fileId);
			if(tfile!=null){
			String filePath=tfile.getFilePath();
			if(filePath==null || "".equals(filePath)){
				return;
			}
			log.debug("下载渲染结果路径:"+filePath);
			File file = new File(filePath);
			//System.out.println(new String(tfile.getFileName().getBytes("iso8859-1"),"UTF-8"));
			// 清空response
			response.reset();
			//设置下载文件的类型为任意类型
			response.setContentType("application/x-download");
			response.setContentType("octets/stream");  
			response.addHeader("Content-Type", "text/html; charset=utf-8");  
			  String downLoadName = new String(tfile.getFileName().getBytes("gbk"), "iso8859-1"); 
//			response.setContentType("application/zip");
			//添加下载文件的头信息。此信息在下载时会在下载面板上显示，比如：迅雷下载显示的文件名称，就是此处filiname
			response.addHeader("Content-Disposition","attachment;filename="+downLoadName); 
			//添加文件的大小信息
			response.addHeader("Content-Length", "" + file.length()); // 设置返回的文件类型 
			instream = new BufferedInputStream(new FileInputStream(file));
			byte[] b = new byte[1];
			int count;
			while((count = instream.read(b))!=-1){
				out.write(b, 0, count);
			}
			out.flush();
			}
			
		}catch (Exception e) {
			log.error("下载文件异常", e);
			e.printStackTrace();
		}finally{
			if(instream!=null){
				instream.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}
    
	/**
	 * 通过fileId来删除文件
	 * @return
	 */
      public String deleteFile(){
    	  String info="";
		try {
//			TFileResourceTable file=new TFileResourceTable();
//			file.setFileId(Long.valueOf(fileId));
//			tFileResourceTableService.deleteFileToFileName(file);
			TModelFile file=new TModelFile();
			BigDecimal bd=new BigDecimal(fileId);
			file.setFileId(bd);
			tModelFileService.deleteFileToFileName(file);
			
			info="success";
		} catch (Exception e) {
			log.error("删除文件异常", e);
		}
		Struts2Utils.renderText(info);
		return null;
	}
	
    
}