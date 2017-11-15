package com.framework.mybatis.example.model;

import com.framework.commons.tools.Logger;

public class Response extends Model {

    private final static long serialVersionUID = 1L;
    
    private final static Logger logger = new Logger( Response.class );

    private final static int SUCCESS_CODE 			= 0; 
    private final static int ERROR_EXCEPTION_CODE 	= -1;

    private Integer code;
    private String 	message;
    private Object 	objectResponse;
    
    
    public Response () {
    	createSuccess(null);
    }//end constructor()
    
    public Response(Integer code, String message, Object objectResponse) {
    	createSuccess(null);
		this.code 			= code;
		this.message 		= message;
		this.objectResponse = objectResponse;
	}//end constructor()


	public String getMessage() {
		return message;
	}//end getMessage()
    
	private void setMessage(String message) {
		
		if (this.message == null || this.message.equals("")) {
			this.message = message;
		} else if (this.code == SUCCESS_CODE) {
			this.message = message;
		}//end if
		
	}//end setMessage()
	
	public Object getObjectResponse() {
		return objectResponse;
	}//end getObjectResponse()
	
	public void setObjectResponse(Object objResponse) {
		this.objectResponse = objResponse;
	}//end setObjectResponse()
    
	public boolean success() {
		return this.code != null && this.code.equals(SUCCESS_CODE);
	}//end success()
	
	public Integer getCode() {
		return code;
	}//end getCode()
	
	public void createError(String msg) throws Exception {
		logger.error("Creating error: " + msg);
		setMessage(msg);
		this.code = ERROR_EXCEPTION_CODE;
		
		throw new Exception(msg);
	}//end createError()
	
	public void createError(String msg, Exception e) throws Exception {
		logger.error("Creating error: " + msg);
		logger.error(e);
		setMessage(msg);
		this.code = ERROR_EXCEPTION_CODE;
		
		throw new Exception(msg, e);
	}//end createError()
	
	public void createFinalError(Exception e) {
		String msg = "An error occurred.";
		logger.error("Creating error: " + msg);
		logger.error(e);
		setMessage(msg);
		this.code = ERROR_EXCEPTION_CODE;
	}//end createFinalError()
	
	public void createSuccess(String msg) {
		this.code = SUCCESS_CODE;
		setMessage(msg);
	}//end createSuccess()
	
	
	@Override
	public void clear() {
		code 			= null;
		message 		= null;
		objectResponse 	= null;
	}//end clear()
}
