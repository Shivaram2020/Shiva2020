package com.EvolJob.pro.model;

public class Error {
	int code;
	String message;
	public Error(int a,String b)
	{
		code=a;
		message=b;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
