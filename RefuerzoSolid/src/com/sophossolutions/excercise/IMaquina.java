package com.sophossolutions.excercise;

import java.util.ArrayList;

public interface IMaquina {

	public void agregarAdicionalAlCafe(Cafe cafe,int posAdicion);
	public void prepararCafe();
	public ArrayList<Adicion> obtenerAdicionales();
	public ArrayList<Cafe>  ObtenerCafes(); 
}
