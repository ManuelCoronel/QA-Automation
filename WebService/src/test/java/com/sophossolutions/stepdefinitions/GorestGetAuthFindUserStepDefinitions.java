package com.sophossolutions.stepdefinitions;

import com.sophossolutions.apis.GorestApi;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

public class GorestGetAuthFindUserStepDefinitions {
	
	@When("consult the endpoint {string} with token")
	public void consultTheEndpointWithToken(String strEndPoint) {
//	 SerenityRest.given().auth().oauth2(GorestApi.STR_TOKEN).get(Constants.getData("base url gorest").concat(Constants.getData("endpoint user-GET")));
//	SerenityRest.lastResponse().prettyPeek();
		
		SerenityRest.given().headers("Authorization","Bearer ".concat(GorestApi.STR_TOKEN),"Content-Type",ContentType.JSON).get(Constants.getData("base url gorest").concat(Constants.getData("endpoint user-GET")));
		SerenityRest.lastResponse().prettyPeek();
	}

}
