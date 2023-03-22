package com.sophossolutions.task;

import com.sophossolutions.utils.Constants;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecuteGetWithToken implements Task {

	private String strEndPoint;

	public ExecuteGetWithToken(String strEndPoint) {
		super();
		this.strEndPoint = Constants.getData(strEndPoint);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Get.resource(strEndPoint)
				.with(requestEspecification -> requestEspecification.auth().oauth2(Constants.getData("token"))));

	}

	public static ExecuteGetWithToken withTokens(String strEndPoint) {
		return Tasks.instrumented(ExecuteGetWithToken.class, strEndPoint);
	}

}
