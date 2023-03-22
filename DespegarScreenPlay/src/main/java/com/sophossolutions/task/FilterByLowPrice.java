package com.sophossolutions.task;

import com.sophossolutions.interactions.ShowAirline;
import com.sophossolutions.ui.FilterFlights;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FilterByLowPrice implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

 		actor.attemptsTo(
			WaitUntil.the(FilterFlights.popUp, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
			Click.on(FilterFlights.popUp),
			//Click.on(FilterFlights.filterLowPrice),
		//		WaitUntil.the(FilterFlights.lowestAirline, WebElementStateMatchers.isVisible()).forNoMoreThan(10)
		//				.seconds(),
				ShowAirline.showData(FilterFlights.lowestAirline, FilterFlights.lowestPrice));
				
	}

	public static FilterByLowPrice filterLowPrice() {
		return Tasks.instrumented(FilterByLowPrice.class);
	}

}
