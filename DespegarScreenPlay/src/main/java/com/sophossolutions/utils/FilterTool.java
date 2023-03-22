package com.sophossolutions.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.sophossolutions.models.Flight;

public class FilterTool {

	public static Map<String, Double> showLowFlight(ArrayList<Flight> flights) {
		Map<String, Double> map = new TreeMap<>();

		for (Flight flight : flights) {
			if (!map.containsKey(flight.getStrAirline())) {
				map.put(flight.getStrAirline(), flight.getDbPrice());
			} else {
				double lowPrice = map.get(flight.getStrAirline());
				lowPrice = Math.min(lowPrice, flight.getDbPrice());
				map.put(flight.getStrAirline(), lowPrice);
			}
		}
		showMap(map);
		return map;

	}
	public static Map<String, Flight> showRecomendFlight(ArrayList<Flight> flights) {
		Map<String, Flight> map = new TreeMap<>();

		for (Flight flight : flights) {
			if (!map.containsKey(flight.getStrAirline()+" Equipaje "+flight.getIntSuitcases())) {
				map.put(flight.getStrAirline()+" Equipaje "+flight.getIntSuitcases(), flight);
			} else {
				
				Flight vueloActual = flight;
				double precioVueloActual = vueloActual.getDbPrice();
				Flight vueloRecomendadoActual =map.get(vueloActual.getStrAirline()+" Equipaje "+flight.getIntSuitcases());
				if(precioVueloActual<vueloRecomendadoActual.getDbPrice()) {
					map.put(flight.getStrAirline()+" Equipaje "+vueloRecomendadoActual.getIntSuitcases(), vueloActual);	
				}
				
			}
		}
		showMapFlight(map,"Recomendados");
		return map;

	}
	
	

	public static Map<String, Flight> showFastFlight(ArrayList<Flight> flights) {
		Map<String, Flight> map = new TreeMap<>();

		for (Flight flight : flights) {
			if (!map.containsKey(flight.getStrAirline())) {
				map.put(flight.getStrAirline(), flight);
			} else {
				
				Flight vueloActual = flight;
				int timeVueloActual = vueloActual.getTotalHoursDuration() * 60 + vueloActual.getTotalMinutesDuration();
				Flight vueloRapidoActual =map.get(vueloActual.getStrAirline());
				if(timeVueloActual<vueloRapidoActual.getTotalHoursDuration()*60+vueloRapidoActual.getTotalMinutesDuration()) {
					map.put(flight.getStrAirline(), vueloActual);	
				}
				
			}
		}
		showMapFlight(map,"Rapidos");
		return map;

	}
	
	public static void showMapFlight(Map<String, Flight> flights,String mensaje) {
		System.out.println("Vuelos mas "+mensaje +" por aerolinea :");
		for (Map.Entry<String, Flight> entry : flights.entrySet()) {
			String key = entry.getKey();
			Flight val = entry.getValue();
			
			System.out.println(val.toString());

		}
	}



	public static void showMap(Map<String, Double> flights) {

		for (Map.Entry<String, Double> entry : flights.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			System.out.println("Precio mas baratos :");
			System.out.println("Aerolinea :" + key + " Precio :" + val);

		}
	}

}
