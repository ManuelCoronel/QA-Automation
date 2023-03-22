package com.sophossolutions.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import java.io.File;
import java.lang.invoke.ConstantCallSite;

import com.sophossolutions.task.ExecuteGet;
import com.sophossolutions.task.ExecuteGetWithToken;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GetGorestStepDefinitions {
	@Before
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("Dado que {string} set the base  url {string}")
	public void dadoQueSetTheBaseUrl(String strActorName, String strBaseUrl) {
		OnStage.theActorCalled(strActorName).whoCan(CallAnApi.at(Constants.getData(strBaseUrl)));
	}


	@When("consult the endpoint {string} with token")
	public void consultTheEndpointWithToken(String strEndPoint) {
		OnStage.theActorInTheSpotlight().attemptsTo(ExecuteGetWithToken.withTokens(strEndPoint));
	}
	

	@Then("validate the status code {int} and the schema with {string}")
	public void validateTheStatusCodeAndTheSchemaWith(Integer intStatusCode, String strSchema) {
		System.out.println(Constants.getData(strSchema)+" "+intStatusCode);
		OnStage.theActorInTheSpotlight().should(seeThatResponse(validatResponse -> validatResponse.statusCode(intStatusCode).body(JsonSchemaValidator.matchesJsonSchema(new File(Constants.getData(strSchema))))));
	}



}
