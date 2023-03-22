package com.sophossolutions.excercise;

public class CafeCaliente extends Cafe{

	public CafeCaliente(String strNombre) {
		super(strNombre, "Caliente");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumir() {
		System.out.println("Consumiendo un rico cafe "+this.getStrTipo() +" "+this.getStrNombre());
		if(this.getAdicion()!=null) {
			System.out.println("Con adicion de "+this.getAdicion().getStrNombre());
		}
		
	}

}
