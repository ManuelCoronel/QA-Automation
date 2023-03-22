package com.sophossolutions.task;

import com.sophossolutions.interactions.ConsoleMessage;
import com.sophossolutions.models.UserCredentials;
import com.sophossolutions.ui.GuruLoginPage;
import com.sophossolutions.ui.NewToursLoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class SetCredentials implements Task {

	private String strUser;
	private String strPassword;
	private Target btnSubmit;
	private Target txtUser;
	private Target txtPassword;

	public SetCredentials(String strUser, String strPassword) {
		this.strUser = strUser;
		this.strPassword = strPassword;
	}

	public SetCredentials(String strUser, String strPassword, Target btnSubmit, Target txtUser, Target txtPassword) {
		super();
		this.strUser = strUser;
		this.strPassword = strPassword;
		this.btnSubmit = btnSubmit;
		this.txtUser = txtUser;
		this.txtPassword = txtPassword;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(this.strUser).into(txtUser), Enter.theValue(this.strPassword).into(txtPassword),
				ConsoleMessage.withMessage(" Mensaje del task"), Click.on(btnSubmit));

		UserCredentials strLocal =  actor.recall("Mensaje");
		System.out.println(strLocal.toString());
	}

	public static SetCredentials form(String strUser, String strPassword) {
		return Tasks.instrumented(SetCredentials.class, strUser, strPassword);
	}

	public static SetCredentials formGuru(String strUser, String strPassword) {

		return Tasks.instrumented(SetCredentials.class, strUser, strPassword, GuruLoginPage.btnSubmit,
				GuruLoginPage.txtUser, GuruLoginPage.txtPassword);
	}

	public static SetCredentials formNewTours(String strUser, String strPassword) {
		return Tasks.instrumented(SetCredentials.class, strUser, strPassword, NewToursLoginPage.btnSubmit,
				NewToursLoginPage.txtUser, NewToursLoginPage.txtPassword);
	}

}
