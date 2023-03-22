package com.sophossolutions.utils;


import java.util.HashMap;
import java.util.Map;


public class Constants {

	private static Constants instance;
	private Map<String, String> constantDir = new HashMap<String, String>();

	private Constants() {
		constantDir.put("base url gorest", "https://gorest.co.in");
		constantDir.put("actor name", "Tester");
		constantDir.put("Json schema User gorest", "src/test/resources/com/sophossolutions/resources/gorest_user_schema.json");
		constantDir.put("Endpoint Post Go Rest", "/public/v2/users/");
		constantDir.put("Endpoint Delete Go Rest", "/public/v2/users/");
		
		constantDir.put("endpoint user-GET", "/public/v2/users/1011410");
		constantDir.put("base url rick Api", "https://rickandmortyapi.com/api");
		constantDir.put("endpoint rick character-GET", "/character/345");
		constantDir.put("Json schema rick", "src/test/resources/com/sophossolutions/resources/rick_schema.json");
		
		constantDir.put("base url restful", "https://api.restful-api.dev");
		constantDir.put("Endpoint Post restful", "/objects");
		constantDir.put("Endpoint Get restful", "/objects/");
		constantDir.put("data restful", "src/test/resources/com/sophossolutions/resources/data_restful.json");
		constantDir.put("Json schema restful", "src/test/resources/com/sophossolutions/resources/restful_schema.json");
		
		
		
		
	}

	public static String getData(String key) {
		if (instance == null) {
			instance = new Constants();
		}
		return instance.constantDir.get(key);
	}

}