package com.sophossolutions.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Actions {
	public static void sendData(WebDriver myBrowser, By target,String data) {
		myBrowser.findElement(target).sendKeys(data);;
	}
	
	public static void clickBtn(WebDriver myBrowser, By target) {
		myBrowser.findElement(target).click();;
	}
	
	public static String getText(WebDriver myBrowser, By target) {
		return myBrowser.findElement(target).getText();
	}
	
	public static void clickSelect(WebDriver myBrowser,ArrayList<By>targets,String option) {
		
		for (By by : targets) { 
			System.out.println(myBrowser.findElement(by).getText()+" =="+option);
			if(myBrowser.findElement(by).getText().equals(option)){
				
				myBrowser.findElement(by).click();
			}
		}
		
	}
	
	
	
	public static void selectFromOption(WebDriver myBrowser,String opcion, By target) {
		WebElement listaSelect = myBrowser.findElement(target);
		Select select = new Select(listaSelect);
		select.selectByVisibleText(opcion);	
	}
	
	

	
	
}
