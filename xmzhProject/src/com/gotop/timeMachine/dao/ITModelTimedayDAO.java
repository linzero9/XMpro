package com.gotop.timeMachine.dao;

import com.gotop.timeMachine.model.TModelTimeday;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;

public interface ITModelTimedayDAO {
    
    /**
     * 分页查询信息
     * @abatorgenerated
     */
    List queryWorkDayListWithPage(TModelTimeday day, Page page) throws Exception;

	List checkDayTime(TModelTimeday day);

	void insertWorkDay(TModelTimeday day);

	void updateWorkDayById(TModelTimeday day);

	void delWorkDayById(TModelTimeday day);

	List queryWorkDayById(TModelTimeday day);

}