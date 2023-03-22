package com.sophossolutions.excercise;

public abstract class Cafe implements Cloneable{

	private String strNombre;
	private String strTipo;
	private Adicion adicion;
	
	public Cafe(String strNombre, String strTipo) {
		super();
		this.strNombre = strNombre;
		this.strTipo = strTipo;
	}
	
	  public Object clone() throws CloneNotSupportedException
	    {
	        return super.clone();
	    }
	
	public abstract void consumir();

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public String getStrTipo() {
		return strTipo;
	}

	public void setStrTipo(String strTipo) {
		this.strTipo = strTipo;
	}

	public Adicion getAdicion() {
		return adicion;
	}

	public void setAdicion(Adicion adicion) {
		this.adicion = adicion;
	}

	@Override
	public String toString() {
		String strToString="Cafe "+ strTipo+" "+ strNombre;
		if(adicion!=null)strToString+=" con adicion de "+adicion.getStrNombre();
		return strToString;
	}
	

	public String toString2() {
		String strToString="Cafe "+ strTipo+" "+ strNombre;
		return strToString;
	}
	


}
