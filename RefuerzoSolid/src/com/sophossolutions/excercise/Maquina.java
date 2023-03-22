package com.sophossolutions.excercise;

import java.util.ArrayList;

public class Maquina implements IMaquina {
	
	private ArrayList<Cafe> cafeLista;
	private ArrayList<Adicion>adicionesLista;
	
	
	public Maquina() {
		super();
		this.cafeLista = new ArrayList<>();
		
		cafeLista.add(new CafeCaliente("Express landa"));
		cafeLista.add(new CafeCaliente("Rapid lts"));
		cafeLista.add(new CafeCaliente("Krt"));
		
		cafeLista.add(new CafeFrio("Aromas nieves"));
		cafeLista.add(new CafeFrio("Lismtomr"));
		cafeLista.add(new CafeFrio("zendya"));
		
		this.adicionesLista = new ArrayList<>();
		
		adicionesLista.add(new Adicion("Azucar"));
		adicionesLista.add(new Adicion("Bicarbonato"));
		adicionesLista.add(new Adicion("sal"));
	}
	
	@Override
	public void agregarAdicionalAlCafe(Cafe cafe,int posAdicion) {
		if(posAdicion==-1)return;
		cafe.setAdicion(adicionesLista.get(posAdicion));
	};
	
	@Override
	public void prepararCafe() {
		System.out.println("Preparando cafe");
	}


	@Override
	public ArrayList<Adicion> obtenerAdicionales() {
		return adicionesLista;
	}

	@Override
	public ArrayList<Cafe> ObtenerCafes() {
		return cafeLista;
	}


	
	
	
	
	
}
