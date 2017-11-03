package com.gmail.pablo23dr.snakeGameApplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends Applet implements Runnable, KeyListener {

	Graphics gfx;
	Image img;
	Thread thread;
	Snake snake;
	boolean GameOver;
	Token token;

	public void init() {
		// TODO Auto-generated method stub
		super.init();

		this.resize(400, 400);
		GameOver=false;
		img = createImage(400, 400);
		gfx = img.getGraphics();
		this.addKeyListener(this);
		snake = new Snake();
		token = new Token(snake);
		thread = new Thread(this);
		thread.start();

	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, 400, 400);
		if (!GameOver) {
			snake.draw(gfx);
			token.draw(gfx);
		} else {
			gfx.setColor(Color.RED);
			gfx.drawString("Game Over", 180, 150);
			gfx.drawString("Score: " + token.getScore(), 180, 170);
		}
		
		

		g.drawImage(img, 0, 0, null);
	}

	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);

		paint(g);
	}

	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		super.repaint();

		paint(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {

			if (!GameOver) {
				snake.move();
				this.checkGameOver();
				token.snakeColision();
			}
			
			this.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {


		if (!snake.isMoving()) {
			if (e.getKeyCode() == KeyEvent.VK_UP 
				|| e.getKeyCode() == KeyEvent.VK_DOWN 
				|| e.getKeyCode() == KeyEvent.VK_RIGHT ) {
				snake.setMoving(true);
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (snake.getyDir() != 1) {
				snake.setyDir(-1);
				snake.setxDir(0);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (snake.getyDir() != -1) {
				snake.setyDir(1);
				snake.setxDir(0);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (snake.getxDir() != 1) {
				snake.setxDir(-1);
				snake.setyDir(0);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (snake.getxDir() != -1) {
				snake.setxDir(1);
				snake.setyDir(0);
			}
		}
	}

	public void checkGameOver() {
		if (snake.getX() < 0 ||
				snake.getX() > 396) {
			GameOver=true;
		}
		if (snake.getY() < 0 ||
				snake.getY() > 396) {
			GameOver=true;
		}
		
		if (snake.snakeCollision()) {
			GameOver=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
