package com.sophossolutions.pages;


import org.openqa.selenium.By;

import com.sophossolutions.actions.Actions;

import static org.junit.Assert.assertEquals;
import net.serenitybdd.core.pages.PageObject;

public class GuruHome extends PageObject{
	
	By text = By.xpath("//td[contains(text(),'Manger Id')]");
	
	public void validateText(String text) {
	assertEquals("Validacion de texto",text , Actions.getText(getDriver(), this.text));
		
	}
	
}
