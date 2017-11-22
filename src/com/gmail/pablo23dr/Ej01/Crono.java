package com.gmail.pablo23dr.Ej01;

public class Crono {
	private int horas = 0;
	private int minutos = 0;
	private int segundos = 0;
	private long ns = 0;
	
	public void add (long ns) {
		this.ns += ns;
	}
	
	
	public void reset() {
		ns = 0;
	}


	@Override
	public String toString() {
		return "" + ns + "";
	}
	
	
}
