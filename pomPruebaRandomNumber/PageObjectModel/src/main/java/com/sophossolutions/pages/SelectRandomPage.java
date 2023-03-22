package com.sophossolutions.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.sophossolutions.actions.Actions;

import net.serenitybdd.core.pages.PageObject;

public class SelectRandomPage extends PageObject {

	
	By selectBuild = By.name("buildNumber");
	By btnRoll = By.id("rollDiceButton");
	By inputNumber = By.id("numberGuess");
	By btnSubmit = By.id("submitButton");
	By textWin = By.xpath("//label[@id='feedbackLabel']//i");
	public static String numberFound = "";
	public static int intentos = 0;
	
	public void navegar(String url) {
		this.getDriver().navigate().to(url);
	}
	
	
	public void tryWin(String strNumber) {
		for (int i = 0; i < 15; i++) {
			Actions.sendData(getDriver(), inputNumber, strNumber);
			Actions.clickBtn(getDriver(), btnSubmit);
			intentos++;
		String	findWord = Actions.getText(getDriver(), textWin);
			if(findWord.contains("Correct")) {
				break;
			}
			if(findWord.contains("Too high")) {
				strNumber = (Integer.parseInt(strNumber)-1)+"";
			}
			if(findWord.contains("Too low")) {
				strNumber = (Integer.parseInt(strNumber)+1)+"";
			}
			
		}
		
		numberFound = strNumber;
		System.out.println("Ultimo numero intentado :"+numberFound);
		System.out.println("Cantidad de intentos :"+intentos);
		}
		
	
	public void validateGame() {
			boolean booleanEncontrado = Actions.getText(getDriver(), this.textWin).contains("Correct");
			assertEquals("Numero no encontrado",true,booleanEncontrado );
		
	}
	public void rollNumber(String strType, String strNumber) {
		Actions.selectFromOption(getDriver(),strType, selectBuild);
		Actions.clickBtn(getDriver(), btnRoll);
		tryWin(strNumber);
		
		
	}
}
