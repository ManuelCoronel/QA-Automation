package com.sophossolutions.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.sophossolutions.pages.GuruNewTours;
import com.sophossolutions.pages.GuruToursLoginSuccesfully;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;

public class GuruNewToursStepDefinitions {

	GuruNewTours guruTours;
	GuruToursLoginSuccesfully guruSucess;
	@Managed
	WebDriver myBrowser;
	
	@Given("El usuario debe estar en la pagina de guru tours {string}")
	public void elUsuarioDebeEstarEnLaPaginaDeGuruTours(String string) {
		guruTours.navegar("https://demo.guru99.com/test/newtours");
	}

	@When("ingresa credenciales  en guru tours con usuario {string} y la password {string}")
	public void ingresaCredencialesEnGuruToursConUsuarioYLaPassword(String string, String string2) {
		guruTours.login("mngr480432","EtadUdy");
	}

	@Then("Se valida  la cadena en el home de guru tours  {string}")
	public void seValidaLaCadenaEnElHomeDeGuruTours(String string) {
		guruSucess.validateText(string);
	}

}
