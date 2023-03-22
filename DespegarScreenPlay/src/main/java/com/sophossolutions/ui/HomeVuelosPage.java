package com.sophossolutions.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomeVuelosPage extends PageObject {

	public static Target boxDestino = Target.the("Destino").locatedBy("//label[contains(text(),'Destino')]/ancestor::div[@class='sbox5-3-input sbox5-3-validation -top-right -lg -icon-left'][1]");
	public static Target inputDestino = Target.the("Destino").locatedBy("//div[@class='sbox5-segment--2_IQ3' and span[contains(text(), 'Tramo 1')]]/descendant::input[@placeholder='Ingresa hacia dónde viajas']");
	public static Target inputOrigen = Target.the("Origen").locatedBy("//div[@class='sbox5-segment--2_IQ3' and span[contains(text(), 'Tramo 1')]]/descendant::input[@placeholder='Ingresa desde dónde viajas']");
	public static 	Target iconCalendario = Target.the("Calendario").locatedBy("//div[@class='sbox5-segment--2_IQ3' and span[contains(text(), 'Tramo 1')]]/descendant::input[@placeholder='Ida']");
	public static Target diaIda = Target.the("Dia de ida").locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']/descendant::div[@class='sbox5-monthgrid-datenumber-number' and text()='{0}'][1]");
	public static Target diaVuelta = Target.the("Dia de Vuelta").locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']/descendant::div[@class='sbox5-monthgrid-datenumber-number' and text()='{0}'][1]");
	public static Target btnAplicar = Target.the("Aplicar").locatedBy("//button[@class='sbox5-3-btn -primary -md']");
	public static Target btnBuscar = Target.the("Buscar").locatedBy("//button[@class='sbox5-box-button-ovr--3LK5x sbox5-3-btn sbox5-button -secondary -icon -lg']");
	public static Target banner = Target.the("Banner").locatedBy("//*[text()='Entendí']");
	public static Target destino2 = Target.the(" Destino foto").locatedBy("(//*[@class='ac-group-items']/child::li)[1]");
}
