package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.ExecutePost;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class PostGorestStepDefinitions {

	
	@When("consult the {string} por medio de una peticion post")
	public void consultThePorMedioDeUnaPeticionPost(String strEndPoint, DataTable dataTable) {
		OnStage.theActorInTheSpotlight().attemptsTo(ExecutePost.withToken(strEndPoint, dataTable));
	}

	
	
}
