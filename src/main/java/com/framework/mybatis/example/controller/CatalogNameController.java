package com.framework.mybatis.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.commons.tools.Logger;
import com.framework.mybatis.example.model.CatalogName;
import com.framework.mybatis.example.model.Response;
import com.framework.mybatis.example.service.CatalogNameService;

@RestController
@RequestMapping("/catalogname")
public class CatalogNameController {

	@Autowired
	private CatalogNameService service;

	private final static Logger logger = new Logger( CatalogNameController.class);


	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseEntity<Response> addDemoGroup(@RequestBody CatalogName catalogName) {
		
		logger.traceEnteringMethod();
		logger.debugObject(catalogName);

		ResponseEntity<Response> response = new ResponseEntity<Response>(service.addCatalogName(catalogName), HttpStatus.OK);

		logger.traceLeavingMethod(response);

		return response;
		
	}//end addCatalogName()

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseEntity<Response> removeDemoGroup(@PathVariable Integer id) {
		
		logger.traceEnteringMethod();
		logger.debugObject(id);
		
		ResponseEntity<Response> response = new ResponseEntity<Response>(service.removeCatalogName(id), HttpStatus.OK);

		logger.traceLeavingMethod(response);

		return response;
		
	}//end removeCatalogName()

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseEntity<Response> editCatalogName(@RequestBody CatalogName catalogName) {
		
		logger.traceEnteringMethod();
		logger.debugObject(catalogName);
		
		ResponseEntity<Response> response = new ResponseEntity<Response>(service.editCatalogName(catalogName), HttpStatus.OK);

		logger.traceLeavingMethod(response);

		return response;
		
	}//end editCatalogName()

	@RequestMapping(value = {"", "/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseEntity<Response> getCatalogNames(@PathVariable Optional<Integer> id) {

		logger.traceEnteringMethod();
		logger.debugObject(id);
		
		Integer catalogNameId = id.isPresent() ? id.get() : null;

		ResponseEntity<Response> response = new ResponseEntity<Response>(service.getCatalogNames(catalogNameId), HttpStatus.OK);

		logger.traceLeavingMethod(response);

		return response;
		
	}//end getCatalogNames()
}

