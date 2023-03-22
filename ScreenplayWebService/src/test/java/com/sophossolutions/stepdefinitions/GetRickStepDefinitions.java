package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.ExecuteGet;
import com.sophossolutions.task.ExecuteGetWithToken;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class GetRickStepDefinitions {

	@When("consult the endpoint {string}")
	public void consultTheEndpoint(String strEndPoint) {
		OnStage.theActorInTheSpotlight().attemptsTo(ExecuteGet.with(strEndPoint));
		
	}
	
	
}
