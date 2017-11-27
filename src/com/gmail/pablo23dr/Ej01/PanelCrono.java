package com.gmail.pablo23dr.Ej01;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable {

	private Thread t = null;
	private boolean finalizado = true;
	private boolean pausado = false;
	private long inicio;
	private boolean reseteado = false;
	private Font fuente = new Font("Courier New", Font.PLAIN, 30);
	private Crono crono = new Crono();

	public void iniciarCrono() {

		inicio = System.nanoTime();

		if (t == null) {
			t = new Thread(this);
			t.start();

		}

	}

	/**
	 * sincronizados con el objeto el cual crea estos metodos
	 */
	public synchronized void pausarCrono() {
		pausado = true;

	}

	/**
	 * sincronizados con el objeto el cual crea estos metodos
	 */
	public synchronized void reanudarCrono() {
		inicio = System.nanoTime();
		pausado = false;
		reseteado = false;
		notifyAll();

	}

	public synchronized void detenerCrono() {
		finalizado = true;
		
		
	}
	
	public synchronized void resetearCrono() {
		finalizado = false;
		reseteado = true;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(fuente);
		setBackground(Color.YELLOW);

		FontMetrics fm = g.getFontMetrics();

		String crono = this.crono.toString();

		int witdh = fm.stringWidth(crono);
		int x = (getWidth() - witdh) / 2;
		int y = (getHeight() / 2) + fm.getAscent();
		// no hace falta llamar al metodo to string pq esta override y ya se espera un
		// string
		g.drawString(crono, x, y);

	}

	@Override
	public void run() {

		long fin;

		// Thread hiloActual = Thread.currentThread(); //esto es otra forma de parar el
		// hilo. while(t == hiloActual)
		finalizado = false;

		while (!finalizado) {
			/**
			 * sincronizados con el objeto el cual crea estos metodos
			 */
			synchronized (this) {
				while (pausado == true)
					try {
						wait();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			fin = System.nanoTime();
			if (reseteado) {
				crono.reset();
			}
			crono.add(fin - inicio);
			
			inicio = fin;

			repaint();

		}

	}

}
