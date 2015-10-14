package com.gotop.deviceManagement.action;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.eos.system.exception.EOSRuntimeException;

public class MyUtil {
	
	//删除指定路径的内容,指定路径可以是文件或目录"
	  public static void delete(String path)
	  {
	    checkStringParams(new String[] { "path" }, new String[] { path });
	    boolean pathIsFile = false;
	    File file = new File(path);
	    try {
	      checkFile(file);
	      pathIsFile = true;
	    }
	    catch (EOSRuntimeException e) {
	    }
	    if (pathIsFile)
	      deleteFile(path);
	    else
	      deleteDir(path);
	  }
	  
	  private static void checkFile(File file) throws EOSRuntimeException {
		    if (!file.exists()) {
		      throw new EOSRuntimeException("24000003", new String[] { file.getAbsolutePath() });
		    }

		    if (!file.isFile())
		      throw new EOSRuntimeException("24000005", new String[] { file.getAbsolutePath() });
		  }

	  //删除指定目录
	  public static void deleteDir(String dirPath)
	  {
	    checkStringParams(new String[] { "dirPath" }, new String[] { dirPath });
	    File dir = new File(dirPath);
	    if (!dir.exists()) {
	      return;
	    }
	    checkDir(dir);
	    try {
	      FileUtils.deleteDirectory(dir);
	    } catch (IOException e) {
	      throw new EOSRuntimeException("24000006", new String[] { e.getMessage() }, e);
	    }
	  }

	  //删除指定文件
	  public static void deleteFile(String filePath)
	  {
	    checkStringParams(new String[] { "filePath" }, new String[] { filePath });

	    File file = new File(filePath);
	    if (!file.exists()) {
	      return;
	    }
	    checkFile(file);
	    file.delete();
	  }
	  
	private static void checkStringParams(String[] paramNames, String[] paramValues)
	  {
	    for (int i = 0; i < paramValues.length; i++)
	      if (StringUtil.isBlank(paramValues[i]))
	        throw new EOSRuntimeException("24000001", new String[] { paramNames[i] });
	  }
	
	private static void checkDir(File file)
		    throws EOSRuntimeException
		  {
		    if (!file.exists()) {
		      throw new EOSRuntimeException("24000003", new String[] { file.getAbsolutePath() });
		    }

		    if (!file.isDirectory())
		      throw new EOSRuntimeException("24000002", new String[] { file.getAbsolutePath() });
		  }

}
