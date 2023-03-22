package com.sophossolutions.ui;

import net.serenitybdd.screenplay.targets.Target;

public class NewToursHomePage {
	public static Target txtWelcome = Target.the("Titulo de Bienvenida")
			.locatedBy("//h3[contains(text(),'Login')]");
}
