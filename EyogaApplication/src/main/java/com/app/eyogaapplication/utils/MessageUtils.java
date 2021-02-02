package com.app.eyogaapplication.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessageUtils {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String messageKey, Object... args) {
		return messageSource.getMessage(messageKey, args, messageKey, Locale.getDefault());
	}

	public String messageForKey(String key, Locale locale) {
		return messageSource.getMessage(key, null, key, locale);
	}

	public String messageForKey(String key, Locale locale, Object... params) {
		return messageSource.getMessage(key, params, key, locale);

	}
}
