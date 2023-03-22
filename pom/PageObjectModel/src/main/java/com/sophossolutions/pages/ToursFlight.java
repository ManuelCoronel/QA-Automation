package com.sophossolutions.pages;

import java.util.ArrayList;
import java.util.Map;

import static com.sophossolutions.actions.Actions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sophossolutions.actions.Actions;

import io.appium.java_client.functions.ExpectedCondition;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;

public class ToursFlight extends PageObject {

	// By radioBtnRoundTrip = By.xpath("//*[@name='tripType' and
	// @value='roundtrip']");
	// By radioBtnOneWay = By.xpath("//*[@name='tripType' and @value='oneway']");
	// By radioBtnEconomyClass = By.xpath("//*[@name='servClass' and
	// @value='Coach']");
	// By radioBtnBussinessClass = By.xpath("//*[@name='servClass' and
	// @value='Business']");
	// By radioBtnFirstClass = By.xpath("//*[@name='servClass' and
	// @value='First']");

	By type;
	By serviceClass;

	By continueBtn = By.name("findFlights");
	By selectPassenger = By.xpath("//*[@name='passCount']");
	By selectDepartingPlace = By.xpath("//*[@name='fromPort']");
	By selectDepartingMonth = By.xpath("//*[@name='fromMonth']");
	By selectDepartingDay = By.xpath("//*[@name='fromDay']");
	By selectPlaceArrive = By.xpath("//*[@name='toPort']");
	By selectMonthArrive = By.xpath("//*[@name='toMonth']");
	By selectDayArrive = By.xpath("//*[@name='toDay']");
	By selectServiceClass = By.xpath("//input[@name='servClass']");
	By selectAirlines = By.xpath("//*[@name='airline']");

	public void navegar(String url) {
		this.getDriver().navigate().to(url);
	}

	public void selectFlight(String type, String numPassengers, String departingPlace, String departingMonth,
			String departingDay, String placeArrive, String monthArrive, String dayArrive, String serviceClass,
			String airlines) {

		this.type = By.xpath("//input[@name='tripType' and @value='" + type + "']");
		this.serviceClass = By.xpath("//input[@name='servClass' and @value='" + serviceClass + "']");
		/*
		if (type.equals("Round Trip"))
			clickBtn(getDriver(), this.radioBtnRoundTrip);
		if (type.equals("One Way"))
			clickBtn(getDriver(), this.radioBtnOneWay);
*/

		clickBtn(getDriver(), this.type);
		selectFromOption(getDriver(), numPassengers, selectPassenger);
		selectFromOption(getDriver(), departingPlace, selectDepartingPlace);
		selectFromOption(getDriver(), departingMonth, selectDepartingMonth);
		selectFromOption(getDriver(), departingDay, selectDepartingDay);
		selectFromOption(getDriver(), placeArrive, selectPlaceArrive);
		selectFromOption(getDriver(), monthArrive, selectMonthArrive);
		selectFromOption(getDriver(), dayArrive, selectDayArrive);
		selectFromOption(getDriver(), airlines, selectAirlines);
		clickBtn(getDriver(), this.serviceClass);
		/*
		 * if (serviceClass.equals("Economy")) clickBtn(getDriver(),
		 * this.radioBtnEconomyClass); if (serviceClass.equals("Business"))
		 * clickBtn(getDriver(), this.radioBtnBussinessClass); if
		 * (serviceClass.equals("First")) clickBtn(getDriver(),
		 * this.radioBtnFirstClass); selectFromOption(getDriver(), airlines,
		 * selectAirlines);
		 */
		
		clickBtn(getDriver(), continueBtn);
		
	}
	public void selectFlight(DataTable table) {
		Map<String,String> map = table.asMap(String.class,String.class);
		this.type = By.xpath("//input[@name='tripType' and @value='" + map.get("type") + "']");
		this.serviceClass = By.xpath("//input[@name='servClass' and @value='" + map.get("serviceClass") + "']");
		

		clickBtn(getDriver(), this.type);
		selectFromOption(getDriver(), map.get("number"), selectPassenger);
		selectFromOption(getDriver(), map.get("departingFrom"), selectDepartingPlace);
		selectFromOption(getDriver(), map.get("departingMonth"), selectDepartingMonth);
		selectFromOption(getDriver(), map.get("departingDay"), selectDepartingDay);
		selectFromOption(getDriver(), map.get("arrivePlace"), selectPlaceArrive);
		selectFromOption(getDriver(), map.get("arriveMonth"), selectMonthArrive);
		selectFromOption(getDriver(), map.get("arriveDay"), selectDayArrive);
		selectFromOption(getDriver(), map.get("Airline"), selectAirlines);
		clickBtn(getDriver(), this.serviceClass);
		/*
		 * if (serviceClass.equals("Economy")) clickBtn(getDriver(),
		 * this.radioBtnEconomyClass); if (serviceClass.equals("Business"))
		 * clickBtn(getDriver(), this.radioBtnBussinessClass); if
		 * (serviceClass.equals("First")) clickBtn(getDriver(),
		 * this.radioBtnFirstClass); selectFromOption(getDriver(), airlines,
		 * selectAirlines);
		 */
		
		clickBtn(getDriver(), continueBtn);
		
	}
}
