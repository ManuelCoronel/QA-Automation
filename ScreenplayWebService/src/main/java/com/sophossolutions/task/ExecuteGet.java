package com.sophossolutions.task;

import com.sophossolutions.utils.Constants;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecuteGet implements Task {

	private String strEndPoint;

	public ExecuteGet(String strEndPoint) {
		super();
		this.strEndPoint = Constants.getData(strEndPoint);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Get.resource(strEndPoint));

	}

	public static ExecuteGet with(String strEndPoint) {
		return Tasks.instrumented(ExecuteGet.class, strEndPoint);
	}

}
