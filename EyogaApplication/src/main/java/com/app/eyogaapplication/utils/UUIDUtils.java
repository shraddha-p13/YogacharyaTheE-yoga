package com.app.eyogaapplication.utils;

import java.util.UUID;

public class UUIDUtils {

	
	public static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
}
