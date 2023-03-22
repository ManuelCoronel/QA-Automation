package com.sophossolutions.pages;

import org.openqa.selenium.By;

import com.sophossolutions.actions.Actions;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.guru99.com/V4/")
public class GuruLogin extends PageObject {
	By userName = By.name("uid");
	By password = By.name("password");
	By btnLogin = By.name("btnLogin");
	
	public void navegar(String url) {
		this.getDriver().navigate().to(url);;
	}
	
	public void login(String userName,String password){
		Actions.sendData(this.getDriver(), this.userName, userName);
		Actions.sendData(this.getDriver(), this.password, password);
		Actions.clickBtn(getDriver(), btnLogin);
		
	}
}
