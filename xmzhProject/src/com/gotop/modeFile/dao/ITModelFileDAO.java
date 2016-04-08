package com.gotop.modeFile.dao;


import java.util.List;

import com.gotop.file.model.TFileResourceTable;
import com.gotop.modeFile.model.TModelFile;

public interface ITModelFileDAO {
    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    void insert(TModelFile record);
    
    
    //List<TFileResourceTable> queryFileByIdandType(Long id, String resourceType,String fileType);
    List<TModelFile>queryFileById(String executionId,String modeId,String modeType);
    
    TModelFile  getFileResource(String fileId);
    
   	void deleteFileToFileName(TModelFile file)throws Exception;
}