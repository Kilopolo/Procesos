package com.gmail.pablo23dr.applet;

import java.applet.Applet;
import java.awt.Graphics;
/**
 * vamos a necesitar:
 * (x,y) ---> coordenadas del centro de la bola
 * (variable,fija)
 * 
 * -------------------
 * -                 -
 * -                 -
 * -------<-o->-------
 * -                 -
 * -                 -
 * -------------------
 * 
 * vector de direccion
 * vector de velocidad
 * 
 * 
 * @author Pablo
 *
 */
public class MiApplet extends Applet implements Runnable {

	private Thread t = null;
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void start() {
		t = new Thread(this);
	}
	
	@Override
	public void stop() {
		super.stop();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void run() {
		
		
		//bucle que nos mete todo dentro
		//while() {
			//variar los parametros de la animación
			//repaint();
			//Thread.sleep(100);  	cada frame va a durar 100ms
		
		
		
		//}
		
	}
}
