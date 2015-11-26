package com.gotop.Generalprocess.service.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelthreeDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.TGeneralprocessModelthree;
import com.gotop.Generalprocess.model.TGeneralprocessModelthreeExample;
import com.gotop.Generalprocess.service.ITGeneralprocessModelthreeService;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TGeneralprocessModelthreeService implements ITGeneralprocessModelthreeService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelthreeService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelthreeDAO tGeneralprocessModelthreeDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelthreeDAO(ITGeneralprocessModelthreeDAO tGeneralprocessModelthreeDAO) throws Exception {
        this.tGeneralprocessModelthreeDAO = tGeneralprocessModelthreeDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelthreeDAO gettGeneralprocessModelthreeDAO() throws Exception {
        return this.tGeneralprocessModelthreeDAO;
    }


	@Override
	public void handleModelThree(MUOUserSession muo,
			ProcessModelThree modelThree, TaskAssgineeDto taskAssgineeDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProcessModelThree queryModelThree(ProcessModelThree modelThree) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(modelThree != null){
			if(modelThree.getFlow_id() != null && !"".equals(modelThree.getFlow_id())){
				map.put("flow_id", modelThree.getFlow_id());
			}
			if(modelThree.getTaskName() != null && !"".equals(modelThree.getTaskName())){
				map.put("taskName", modelThree.getTaskName());
			}
		}
		return this.tGeneralprocessModelthreeDAO.queryModelThree(map);
	}
}