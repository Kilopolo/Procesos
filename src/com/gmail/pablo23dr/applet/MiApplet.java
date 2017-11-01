package com.gmail.pablo23dr.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

import javax.swing.ImageIcon;

/**
 * vamos a necesitar: (x,y) ---> coordenadas del centro de la bola
 * (variable,fija)
 * 
 * ------------------- - - - - -------<-o->------- - - - - -------------------
 * 
 * vector de direccion vector de velocidad
 * 
 * 
 * @author Pablo
 *
 */
public class MiApplet extends Applet implements Runnable {

	private String pelotaPath = "D:\\Users\\Pablo\\Documents\\GitHub\\Procesos\\src\\com\\gmail\\pablo23dr\\applet\\Pelota-de-tenis.png";
	Thread thread = new Thread();
	private Image img;
	Player p;
	boolean running = true;

	public static void main(String[] args) {
		
		MiApplet m = new MiApplet();
		m.thread.start();
	}
	/**
	 * public void setImage(String img) { setImage(new ImageIcon(img).getImage()); }
	 */
	@Override
	public void init() {
		setSize(400, 400);
		p = new Player();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

		running = false;
	}

	@Override
	public void start() {
		thread = new Thread(this);
	}

	@Override
	public void stop() {

		running = false;
	}

	public void paint(Graphics g) {
		p.paint(g);
	}

	public void run() {
		/**
		 * Scanner teclado=new Scanner(System.in); System.out.println("pulse play: p");
		 * String play=teclado.next();
		 */

		// bucle que nos mete todo dentro
		// while(play.equals("p")) {
		while (running) {
			// variar los parametros de la animación
			System.out.println("asdasd");
			repaint();
			p.update(this);
			try {
				Thread.sleep(20);// cada frame va a durar 100ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error has occured");
			}
		}

	}
}
