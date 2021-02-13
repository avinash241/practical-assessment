package com.example.demo.controlleradvice;

import java.net.http.HttpHeaders;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.cfg.context.Constrainable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.errorresponse.ApiError;

import lombok.extern.slf4j.Slf4j;
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		// TODO Auto-generated method stub
   System.err.println("hello");
   ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
   return buildResponseEntity(apiError);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception){
		System.out.println("in the exception handler");
		ApiError apiError= new ApiError(HttpStatus.BAD_REQUEST);
		return buildResponseEntity(apiError);
		
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		
		return new ResponseEntity<Object>(apiError,apiError.getStatus());
	}
	
	
	
}
	
	

