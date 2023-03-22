package com.sophossolutions.stepdefinitions;

import java.util.ArrayList;
import java.util.Map;

import com.sophossolutions.apis.RickApi;
import com.sophossolutions.restinteractions.RestInteraction;
import com.sophossolutions.utils.Constants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetRickApiStepDefinitions {
	@Before
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}
	@Given("the {string} set the base  url {string}")
	public void theSetTheBaseUrl(String strActor, String strBaseUrl) {
	  RickApi.setBaseUrl(Constants.getData(strBaseUrl));
	}
	@When("consult the endpoint of rick api {string}")
	public void consultTheEndpointOfRickApi(String strEndPoint) {
		RickApi.executeGetRest(Constants.getData(strEndPoint));
	}
	
	
	@Then("validate the status code <code> , the data character and the {string}")
	public void validateTheStatusCodeCodeTheDataCharacterAndThe(String strSchema, DataTable dataTable) {
		RickApi.validateData(dataTable, strSchema);
	}
	
	@Then("prueba")
	public void prueba() {
		RickApi.pruebaModeloRespuesta();
	}

}
