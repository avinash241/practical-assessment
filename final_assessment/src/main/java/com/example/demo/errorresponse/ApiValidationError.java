package com.example.demo.errorresponse;

import java.io.Serializable;


public class ApiValidationError extends ApiSubError implements Serializable{
	
	private String Object;
	
	private String field;
	
	private Object rejectedValue;
		
	private String message;
	
	
	public ApiValidationError(String object,String field, Object rejectedValue2, String message2) {
		// TODO Auto-generated constructor stub
		
		
		this.field=field;
		this.rejectedValue=rejectedValue2;
		this.message=message2;
		
		
	}
    public ApiValidationError(String object2, String message2) {
    	
    	this.Object=object2;
    	this.message=message2;
	
	}

}
