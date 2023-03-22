package com.sophossolutions.stepdefinitions;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import com.sophossolutions.task.ExecutePatch;

import io.cucumber.datatable.DataTable;

public class PatchGorestStepDefinitions {

	
	@When("consult the endpoint {string} and make a partial update")
	public void consultTheEndpointAndMakeAPartialUpdate(String strEndPoint, DataTable dataTable) {
		OnStage.theActorInTheSpotlight().attemptsTo(ExecutePatch.with(strEndPoint, dataTable));
	}

}
