package com.sophossolutions.stepdefinitions;

import com.sophossolutions.exceptions.UnexpectedResult;
import com.sophossolutions.questions.TextOf;
import com.sophossolutions.task.SetCredentials;
import com.sophossolutions.ui.NewToursHomePage;
import com.sophossolutions.ui.NewToursLoginPage;
import com.sophossolutions.utils.Constants;
import org.hamcrest.Matchers;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class NewToursLoginStepDefinitions {
	
	Constants constantes;
	
	@Before()
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}
	
	@Given("be in {string}")
	public void beIn(String strUrl) {
		//OnStage.theActorCalled("Manuel").wasAbleTo(Open.browserOn(new LoginPage()));
		OnStage.theActorCalled("Manuel").wasAbleTo(Open.url(constantes.getData(strUrl)));
		//OnStage.theActorInTheSpotlight().wasAbleTo(null);
	}

	@When("insert credentials {string} and {string}")
	public void insertCredentialsAnd(String strUser, String strPassword) {
		OnStage.theActorInTheSpotlight().wasAbleTo(SetCredentials.formNewTours(strUser,strPassword));
	}

	@Then("validate message in home with the word {string}")
	public void validateMessageInHomeWithTheWord(String strWord) {
 OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextOf.field(NewToursHomePage.txtWelcome),Matchers.equalTo(strWord)).orComplainWith(UnexpectedResult.class,"El titulo del elemento no concide con el esperado"));
	}
	
	
	
	

}
