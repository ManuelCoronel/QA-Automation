package com.sophossolutions.stepdefinitions;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.sophossolutions.apis.RestfulApi;
import com.sophossolutions.restinteractions.RestInteraction;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostRestfulStepDefinitions {

	@Given("the {string} set the base  url  for restful api {string}")
	public void theSetTheBaseUrlForRestfulApi(String strActor, String strUrl) {
		RestfulApi.setBaseUrl(Constants.getData(strUrl));
	}

	@When("consult the {string} with the file {string}")
	public void consultTheWithTheFile(String strEndPoint, String strUrl) throws IOException {
		RestfulApi.executePost(Constants.getData(strUrl), Constants.getData(strEndPoint));
	}

	@Then("validate the status code {int} and the schema restful {string}")
	public void validateTheStatusCodeAndTheSchemaRestful(Integer intStatusCode, String strSchema) {
		RestfulApi.validateResponse(intStatusCode, Constants.getData(strSchema));
	}

}
