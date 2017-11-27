package com.gmail.pablo23dr.ej01;

public class Crono {

	private long ns = 0;

	public void add(long ns) {
		this.ns += ns;
	}

	public void reset() {
		ns = 0;
	}

	@Override
	public String toString() {
		//dejamos intacta la variable local
		long ns = this.ns;
		
		int h = (int) (ns / 3600000000000L);
		
		ns %=3600000000000L;
		
		int m = (int) (ns / 60000000000L);
		ns %= 60000000000L;
		
		int s = (int) (ns / 1000000000L);
		ns %= 1000000000L;
		
		int ms = (int) (ns/1000000L);
//		ns %= 1000000L;
		//%02d nos almacena la variable h con solo 2 digitos y si es solo 1 rellena con 0 por la izquierda y es un integer
		//el formato dado es: 00h:00m:00s.000ms
		return String.format("%02d:%02d:%02d.%03d", h,m,s,ms);
		
//		return "" + ns + "";
	}

}
