package com.sophossolutions.stepdefinitions;

import java.util.Map;

import com.sophossolutions.apis.GorestApi;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.datatable.DataTable;
public class GetGorestStepDefinitions {
	@Before
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("Dado que {string} set the base  url {string}")
	public void dadoQueSetTheBaseUrl(String strActorName, String strBaseUrl) {
//	OnStage.theActorCalled(strActorName).whoCan(CallAnApi.at(strBaseUrl))
		GorestApi.setBaseUrl(Constants.getData(strBaseUrl));
	}

	@When("consult the endpoint {string}")
	public void consultTheEndpoint(String strEndPoint) {
		GorestApi.executeGetRest(Constants.getData(strEndPoint));
	}
	
	
	@Then("validate the status code {int} and the schema with {string}")
	public void validateTheStatusCodeAndTheSchemaWith(Integer intStatusCode, String strSchema, DataTable dataTable) {
		GorestApi.validateResponse(intStatusCode, Constants.getData(strSchema));
	}


	@Then("validate the status code <code> and the data user")
	public void validateTheStatusCodeCodeAndTheDataUser(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		GorestApi.validateStatusCode(Integer.parseInt(map.get("code")));
		GorestApi.validateField("name", map.get("name"));
		GorestApi.validateField("email", map.get("email"));
		GorestApi.validateField("gender", map.get("gender"));
		GorestApi.validateField("status", map.get("status"));
		
	}

}
