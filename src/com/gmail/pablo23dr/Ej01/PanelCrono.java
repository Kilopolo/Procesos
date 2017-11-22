package com.gmail.pablo23dr.Ej01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable{

	private int horas = 0;
	private int minutos = 0;
	private int segundos = 0;
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
			
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
