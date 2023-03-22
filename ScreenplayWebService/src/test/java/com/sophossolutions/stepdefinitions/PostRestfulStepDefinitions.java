package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.ExecutePost;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class PostRestfulStepDefinitions {

	@When("consult the {string} with the file {string}")
	public void consultTheWithTheFile(String strEndPoint, String strUrlBody) {
		OnStage.theActorInTheSpotlight().attemptsTo(ExecutePost.withToken(strEndPoint, strUrlBody));
	
	}

	
	
}
