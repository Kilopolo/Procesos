package com.gmail.pablo23dr.PongApplet;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {

	final int WITDH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	HumanPaddle p2;
	Ball b1;
//	AIPaddle p2;
	boolean gameStarted;
//	Graphics gfx;
//	Image img;
	

	public void init() {
		this.resize(WITDH, HEIGHT);
		gameStarted=false;
		this.addKeyListener(this);
		p1= new HumanPaddle(1);
		p2= new HumanPaddle(2);
		b1=new Ball();
//		p2= new AIPaddle(2, b1);
		
//		img = createImage(WIDTH, HEIGHT);
//		gfx = img.getGraphics();
		start();

	}
@Override
public void start() {
	thread = new Thread(this);
	thread.start();
}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, WITDH, HEIGHT);
		if (b1.getX() < -10 || b1.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("Game Over", 350, 250);
		} else {
		p1.draw(g);
		b1.draw(g);
		p2.draw(g);
		}
		
		if (!gameStarted) {
			g.setColor(Color.white);
			g.drawString("Tennis", 340, 100);
			g.drawString("Press Enter to Start", 310, 130);
		}
//		g.drawImage(img, 0, 0, null);
	}


	public void update(Graphics g) {
		paint(g);
	}


	public void run() {

		for (;;) {
			if (gameStarted) {
				p1.move();
				p2.move();
				b1.move();
				b1.checkPaddleCollision(p1, p2);
				
			}
			
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}


	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
			
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameStarted=true;
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			p2.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			p2.setDownAccel(true);
		}
	}


	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			p2.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			p2.setDownAccel(false);
		}
	}


	public void keyTyped(KeyEvent e) {

	}

}
