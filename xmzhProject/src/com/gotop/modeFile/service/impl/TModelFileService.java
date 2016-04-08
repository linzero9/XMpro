package com.gotop.modeFile.service.impl;

import com.gotop.modeFile.dao.ITModelFileDAO;
import com.gotop.modeFile.model.TModelFile;
import com.gotop.modeFile.model.TModelFileExample;
import com.gotop.modeFile.service.ITModelFileService;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TModelFileService implements ITModelFileService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TModelFileService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITModelFileDAO tModelFileDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settModelFileDAO(ITModelFileDAO tModelFileDAO) throws Exception {
        this.tModelFileDAO = tModelFileDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITModelFileDAO gettModelFileDAO() throws Exception {
        return this.tModelFileDAO;
    }


    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(TModelFile obj) throws Exception {
        this.tModelFileDAO.insert(obj);
    }


    /**
     * 批量插入数据
     * @abatorgenerated
     */
    public void insertBatch(List abs) throws Exception {
        if(abs==null){
            	return;
        }
        for(int i=0;i<abs.size();i++){
            	TModelFile tObject = (TModelFile)abs.get(i);
            	this.insert(tObject);
        }
    }

	@Override
	public List<TModelFile> queryFileById(String executionId,String modeId,String modeType) {
	
		return this.tModelFileDAO.queryFileById(executionId, modeId, modeType);
	}

	@Override
	public TModelFile getFileResource(String fileId) {
		// TODO Auto-generated method stub
		return this.tModelFileDAO.getFileResource(fileId);
	}

	@Override
	public void deleteFileToFileName(TModelFile file) throws Exception {
		// TODO Auto-generated method stub
		this.tModelFileDAO.deleteFileToFileName(file);
	}

}