package com.sophossolutions.task;

import com.sophossolutions.utils.Constants;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class ExecuteDelete implements Task{
	
	private String strEndPoint;
	
	
	public ExecuteDelete(String strEndPoint) {
		super();
		this.strEndPoint = Constants.getData(strEndPoint);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Delete.from(strEndPoint)
				.with(requestEspecification -> requestEspecification.auth().oauth2(Constants.getData("token"))));
		SerenityRest.lastResponse().prettyPeek();
		
	}
	
	public static ExecuteDelete withTokens(String strEndPoint) {
		return Tasks.instrumented(ExecuteDelete.class,strEndPoint);
	}
}
