package com.sophossolutions.stepdefinitions;

import java.util.Map;

import com.sophossolutions.apis.GorestApi;
import com.sophossolutions.utils.Constants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

public class PostGorestStepDefinitions {
	
	@When("consult the {string} por medio de una peticion post.")
	public void consultThePorMedioDeUnaPeticionPost(String strEndPoint,DataTable dataTable) {
		GorestApi.executePostWithToken(dataTable, strEndPoint);
	}

}
