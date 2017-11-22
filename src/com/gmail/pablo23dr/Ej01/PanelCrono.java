package com.gmail.pablo23dr.Ej01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable{

	
	private Thread t = null;
	private boolean finalizado = false;
	
	
	public void iniciarCrono() {
		if (t == null) {
			t = new Thread(this);
			t.start();
			
		}
		
		
	}

	public void pausarCrono() {

	}

	public void reanudarCrono() {

	}

	public void detenerCrono() {

	}
	public void paint(Graphics g) {
		
	}
	
	
	@Override
	public void run() {
//		Thread hiloActual = Thread.currentThread(); //esto es otra forma de parar el hilo. while(t == hiloActual)
		finalizado = false;
		
		while(!finalizado) {
			
			
			
			
		}
		
		
	}

}
