package com.sophossolutions.task;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.apache.http.HttpHeaders;

import com.sophossolutions.utils.Constants;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;

public class ExecutePatch implements Task {

	private String strEndPoint;
	private Object jsonBody;
	
	
	public ExecutePatch(String strEndPoint,DataTable dataTable) {
		super();
		this.strEndPoint = Constants.getData(strEndPoint);
		this.jsonBody = dataTable.asMap();
	}
	
	

	@Override
	public <T extends Actor> void performAs(T actor) {
		System.out.println(strEndPoint);
		System.out.println(jsonBody);
		actor.attemptsTo(Patch.to(strEndPoint).with(requestEspecification -> requestEspecification.header(HttpHeaders.CONTENT_TYPE,
				ContentType.JSON).auth().oauth2(Constants.getData("token")).body(jsonBody)));
	System.out.println(SerenityRest.lastResponse().prettyPrint());
		
	}
	
	public static ExecutePatch with(String strEndpoint,DataTable dataTable) {
		
		return Tasks.instrumented(ExecutePatch.class, strEndpoint,dataTable);
		
	}
	


}
