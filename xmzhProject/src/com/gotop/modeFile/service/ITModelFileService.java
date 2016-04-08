package com.gotop.modeFile.service;

import com.gotop.file.model.TFileResourceTable;
import com.gotop.modeFile.dao.ITModelFileDAO;
import com.gotop.modeFile.model.TModelFile;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface ITModelFileService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settModelFileDAO(ITModelFileDAO tModelFileDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITModelFileDAO gettModelFileDAO() throws Exception;


    /**
     * 插入单条记录
     * @abatorgenerated
     */
    void insert(TModelFile obj) throws Exception;



    /**
     * 批量插入数据
     * @abatorgenerated
     */
    void insertBatch(List abs) throws Exception;
    
    
    
    List<TModelFile>queryFileById(String executionId,String modeId,String modeType);

	public TModelFile getFileResource(String fileId);
	
	void deleteFileToFileName(TModelFile file)throws Exception;
}