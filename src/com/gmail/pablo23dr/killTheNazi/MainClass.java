package com.gmail.pablo23dr.killTheNazi;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainClass extends Applet implements Runnable, KeyListener{

	Graphics gfx;
	Image img;
	Thread thread;
	boolean GameOver;
	HumanShip humanShip;
	EnemyShip enemyShip;
	Bullet bullet;
	
	public void init() {
		this.resize(600, 600);
		img = createImage(600, 600);
		gfx = img.getGraphics();
		this.addKeyListener(this);
		GameOver = false;
		humanShip = new HumanShip();
		enemyShip = new EnemyShip();
		
		thread = new Thread(this);
		thread.start();
		
	}	
	
	public void paint(Graphics g) {
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, 600, 600);
		humanShip.draw(gfx);
		enemyShip.draw2(gfx);
		
		g.drawImage(img, 0, 0, null);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		for(;;) {
			
			humanShip.move();
			enemyShip.move();
			
			
			repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * comprobador de reglas del juego
	 */
	public void checkGameOver() {
		
	}
	/**
	 * controles del juego
	 */
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			humanShip.setRightAccel(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			humanShip.setLeftAccel(true);
		}
		
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			humanShip.setRightAccel(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			humanShip.setLeftAccel(false);
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	


}
