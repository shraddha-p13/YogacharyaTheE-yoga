package com.app.eyogaapplication.utils;

public class MessageItem {

	private String messageCode;
	private String message;

	public MessageItem() {
		// Do nothing
	}

	public MessageItem(String messageCode, String message) {
		this.messageCode = messageCode;
		this.message = message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
