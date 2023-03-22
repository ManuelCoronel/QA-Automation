package com.sophossolutions.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FilterFlights extends PageObject{

	public static Target lowestAirline = Target.the("Aerolinea con precio mas bajo").locatedBy("//*[contains(@data-sfa-id,'ariline-container')]//span//span[1]");
	public static Target lowestPrice = Target.the(" Precio mas bajo ").locatedBy("(//p[@class='item-fare fare-price']//child::span[@class='amount price-amount'])[1]");
	public static Target filterLowPrice = Target.the("Filtro precios bajos").locatedBy("//*[text()=' baratos']");
	public static Target popUp = Target.the("ventana emergente").locatedBy("//*[@class='eva-3-icon-close tooltip-close']");
	public static Target listaComponentesDeVueloIda = Target.the("Componentes de vuelo").locatedBy("//*[@class='sub-cluster']");
	public static Target containers = Target.the("Containers de vuelos").locatedBy("//span//div[contains(@class,'cluster-container')]");
}
