package com.sophossolutions.apis;

import java.util.ArrayList;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import com.sophossolutions.restinteractions.RestInteraction;

import io.restassured.path.json.JsonPath;

public class RickApi {
	
	public static void setBaseUrl(String strBaseUrl) {
		RestInteraction.setBaseUrl(strBaseUrl);
	}

	public static void executeGetRest(String strEndPoint) {
		RestInteraction.executeGetRest(strEndPoint);
	}

	public static void validateStatusCode(int intStatusCode) {
		RestInteraction.validateStatusCode(intStatusCode);
	}

	public static void validateField(String strKey, String strValue) {
		RestInteraction.validateField(strKey, strValue);
	}
	
	public static void validateField(ArrayList<String> keys,String strValue) {
		RestInteraction.validaFieldInDict(keys,strValue);
	}
	
	public static void validateData(DataTable dataTable,String strSchema) {
		

		RickApi.validateDataInformation(dataTable);
		RestInteraction.validateSchema(strSchema);
	}
	
	
	public static void validateDataInformation(DataTable dataTable) {
		
		Map<String, String> map = dataTable.asMap();
		RickApi.validateStatusCode(Integer.parseInt(map.get("code")));
		RickApi.validateField("name", map.get("name"));
		RickApi.validateField("email", map.get("email"));
		RickApi.validateField("gender", map.get("gender"));
		RickApi.validateField("status", map.get("status"));  
		ArrayList<String>keys = new ArrayList<>();
		keys.add("location");
		keys.add("name");
		RickApi.validateField(keys, map.get("location"));
		
	}

	public static void pruebaModeloRespuesta() {
		RestInteraction.pruebaModeloRespuesta();
		
	}
	
	
	

	
}
