package com.example.demo.errorresponse;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError implements Serializable{

	private static final long serailVersionUID =1L;
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
	private LocalDateTime timeStamp;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;
	
	private ApiError() {
		timeStamp = LocalDateTime.now();
	}
	public ApiError(HttpStatus status) {
		this();
		this.status = status;
	}
	public ApiError(HttpStatus status, Throwable ex) {
		super();
		this.status = status;
		this.message = "unexpected error";
		this.debugMessage =ex.getLocalizedMessage() ;
	}
	public ApiError(HttpStatus status, String message, Throwable ex) {
		super();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
	private void addSSubError(ApiSubError subError) {
		if(subErrors == null) {
			subErrors =  new ArrayList<>();
		}
		subErrors.add(subError);
	}
	public HttpStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
