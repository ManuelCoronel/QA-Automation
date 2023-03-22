package com.sophossolutions.pages;


import org.openqa.selenium.By;

import com.sophossolutions.actions.Actions;

import net.serenitybdd.core.pages.PageObject;

public class GuruNewTours extends PageObject {
	
	By userName = By.name("userName");
	By	password = By.name("password");
	By submitBtn = By.name("submit");
	
	public void navegar(String url) {
		this.getDriver().navigate().to(url);;
	}
	
	public void login(String userName,String password){
		Actions.sendData(this.getDriver(), this.userName, userName);
		Actions.sendData(this.getDriver(), this.password, password);
		Actions.clickBtn(getDriver(), submitBtn);
		
	}
	
}
