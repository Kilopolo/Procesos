package com.gmail.pablo23dr.PongApplet;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	double xVel, yVel, x, y;

	public Ball() {
		x = 350;
		y = 250;
		xVel = -2;
		yVel = 1;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, width, height);
	}
	
	public void move() {
		// TODO Auto-generated method stub
		x += xVel;
		y += yVel;
	}

	public double getX() {
		return (int)x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return (int)y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Ball(double xVel, double yVel, double x, double y) {
		super();
		this.xVel = xVel;
		this.yVel = yVel;
		this.x = x;
		this.y = y;
	}

}
