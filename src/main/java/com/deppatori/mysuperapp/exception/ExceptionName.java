package com.deppatori.mysuperapp.exception;

public class ExceptionName extends RuntimeException{
	private int code;
	private String message;
	
	public ExceptionName(String message) {
		this.message = message;
	}
	
	public ExceptionName(int code, String message) {
		super();
		this.code = code;
		this.message = message;
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
	
	public ExceptionName updateCode(int code) {
		this.code = code;
		return this;
	}
	
	
}
