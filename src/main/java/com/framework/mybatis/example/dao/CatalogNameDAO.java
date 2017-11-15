package com.framework.mybatis.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.commons.tools.Logger;
import com.framework.mybatis.example.model.CatalogName;
import com.framework.mybatis.example.model.Response;
import com.framework.mybatis.example.model.mapper.ICatalogNameMapper;

@Service
public class CatalogNameDAO {

	@Autowired
	private ICatalogNameMapper mapper;
	
	private final static Logger logger = new Logger( CatalogNameDAO.class );
	
	public void addDemoGroup(CatalogName catalogName, Response response) throws Exception {
		
		logger.traceEnteringMethod();
		
		int recordId = mapper.addCatalogName(catalogName);
			
		if(recordId > 0) {
			response.createSuccess("CatalogName inserted correctly.");
		} else {
			response.createError("Could not insert catalogName.");
		}//end if
		
		logger.traceLeavingMethod();
		
	}//addCatalogName()
	
	public void removeCatalogName(Integer id, Response response) throws Exception {
		
		logger.traceEnteringMethod();
		
		int affectedRows = mapper.removeCatalogName(id);
		
		if(affectedRows > 0) {
			response.createSuccess("CatalogName deleted correctly.");
		} else {
			response.createError("Could not delete catalogName.");
		}//end if
		
		logger.traceLeavingMethod();
		
	}//end removeCatalogName()
	
	public void editCatalogName(CatalogName catalogName, Response response) throws Exception {
		
		logger.traceEnteringMethod();
		
		int affectedRows = mapper.editCatalogName(catalogName);
		
		if(affectedRows > 0) {
			response.createSuccess("CatalogName updated correctly.");
		} else {
			response.createError("Could not update catalogName.");
		}//end if
		
		logger.traceLeavingMethod();
		
	}//end editCatalogName()
	
	public List<CatalogName> findCatalogNames(Integer id) {
		
		logger.traceEnteringMethod();
		
		List<CatalogName> result = mapper.findCatalogNames(id);
		
		logger.traceLeavingMethod(result);
		
		return result;
		
	}//end findCatalogNames()
}
