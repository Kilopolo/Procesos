package ej20171129.prueba1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {


	private double xVel, yVel, x, y;

	public Ball() {
		x = 350;
		y = 250;
		xVel = getRandomSpeed() * getRandomDirection();
		yVel = getRandomSpeed() * getRandomDirection();
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int) x - 10, (int) y - 10, 20, 20);
	}

	public void move() {

		x += xVel;
		y += yVel;

		if (y < 10) {
			yVel = -yVel;
		}
		if (y > 490) {
			yVel = -yVel;
		}
	}
	
	public double getRandomSpeed() {
		return (Math.random() *3 +2);
	}
	public int getRandomDirection() {
		int rand = (int) (Math.random() *2);
		
		if (rand == 1) {
			return 1;
		}else 
			return -1;
		
		
	}
}
