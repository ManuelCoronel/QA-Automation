package com.sophossolutions.models;

import java.util.ArrayList;

import net.bytebuddy.asm.Advice.This;

public class Flight implements Comparable {

	private String strAirline;
	private String strTime;
	private double dbPrice;
	private int intSuitcases;
	private int hoursDuration;
	private int minutesDuration;
	private int type; // 1 Ida , 2 de regreso
	private int totalHoursDuration;
	private int totalMinutesDuration;
	ArrayList<Flight> returnFlights;

	public Flight(String strAirline, String strTime, double price) {
		super();
		this.strAirline = strAirline;
		this.strTime = strTime;
		this.dbPrice = price;
		returnFlights = new ArrayList<>();
	}

	public Flight(String strAirline, String strTime, double price, int intSuitcases, ArrayList<Flight> returnFlights,
			int type) {
		super();
		this.strAirline = strAirline;
		this.strTime = strTime;
		this.dbPrice = price;
		this.intSuitcases = intSuitcases;
		this.returnFlights = returnFlights;
		this.hoursDuration = 0;
		this.minutesDuration = 0;
		this.type = type;
		this.totalHoursDuration = 0;
		this.totalMinutesDuration = 0;
		convertTime();
		if (type == 1) {
			calculateBestTimeDuration();
			System.out.println("Vuelo de ida");
		}
		System.out.println("Mejor tiempo" + this.totalHoursDuration + " h " + totalMinutesDuration + " min");
	}

	public void calculateBestTimeDuration() {
		int durationTotal = 0;
		int hours = 0;
		int minutes = 0;
		int i = 0;
		for (Flight flight : returnFlights) {
			if (i == 0) {
				durationTotal = (flight.hoursDuration * 60) + flight.minutesDuration;
				hours = flight.hoursDuration;
				minutes = flight.minutesDuration;
				i++;
			} else {
				if ((flight.hoursDuration * 60) + flight.minutesDuration < durationTotal) {
					durationTotal = (flight.hoursDuration * 60) + flight.minutesDuration;
					hours = flight.hoursDuration;
					minutes = flight.minutesDuration;
				}

			}
		}
		System.out.println("pendiente" + hours + " " + minutes);
		sumHoursAndMinutes(hours, minutes);

	}

	public void sumHoursAndMinutes(int hours, int minutes) {

		this.totalHoursDuration = this.hoursDuration + hours + ((minutes + this.minutesDuration) / 60);
		this.totalMinutesDuration = ((minutes + this.minutesDuration) % 60);

	}

	public void convertTime() {
		ArrayList<Integer> time = new ArrayList<>();
		boolean start = false;

		String num = "";
		for (int i = 0; i < strTime.length(); i++) {
			if (strTime.charAt(i) >= 48 && strTime.charAt(i) <= 57) {
				if (!start) {
					start = true;
					num = strTime.charAt(i) + "";
				} else {
					num += strTime.charAt(i);
				}
			} else {
				if (start) {
					time.add(Integer.parseInt(num));
					start = false;
				}
			}
		}
		if (time.size() == 1) {
			this.minutesDuration = time.get(0);
		} else {
			this.hoursDuration = time.get(0);
			this.minutesDuration = time.get(1);
		}

		System.out.println(this.hoursDuration + " " + " Horas");
		System.out.println(this.minutesDuration + " " + " Minutos");
	}

	public int getTotalHoursDuration() {
		return totalHoursDuration;
	}

	public void setTotalHoursDuration(int totalHoursDuration) {
		this.totalHoursDuration = totalHoursDuration;
	}

	public int getTotalMinutesDuration() {
		return totalMinutesDuration;
	}

	public void setTotalMinutesDuration(int totalMinutesDuration) {
		this.totalMinutesDuration = totalMinutesDuration;
	}

	public double getDbPrice() {
		return dbPrice;
	}

	public void setDbPrice(double dbPrice) {
		this.dbPrice = dbPrice;
	}

	public int getIntSuitcases() {
		return intSuitcases;
	}

	public void setIntSuitcases(int intSuitcases) {
		this.intSuitcases = intSuitcases;
	}

	public String getStrAirline() {
		return strAirline;
	}

	public void setStrAirline(String strAirline) {
		this.strAirline = strAirline;
	}

	public String getStrTime() {
		return strTime;
	}

	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

	public ArrayList<Flight> getReturnFlights() {
		return returnFlights;
	}

	public void setReturnFlights(ArrayList<Flight> returnFlights) {
		this.returnFlights = returnFlights;
	}

	@Override
	public String toString() {
		return "Flight [Nombre aerolinea=" + strAirline +", dbPrice=" + dbPrice + ", Tipo equipaje ="
				+ intSuitcases + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
