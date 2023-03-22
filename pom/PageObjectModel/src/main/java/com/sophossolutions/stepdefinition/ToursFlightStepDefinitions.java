package com.sophossolutions.stepdefinition;

import com.sophossolutions.pages.ToursFlight;
import com.sophossolutions.pages.ToursFlightReservation;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
public class ToursFlightStepDefinitions {

	ToursFlight flights;
	ToursFlightReservation flightReservation;
	
	@Given("be in the page flight {string}")
	public void beInThePageFlight(String url) {
		flights.navegar(Constants.getData(url));
	}

	@When("select fligth with the parameters")
	public void selectFligthWithTheParameters(DataTable dataTable) {
		flights.selectFlight(dataTable);
	}
	
	@Then("validate the reservation with the text {string}")
	public void validateTheReservationWithTheText(String string) {
	flightReservation.validateText(string);
	}


}
