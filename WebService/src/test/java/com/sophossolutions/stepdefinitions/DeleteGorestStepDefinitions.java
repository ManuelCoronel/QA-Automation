package com.sophossolutions.stepdefinitions;

import com.sophossolutions.apis.GorestApi;
import com.sophossolutions.restinteractions.RestInteraction;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

public class DeleteGorestStepDefinitions {
	
	
	@When("consult the endpoint for delete {string} with id {int}")
	public void consultTheEndpointForDeleteWithId(String strEndPoint, Integer intId) {
		SerenityRest.given().auth().oauth2(GorestApi.STR_TOKEN).contentType(ContentType.JSON).when().delete(RestInteraction.strBaseUrl.concat(Constants.getData(strEndPoint).concat(intId+"")));
		SerenityRest.lastResponse().prettyPeek();

	}
	@Then("validate the status code {int}")
	public void validateTheStatusCode(Integer intStatus) {
	    GorestApi.validateStatusCode(intStatus);
	}
}
