package com.gotop.peopleManagement.dao;

import java.util.List;
import java.util.Map;

import com.gotop.peopleManagement.model.OmInformation;
import com.primeton.utils.Page;

public interface IOmInformationDao {

	List<OmInformation> selectOmInformationList(Map<String, Object> map,Page page);

}
