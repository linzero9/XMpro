package com.gotop.timeMachine.service;

import com.gotop.timeMachine.dao.ITModelTimedayDAO;
import com.gotop.timeMachine.model.TModelTimeday;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface ITModelTimedayService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settModelTimedayDAO(ITModelTimedayDAO tModelTimedayDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITModelTimedayDAO gettModelTimedayDAO() throws Exception;


    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    List queryWorkDayListWithPage(TModelTimeday day, Page page) throws Exception;

	List checkDayTime(TModelTimeday day);

	void insertWorkDay(TModelTimeday day);

	void updateWorkDayById(TModelTimeday day);

	void delWorkDayById(TModelTimeday day);

	List<TModelTimeday> queryWorkDayById(TModelTimeday day);
}