package com.example.demo.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.errorresponse.ErrorResponse;
import com.example.demo.exception.EmployeeIdNotFound;
import com.example.demo.exception.NoDataFoundException;

@ControllerAdvice
public class EmployeeRestControllerAdvice {
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	
	public final ResponseEntity<ErrorResponse>  handleEmployeeIdNotFound(EmployeeIdNotFound e, WebRequest request){
		
		List<String> details = new ArrayList<String>();
		
		details.add(e.getLocalizedMessage());
		
		ErrorResponse errorResponse =  new ErrorResponse("INCORRECT_REQUEST",details);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
		
	}
	
	
@ExceptionHandler(NoDataFoundException.class)
	
	public final ResponseEntity<ErrorResponse>  handleNoDataFoundException(NoDataFoundException e, WebRequest request){
		
		List<String> details = new ArrayList<String>();
		
		details.add(e.getLocalizedMessage());
		
		ErrorResponse errorResponse =  new ErrorResponse("INCORRECT_REQUEST",details);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
		
	}

}
