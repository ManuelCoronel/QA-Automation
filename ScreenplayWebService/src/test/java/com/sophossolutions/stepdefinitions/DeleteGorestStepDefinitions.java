package com.sophossolutions.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import java.io.File;

import com.sophossolutions.task.ExecuteDelete;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.actors.OnStage;

public class DeleteGorestStepDefinitions {
	
	
	@When("consult the endpoint for delete {string}")
	public void consultTheEndpointForDelete(String strEndPoint) {
		OnStage.theActorInTheSpotlight().attemptsTo(ExecuteDelete.withTokens(strEndPoint));
	}
	
	@Then("validate the status code {int}")
	public void validateTheStatusCode(Integer intStatusCode) {
		System.out.println("saliendo then");
	OnStage.theActorInTheSpotlight().should(seeThatResponse(validatResponse -> validatResponse.statusCode(intStatusCode)));
	}
}
