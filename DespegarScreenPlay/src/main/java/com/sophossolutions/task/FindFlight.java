package com.sophossolutions.task;

import org.openqa.selenium.Keys;

import com.google.inject.Key;
import com.sophossolutions.ui.HomeVuelosPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FindFlight implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebElementFacade elemento = HomeVuelosPage.inputDestino.resolveFor(actor);

		actor.attemptsTo(Click.on(HomeVuelosPage.inputDestino),
				Enter.theValue("Cúcuta, Norte de Santander, Colombia").into(HomeVuelosPage.inputDestino),
				WaitUntil.the(HomeVuelosPage.destino2, WebElementStateMatchers.isClickable()).forNoMoreThan(10)
						.seconds(),

				Click.on(HomeVuelosPage.destino2),
				Click.on(HomeVuelosPage.inputOrigen),
				Enter.theValue("Cali").into(HomeVuelosPage.inputOrigen),
				WaitUntil.the(HomeVuelosPage.destino2, WebElementStateMatchers.isClickable()).forNoMoreThan(10)
				.seconds(),

				Click.on(HomeVuelosPage.destino2),
				Click.on(HomeVuelosPage.banner), Click.on(HomeVuelosPage.iconCalendario),
				Click.on(HomeVuelosPage.diaIda.of("20")), Click.on(HomeVuelosPage.diaVuelta.of("25")),
				Click.on(HomeVuelosPage.btnAplicar),

				Click.on(HomeVuelosPage.btnBuscar));

	}

	public static FindFlight findFlight() {
		return Tasks.instrumented(FindFlight.class);
	}

}
