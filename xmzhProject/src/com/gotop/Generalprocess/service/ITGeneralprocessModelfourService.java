package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfourDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.Generalprocess.model.TGeneralprocessModelfour;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModelfourService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessModelfourDAO(ITGeneralprocessModelfourDAO tGeneralprocessModelfourDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessModelfourDAO gettGeneralprocessModelfourDAO() throws Exception;

    /**
     * 动态查询实例，分页查询数据并返回list
     * @abatorgenerated
     */
    List queryDataGrid(HashMap map, Page page) throws Exception;

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    void insert(TGeneralprocessModelfour obj) throws Exception;

    /**
     * 删除单条记录
     * @abatorgenerated
     */
    void delete(TGeneralprocessModelfour obj) throws Exception;

    /**
     * 批量更新数据
     * @abatorgenerated
     */
    void updateBatch(List abs) throws Exception;

    /**
     * 批量插入数据
     * @abatorgenerated
     */
    void insertBatch(List abs) throws Exception;

    /**
     * 批量删除数据
     * @abatorgenerated
     */
    void deleteBatch(List abs) throws Exception;

    /**
     * datacell方式批量更新数据
     * @abatorgenerated
     */
    void updateDataGrid(HashMap hmp) throws Exception;

    /**
     * 查询所有数据并返回List
     * @abatorgenerated
     */
    List queryAllDataList(HashMap map) throws Exception;

    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    List queryPageDataList(HashMap map, Page page) throws Exception;

    
    /**
     * 根据流程id和taskName查询出模式四对象
     * @param modelFour
     * @return
     */
	ProcessModelFour queryModelFour(ProcessModelFour modelFour);

	/**
	 * 处理模式四对象
	 * @param muo
	 * @param modelFour
	 * @param taskAssgineeDto
	 */
	void handleModelFour(MUOUserSession muo, ProcessModelFour modelFour,String files, String jees,
			TaskAssgineeDto taskAssgineeDto);

	List<ProcessModelFourMistake> queryFourMistake(ProcessModelFour modelFour);

}