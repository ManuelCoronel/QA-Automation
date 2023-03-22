package com.sophossolutions.stepdefinitions;

import org.hamcrest.Matchers;

import com.sophossolutions.exceptions.UnexpectedResult;
import com.sophossolutions.questions.TextOf;
import com.sophossolutions.task.SetCredentials;
import com.sophossolutions.ui.GuruHomePage;
import com.sophossolutions.ui.GuruLoginPage;

import com.sophossolutions.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class GuruLoginStepDefinitions {

	@Given("be in the page {string}")
	public void beInThePage(String strUrl) {
		OnStage.theActorCalled("Manuel").wasAbleTo(Open.url(Constants.getData(strUrl)));
	}

	@When("insert credentials in guru with {string} and {string}")
	public void insertCredentialsInGuruWithAnd(String strUser, String strPassword) {
		OnStage.theActorInTheSpotlight().wasAbleTo(SetCredentials.formGuru(strUser, strPassword));
	}

	@Then("validate the home with the word {string}")
	public void validateTheHomeWithTheWord(String strHomeWord) {
		OnStage.theActorInTheSpotlight()
				.should(GivenWhenThen.seeThat(TextOf.field(GuruHomePage.txtWelcome), Matchers.equalTo(strHomeWord))
						.orComplainWith(UnexpectedResult.class, "El titulo del elemento no concide con el esperado"));
	}

}
