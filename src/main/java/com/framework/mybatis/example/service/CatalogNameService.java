package com.framework.mybatis.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.commons.tools.Logger;
import com.framework.mybatis.example.dao.CatalogNameDAO;
import com.framework.mybatis.example.model.CatalogName;
import com.framework.mybatis.example.model.Response;

@Service
public class CatalogNameService {

	@Autowired
	private CatalogNameDAO dao;

	private final static Logger logger = new Logger( CatalogNameService.class );
	
	public Response addCatalogName(CatalogName catalogName) {
		
		logger.traceEnteringMethod();
		logger.debugObject(catalogName);
		
		Response response = new Response();
		
		try {
			
			if (catalogName.getDescription() != null) {
				dao.addDemoGroup(catalogName, response);
				response.setObjectResponse(catalogName);
			} else {
				response.createError("Params: description is required.");
			}//end if
			
		} catch (Exception e) {
			response.createFinalError(e);
		}//end try
		
		logger.traceLeavingMethod(response);
		
		return response;
		
	}//end addCatalogName()
	
	public Response removeCatalogName(Integer id) {
		
		logger.traceEnteringMethod();
		logger.debugObject(id);
		
		Response response = new Response();
		
		try {
			if (id != null) {
				CatalogName currentCatalogName = dao.findCatalogNames(id).isEmpty() ? null : dao.findCatalogNames(id).get(0);
				if (currentCatalogName == null) {
					response.createError("The catalogName with id = " + id + " does not exist.");
				} else {
					dao.removeCatalogName(id, response);
					response.setObjectResponse(currentCatalogName);
				}//end if
			} else {
				response.createError("Params: id is required.");
			}//end if
		} catch (Exception e) {
			response.createFinalError(e);
		}//end try
		
		logger.traceLeavingMethod(response);
		
		return response;
		
	}//end removeCatalogName()
	
	public Response editCatalogName(CatalogName catalogName) {
		
		logger.traceEnteringMethod();
		logger.debugObject(catalogName);
		
		Response response = new Response();
		
		try {
			if (catalogName.getId() != null && catalogName.getDescription() != null) {
				List<CatalogName> catalogNames = dao.findCatalogNames(catalogName.getId());
				CatalogName currentCatalogName = catalogNames.isEmpty() ? null : catalogNames.get(0);
				
				if (currentCatalogName == null) {
					response.createError("The catalogName with id = " + catalogName.getId() + " does not exist.");
				} else {
					catalogName.setId(currentCatalogName.getId());
					dao.editCatalogName(catalogName, response);
					response.setObjectResponse(catalogName);
				}//end if
			} else {
				response.createError("Params: id and description are required.");
			}//end if
		} catch (Exception e) {
			response.createFinalError(e);
		}//end try
		
		logger.traceLeavingMethod(response);
		
		return response;
		
	}//end editCatalogName()
	
	public Response getCatalogNames(Integer id) {
		
		logger.traceEnteringMethod();
		logger.debugObject(id);
		
		Response response = new Response();
		
		try {
			List<CatalogName> result = dao.findCatalogNames(id);
			response.setObjectResponse(result);
			
			switch(result.size()) {
			case 0:
				response.createError("The catalogName with id = " + id + " does not exist."); 
				break;
			case 1: 
				response.createSuccess(result.size() + " catalogName found.");
				break;
			default: 
				response.createSuccess(result.size() + " catalogNames found.");
				break;
			}//end switch
		} catch (Exception e) {
			response.createFinalError(e);
		}//end try
		
		logger.traceLeavingMethod(response);
		
		return response;
		
	}//end getCatalogNames()
	
}
