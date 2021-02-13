package com.example.demo.exception;

public class EmployeeIdNotFound extends Exception{
	
	public EmployeeIdNotFound(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}
	
	

}
