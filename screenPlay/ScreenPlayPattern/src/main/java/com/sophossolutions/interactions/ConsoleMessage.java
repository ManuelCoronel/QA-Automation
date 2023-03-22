package com.sophossolutions.interactions;

import com.sophossolutions.models.UserCredentials;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class ConsoleMessage implements Interaction{

	String strMessage;
	
	
	public ConsoleMessage(String strMessage) {
		super();
		this.strMessage = strMessage;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		System.out.println(strMessage);
		strMessage = strMessage + " Hola";
		actor.remember("Mensaje", new UserCredentials("usuario 1", "Password 1"));
	}
	
	public static ConsoleMessage withMessage(String strMessage) {
		return Tasks.instrumented(ConsoleMessage.class,strMessage);
		
	}

}
