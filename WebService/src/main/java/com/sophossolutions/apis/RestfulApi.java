package com.sophossolutions.apis;

import java.io.IOException;

import com.sophossolutions.restinteractions.RestInteraction;

public class RestfulApi {

	public static String id = "";

	public static void setBaseUrl(String strBaseUrl) {
		RestInteraction.setBaseUrl(strBaseUrl);
	}

	public static void executeGetRest(String strEndPoint) {
		RestInteraction.executeGetRest(strEndPoint);
	}

	public static void executePost(String strUrlBody, String strEndPoint) throws IOException {
		System.out.println("Hola");
		RestInteraction.executePost(strUrlBody, strEndPoint);
		setId();
	}
	
	public static void setId() {
		id =RestInteraction.getJSON().getString("id");
	}
	
	public static void validateResponse(int intStatusCode, String urlSchema) {
		RestInteraction.validateSchema(urlSchema);
		RestInteraction.validateStatusCode(intStatusCode);
	}
}
