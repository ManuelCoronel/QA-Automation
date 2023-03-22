package com.sophossolutions.stepdefinition;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.sophossolutions.pages.SelectRandomPage;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;

public class SelectRandomStepDefinitions {
	@Managed
	WebDriver myBrowser;
	SelectRandomPage page;
	
	@Given("El usuario debe estar en la pagina de random {string}")
	public void elUsuarioDebeEstarEnLaPaginaDeRandom(String strUrl) {
		page.navegar(Constants.getData(strUrl));
	}
	@When("el usuario selecciona la opcion de tipo de juego e ingresa el numero que adivina")
	public void elUsuarioSeleccionaLaOpcionDeTipoDeJuegoEIngresaElNumeroQueAdivina(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String>mapInfo= dataTable.asMap();
		page.rollNumber(mapInfo.get("tipo"), mapInfo.get("numero"));
	}
	@Then("Se valida  la cadena {string}")
	public void seValidaLaCadena(String string) {
		page.validateGame();
	}
	
}
