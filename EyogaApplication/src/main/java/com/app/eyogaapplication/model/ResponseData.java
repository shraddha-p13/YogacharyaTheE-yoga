package com.app.eyogaapplication.model;

public class ResponseData {
	
	private String message;
	private String messageCode;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	@Override
	public String toString() {
		return "ResponseData [message=" + message + ", messageCode=" + messageCode + "]";
	}
}