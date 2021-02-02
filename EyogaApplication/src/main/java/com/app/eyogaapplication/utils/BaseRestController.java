package com.app.eyogaapplication.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseRestController {

	@Autowired
	protected MessageUtils messages;
	
	protected ResponseEntity<Object> constructSuccessResponse(String messageKey, HttpStatus status, Locale locale,
			Object... params) {
		String message = messages.getMessage(messageKey, locale, params);
		MessageItem messageItem = new MessageItem(messageKey, message);

		return new ResponseEntity<>(messageItem, status);
	}
	
	protected ResponseEntity<Object> constructFailureResponse(String messageKey, HttpStatus status, Locale locale) {
		String message = messages.getMessage(messageKey, locale);
		MessageItem messageItem = new MessageItem(messageKey, message);

		return new ResponseEntity<>(messageItem, status);
	}
	
	protected ResponseEntity<Object> constructSuccessResponseForObject(HttpStatus status, Locale locale,
			Object params) {
		
		return new ResponseEntity<>(params, status);
	}
}
