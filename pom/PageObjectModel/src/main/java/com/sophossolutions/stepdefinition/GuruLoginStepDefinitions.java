package com.sophossolutions.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.sophossolutions.pages.GuruHome;
import com.sophossolutions.pages.GuruLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;

public class GuruLoginStepDefinitions {
	GuruLogin guruLogin;
	@Managed
	WebDriver myBrowser;
	GuruHome guruHome;


	@Given("El usuario debe estar en la pagina guru {string}")
	public void elUsuarioDebeEstarEnLaPaginaGuru(String string) {
		guruLogin.navegar(string);
	}

	@When("ingresa credenciales en guru con usuario {string} y la password {string}")
	public void ingresaCredencialesEnGuruConUsuarioYLaPassword(String string, String string2) {
		guruLogin.login(string,string2);
	}

	@Then("Se valida  la cadena en el home de guru {string}")
	public void seValidaLaCadenaEnElHomeDeGuru(String string) {
		System.out.println("En el thenn");
		guruHome.validateText(string);
	}

}
