package com.sophossolutions.interactions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sophossolutions.models.Flight;
import com.sophossolutions.ui.FilterFlights;
import com.sophossolutions.ui.HomeVuelosPage;
import com.sophossolutions.utils.FilterTool;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ShowAirline implements Interaction {

	Target airline;
	Target price;

	public ShowAirline(Target airline, Target price) {
		super();
		this.airline = airline;
		this.price = price;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		ArrayList<Flight> flights = new ArrayList<>();
		readFlights(actor, flights);
		//FilterTool.showLowFlight(flights);
		//FilterTool.showFastFlight(flights);
		FilterTool.showRecomendFlight(flights);
		
		
	}

	public int countElement(WebElement itinerario, String xpath) {
		int cont = 0;
		try {
			WebElement big = itinerario.findElement(By.xpath(xpath));
			cont++;
		} catch (Exception e) {

		}
		return cont;
	}

	public int countSuitcases(WebElement itinerario) {
		int cont = 0;

		 cont+=countElement(itinerario,".//span[@class='bag-image baggage-icon -INCLUDED']"); 
		 cont+=countElement(itinerario,".//span[@class='handbag-image baggage-icon -INCLUDED']"); 
		 cont+=countElement(itinerario,".//span[@class='backpack-image baggage-icon -INCLUDED']"); 
		return cont;
	}

	public Flight createFlight(WebElement itinerario, WebElement container, ArrayList<Flight> flightsReturn, int typeFlight) {
		String strAirline = itinerario.findElement(By.xpath(".//span[@class='name']//span")).getText();
		String time = itinerario.findElement(By.xpath(".//*[contains(@class,'duration-item')]//span")).getText();
		String price = container
				.findElement(By.xpath(".//*[@classes='fare-price']//span[@class='amount price-amount']")).getText();
		int suitcases =countSuitcases(itinerario);
		System.out.println(strAirline + " " + time + " " + price + " " + suitcases + " Maletas");
		Flight flight = new Flight(strAirline, time, Double.parseDouble(price), suitcases, flightsReturn,typeFlight);
		return flight;
	}

	public ArrayList<Flight> flightsReturn(WebElement container) {
		List<WebElement> clustersReturn = container.findElements(By.xpath(".//span[@class='sub-cluster last']"));
		ArrayList<Flight> flightsReturn = new ArrayList<>();
		for (WebElement clusterIda : clustersReturn) {
			List<WebElement> itineariosIda = clusterIda.findElements(By.xpath(".//div[@class='itinerary-container']"));

			for (WebElement itinerario : itineariosIda) {
				flightsReturn.add(createFlight(itinerario, container,new ArrayList<Flight>(),2));
			}

		}
		return flightsReturn;

	}

	public void readFlights(Actor actor, ArrayList<Flight> flights) {

		ListOfWebElementFacades containers = FilterFlights.containers.resolveAllFor(actor);
		for (WebElementFacade container : containers) {
			List<WebElement> clustersIda = container.findElements(By.xpath(".//span[@class='sub-cluster']"));
			ArrayList<Flight> flightsReturn = flightsReturn(container);
			for (WebElement clusterIda : clustersIda) {
				List<WebElement> itineariosIda = clusterIda
						.findElements(By.xpath(".//div[@class='itinerary-container']"));

				for (WebElement itinerario : itineariosIda) {
					flights.add(createFlight(itinerario, container, flightsReturn,1));
				}

			}
		}
	}

	public static ShowAirline showData(Target airline, Target price) {
		return Tasks.instrumented(ShowAirline.class, airline, price);

	}

}
