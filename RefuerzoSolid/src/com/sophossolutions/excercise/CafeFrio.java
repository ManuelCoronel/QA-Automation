package com.sophossolutions.excercise;

public class CafeFrio extends Cafe {

	public CafeFrio(String strNombre) {
		super(strNombre, "Frio");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumir() {
		System.out.println("Consumiendo un super cafe "+this.getStrTipo()+" " +this.getStrNombre());
		if(this.getAdicion()!=null) {
			System.out.println("Con adicion de "+this.getAdicion().getStrNombre());
		}
	}

}
