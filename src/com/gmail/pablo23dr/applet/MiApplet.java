package com.gmail.pablo23dr.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.Random;
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
public class MiApplet extends Applet implements Runnable, KeyListener {

	// private String pelotaPath =
	// "D:\\Users\\Pablo\\Documents\\GitHub\\Procesos\\src\\com\\gmail\\pablo23dr\\applet\\Pelota-de-tenis.png";
	Thread thread = new Thread();
	// private Image img;

	boolean running = true;
	private float x, y, d, vx;;
	private int radio;
	Graphics gfx1, gfx2;
	Image img;
	private BufferedImage buffer;

<<<<<<< HEAD
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
=======
	// public void setImage(String img) { setImage(new ImageIcon(img).getImage()); }
>>>>>>> 3aec2a9ca5454c107542dd84c65fc90a3ab2ce82

	@Override
	public void init() {
		super.init();
		x = getWidth() / 2;
		y = getHeight() / 2;
		vx = 30;
		radio = 30;
		buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		gfx1 = buffer.getGraphics();
		gfx2 = getGraphics();
		this.addKeyListener(this);
	}

	@Override
	public void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	@Override
	public void stop() {

		running = false;
	}

	@Override
	public void destroy() {

		// running = false;
	}

	public void paint() {
		// super.paint(g);
		gfx1.setColor(Color.BLACK);
		this.gfx1.fillRect(0, 0, 600, 600);
		gfx1.setColor(Color.GREEN);
		this.gfx1.fillOval((int) x - radio, (int) y - radio, radio * 2, radio * 2);
		gfx2.drawImage(buffer, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		gfx1.setColor(Color.BLACK);
		gfx1.fillRect(0, 0, getWidth(), getHeight());
		gfx1.setColor(Color.RED);
		gfx1.fillOval((int) x - radio, (int) y - radio, radio * 2, radio * 2);

		gfx2.drawImage(img, 0, 0, null);

	}

	public void run() {
<<<<<<< HEAD
//<<<<<<< HEAD
=======

		long t0 = System.nanoTime(), t1, lapso;
>>>>>>> 3aec2a9ca5454c107542dd84c65fc90a3ab2ce82
		/**
		 * Scanner teclado=new Scanner(System.in); System.out.println("pulse play: p");
		 * String play=teclado.next();
		 */

		// bucle que nos mete todo dentro
		// while(play.equals("p")) {
<<<<<<< HEAD
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
			}}
		}

	=======

	// bucle que nos mete todo dentro
	// while() {
	// variar los parametros de la animación
	// repaint();
	// Thread.sleep(100); cada frame va a durar 100ms
	// dfedfgdfgh

	// }

=======
		
			while (running) {
				// guardo el lapso de tiempo entre ambos puntos de el frame.
				lapso = (t1 = System.nanoTime()) - t0;
				// con esto puedo medir lo que dura un frame
				t0 = t1;

				x += lapso * vx / 1000000000L;
				if (x >= getWidth() - radio) {
					x = getWidth() - radio;
					vx *= -1;
				} else if (x <= radio) {
					x = radio;
					vx *= -1;
				}

				paint();
				// chapuza controlar cosas mediante sleep
				// try {
				// Thread.sleep(100);// cada frame va a durar 100ms
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// System.out.println("Error has occured");
				// }
			}
		
		

		// bucle que nos mete todo dentro
		// while() {
		// variar los parametros de la animación
		// repaint();
		// Thread.sleep(100); cada frame va a durar 100ms
		// dfedfgdfgh

		// }

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			stop();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			start();
			

		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
>>>>>>> 3aec2a9ca5454c107542dd84c65fc90a3ab2ce82
}
