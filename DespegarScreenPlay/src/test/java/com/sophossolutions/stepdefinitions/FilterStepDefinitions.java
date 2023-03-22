package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.FilterByLowPrice;
import com.sophossolutions.ui.FilterFlights;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class FilterStepDefinitions {

	@When("i filter by lowest price")
	public void iFilterByLowestPrice() {
		OnStage.theActorInTheSpotlight().wasAbleTo(FilterByLowPrice.filterLowPrice());

	}



	
	
}
