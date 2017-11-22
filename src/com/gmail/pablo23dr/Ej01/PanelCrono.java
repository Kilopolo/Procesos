package com.gmail.pablo23dr.Ej01;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable{

	
	private Thread t = null;
	private boolean finalizado = false;
	private long inicio;
	private Crono crono = new Crono();
	
	public void iniciarCrono() {
		
		inicio= System.nanoTime();
				
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
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(Color.YELLOW);
		
		FontMetrics fm = g.getFontMetrics();

		String crono = this.crono.toString();

		int witdh= fm.stringWidth(crono);
		int x = (getWidth()-witdh)/2;
		int y = (getHeight()/2)+ fm.getAscent();
		//no hace falta llamar al metodo to string pq esta override y ya se espera un string
		g.drawString(crono, x, y);
		
		
	}
	
	
	@Override
	public void run() {
		
		long fin;
		
//		Thread hiloActual = Thread.currentThread(); //esto es otra forma de parar el hilo. while(t == hiloActual)
		finalizado = false;
		
		while(!finalizado) {
			
			fin = System.nanoTime();
			crono.add(fin-inicio);
			inicio = fin ;
			
			
			repaint();
			
		}
		
		
	}

}
