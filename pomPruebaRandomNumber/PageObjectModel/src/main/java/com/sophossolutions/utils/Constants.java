package com.sophossolutions.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	private static Constants instance;
	private Map<String, String> constantDir = new HashMap<String, String>();

	private Constants() {
		constantDir.put("numbers page", "https://testsheepnz.github.io/random-number.html");

	}

	public static String getData(String key) {
		if (instance == null) {
			instance = new Constants();
		}
		return instance.constantDir.get(key);
	}

}
