package com.sophossolutions.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.sophossolutions.actions.Actions;

import net.serenitybdd.core.pages.PageObject;

public class ToursFlightReservation extends PageObject{

	By text = By.xpath("//td/p[@align='left']/font/b/font[@size='4']");
	
	
	public void validateText(String text) {
	assertEquals("Validacion de texto",text , Actions.getText(getDriver(), this.text));
		
	}
}
