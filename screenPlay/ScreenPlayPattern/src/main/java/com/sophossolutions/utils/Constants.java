package com.sophossolutions.utils;

import java.util.HashMap;
import java.util.Map;


public class Constants {

	private static Constants instance;
	private Map<String, String> constantDir = new HashMap<String, String>();

	private Constants() {
		constantDir.put("New tours page", "https://demo.guru99.com/test/newtours/");
		constantDir.put("Guru Page Login", "https://demo.guru99.com/V4/");

	}

	public static String getData(String key) {
		if (instance == null) {
			instance = new Constants();
		}
		return instance.constantDir.get(key);
	}

}