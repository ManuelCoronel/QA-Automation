package com.sophossolutions.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GuruLoginPage extends PageObject {
	public static Target txtUser = Target.the("Campo de username").locatedBy("//input[@name='uid']");
	public static Target txtPassword = Target.the("Campo de username").locatedBy("//input[@name='password']");
	public static Target btnSubmit = Target.the("Campo de username").locatedBy("//input[@type='submit']");

}
