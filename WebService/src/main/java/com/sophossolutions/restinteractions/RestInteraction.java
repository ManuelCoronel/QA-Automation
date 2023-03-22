package com.sophossolutions.restinteractions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophossolutions.models.RickAndMortyCharacter;
import com.sophossolutions.utils.Constants;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;

public class RestInteraction {
	public static String strBaseUrl;

	public static void setBaseUrl(String strBaseUrl) {
		RestInteraction.strBaseUrl = strBaseUrl;
	}

	public static void executeGetRest(String strEndPoint) {
		SerenityRest.given().when().get(strBaseUrl.concat(strEndPoint));

		SerenityRest.lastResponse().prettyPeek();
	}

	public static void validateStatusCode(int intStatusCode) {
		int responseCode = SerenityRest.lastResponse().getStatusCode();
		assertEquals(intStatusCode, responseCode, "The status code doesnt match");

	}
	

	public static void validateField(String strKey, String strValue) {
		JsonPath responseJSON = SerenityRest.lastResponse().jsonPath();
		String strValueObtained = responseJSON.getString(strKey);
		assertEquals(strValue, strValueObtained, " Los campos no coinciden");
	}

	public static JsonPath getJSON() {
		return SerenityRest.lastResponse().jsonPath();
	}

	public static JsonPath getDictJSON(JsonPath json, String strKey) {
		return json.get(strKey);
	}

	public static void validaFieldInDict(ArrayList<String> keys, String strValue) {
		JsonPath json = RestInteraction.getJSON();
		Map<String, Object> jsonConverted = json.get();
		for (int i = 0; i < keys.size() - 1; i++) {
			jsonConverted = (Map<String, Object>) jsonConverted.get(keys.get(i));

		}
		assertEquals((String) jsonConverted.get(keys.get(keys.size() - 1)), strValue, " Los campos no coinciden");

	}
	public static void executePostWithToken(DataTable dataTable,String strToken,String strEndPoint) {
		Map<String, String> body = dataTable.asMap(String.class, String.class);
		SerenityRest.given().auth().oauth2(strToken).contentType(ContentType.JSON).when().body(body).post((RestInteraction.strBaseUrl).concat(Constants.getData(strEndPoint)));
		SerenityRest.lastResponse().prettyPeek();
	}
	
	public static void executePost(String strUrlBody,String strEndPoint) throws IOException { 
		String jsonBody = new String(Files.readAllBytes(Path.of(strUrlBody)));
		SerenityRest.given().contentType(ContentType.JSON).when().body(jsonBody).post((RestInteraction.strBaseUrl).concat(strEndPoint));
		SerenityRest.lastResponse().prettyPeek();
	}

	public static void pruebaModeloRespuesta() {
		RickAndMortyCharacter teacherRick = SerenityRest.lastResponse().as(RickAndMortyCharacter.class);
		System.out.println("Profesor rick " + teacherRick.getId());
		System.out.println(teacherRick.getOrigin().getName());

	}

	public static void validateSchema(String strSchema) {
		SerenityRest.lastResponse().then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(new File(strSchema)));
	}

}
