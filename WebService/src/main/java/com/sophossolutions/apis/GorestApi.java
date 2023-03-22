package com.sophossolutions.apis;

import com.sophossolutions.restinteractions.RestInteraction;

import io.cucumber.datatable.DataTable;

public class GorestApi {
	public static final String STR_TOKEN = "31747ee564c2aacbd2643503f588bd275fe748a078d1c61a1e43b6e3ad577d30";
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
	
	public static void validateResponse(int intStatusCode,String strSchema) {
		RestInteraction.validateStatusCode(intStatusCode);
		RestInteraction.validateSchema(strSchema);
	}
	
	public static void executePostWithToken(DataTable dataTable,String strEndPoint) {
		RestInteraction.executePostWithToken(dataTable, GorestApi.STR_TOKEN,strEndPoint);
	}
	
	
	
	//public static void validateFieldLocationName(String strName) {}
	
}
