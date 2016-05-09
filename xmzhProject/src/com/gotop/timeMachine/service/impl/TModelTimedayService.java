package com.gotop.timeMachine.service.impl;

import com.gotop.timeMachine.dao.ITModelTimedayDAO;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TModelTimedayService implements ITModelTimedayService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TModelTimedayService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITModelTimedayDAO tModelTimedayDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settModelTimedayDAO(ITModelTimedayDAO tModelTimedayDAO) throws Exception {
        this.tModelTimedayDAO = tModelTimedayDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITModelTimedayDAO gettModelTimedayDAO() throws Exception {
        return this.tModelTimedayDAO;
    }


    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryWorkDayListWithPage(TModelTimeday day, Page page) throws Exception {
        List list = tModelTimedayDAO.queryWorkDayListWithPage(day,page);
        return list;
    }

	@Override
	public List checkDayTime(TModelTimeday day) {
		List list = tModelTimedayDAO.checkDayTime(day);
        return list;
	}

	@Override
	public void insertWorkDay(TModelTimeday day) {
		this.tModelTimedayDAO.insertWorkDay(day);
	}

	@Override
	public void updateWorkDayById(TModelTimeday day) {
		this.tModelTimedayDAO.updateWorkDayById(day);
	}

	@Override
	public void delWorkDayById(TModelTimeday day) {
		this.tModelTimedayDAO.delWorkDayById(day);
	}

	@Override
	public List<TModelTimeday> queryWorkDayById(TModelTimeday day) {
		List list = tModelTimedayDAO.queryWorkDayById(day);
        return list;
	}

}