package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.FindFlight;
import com.sophossolutions.ui.HomeVuelosPage;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FindFlightStepDefinitions {
	
	@Before()
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}
	@Given("i am in the page {string}")
	public void iAmInThePage(String strUrl) {
		OnStage.theActorCalled("Manuel").wasAbleTo(Open.url(Constants.getData(strUrl)));
	
	}

	@When("i select a day to fly and day to return")
	public void iSelectADayToFlyAndDayToReturn() {
		OnStage.theActorInTheSpotlight().wasAbleTo(FindFlight.findFlight());
	}

	@Then("show me the page of airlines enable")
	public void showMeThePageOfAirlinesEnable() {

	}

}
