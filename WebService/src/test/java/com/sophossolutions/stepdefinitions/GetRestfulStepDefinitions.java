package com.sophossolutions.stepdefinitions;

import com.sophossolutions.apis.RestfulApi;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.When;

public class GetRestfulStepDefinitions {
	@When("consult the {string}")
	public void consultThe(String string) {
		RestfulApi.executeGetRest(Constants.getData(string).concat(RestfulApi.id));
		System.out.println("completado");
	}



}
