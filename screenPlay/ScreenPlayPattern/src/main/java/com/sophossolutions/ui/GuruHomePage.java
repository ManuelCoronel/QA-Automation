package com.sophossolutions.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GuruHomePage extends PageObject {
	public static Target txtWelcome = Target.the("Titulo de Bienvenida")
			.locatedBy("//td[contains(text(),'Manger')]");
}
