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
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ExecutePost implements Task {

	private String strEndPoint;
	private Object jsonBody;
	
	
	public ExecutePost(String strEndPoint,DataTable dataTable) {
		super();
		this.strEndPoint = strEndPoint;
		this.jsonBody = dataTable.asMap();
	}
	
	public ExecutePost(String strEndPoint,String strUrlBody) {
		super();
		this.strEndPoint = strEndPoint;
		try {		
			this.jsonBody = new String(Files.readAllBytes(Path.of(Constants.getData(strUrlBody))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Post.to(Constants.getData(strEndPoint)).with(requestEspecification -> requestEspecification.header(HttpHeaders.CONTENT_TYPE,
				ContentType.JSON).auth().oauth2(Constants.getData("token")).body(jsonBody)));
	SerenityRest.lastResponse().prettyPrint();
		
	}
	
	public static ExecutePost withToken(String strEndpoint,DataTable dataTable) {
		
		return Tasks.instrumented(ExecutePost.class, strEndpoint,dataTable);
		
	}
	
	public static ExecutePost withToken(String strEndpoint,String strUrlBody) {
		
		return Tasks.instrumented(ExecutePost.class, strEndpoint,strUrlBody);
		
	}

}
