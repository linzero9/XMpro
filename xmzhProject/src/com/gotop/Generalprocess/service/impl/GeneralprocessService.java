package com.gotop.Generalprocess.service.impl;

import java.util.List;

import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.service.IGeneralprocessService;

public class GeneralprocessService implements IGeneralprocessService{

	private IGeneralprocessDAO generalProcessDAO;

	public IGeneralprocessDAO getGeneralProcessDAO() {
		return generalProcessDAO;
	}

	public void setGeneralProcessDAO(IGeneralprocessDAO generalProcessDAO) {
		this.generalProcessDAO = generalProcessDAO;
	}

	@Override
	public void addModelOne(ProcessModelOne modelOne) {
		this.generalProcessDAO.addModelOne(modelOne);
	}

	@Override
	public void uptModelOne(ProcessModelOne modelOne) {
		this.generalProcessDAO.uptModelOne(modelOne);
	}

	@Override
	public ProcessModelOne getProcessModelOneById(String id) {
		return this.generalProcessDAO.getProcessModelOneById(id);
	}

	@Override
	public List<ProcessModelOne> getProcessModelOneByBussinessId(
			String bussinessId) {
		return this.generalProcessDAO.getProcessModelOneByBussinessId(bussinessId);
	}

	
}
