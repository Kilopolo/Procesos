package com.gmail.pablo23dr.PongApplet;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {

	final int WITDH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	
	
	@Override
	public void init() {
		this.resize(WITDH, HEIGHT);
		
		this.addKeyListener(this);
		p1= new HumanPaddle(1);
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WITDH, HEIGHT);
		p1.draw(g);
		
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {

		for (;;) {

			p1.move();
			
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
