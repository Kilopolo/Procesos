package com.gmail.pablo23dr.snakeGameApplet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	List<Point> snakePoints;
	
	int xDir,yDir;
	boolean isMoving, elongate;
	final int startSize = 20, startX = 180, startY = 180;
	
	
	public boolean isElongate() {
		return elongate;
	}
	public void setElongate(boolean elongate) {
		this.elongate = elongate;
	}
	public Snake() {
		// TODO Auto-generated constructor stub
		snakePoints = new ArrayList<Point>();
		xDir =0;
		yDir = 0;
		
		isMoving=false;
		elongate = false;
		
		snakePoints.add(new Point(startX,startY));
		for (int i = 0; i < startSize; i++) {
			snakePoints.add(new Point(startX-i*4,startY));
		}
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		
		for (Point p : snakePoints) {
			g.fillRect(p.getX(), p.getY(), 4,4);
		}
		
	}
	
	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

	public int getX() {
		return snakePoints.get(0).getX();
	}
	public int getY() {
		return snakePoints.get(0).getY();
	}
	
	public void move() {
		if (isMoving) {
			Point temp = snakePoints.get(0);
			Point last = snakePoints.get(snakePoints.size()-1);
			Point newStart = new Point (temp.getX() + xDir * 4 ,temp.getY() + yDir *4);
			for (int i = snakePoints.size()-1; i >=1; i--) {
				snakePoints.set(i, snakePoints.get(i -1));
			}
			snakePoints.set(0, newStart);
			if (elongate) {
				snakePoints.add(last);
				elongate=false;
			}
		}
	}
	public boolean isMoving() {
		return isMoving;
	}
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	
	public boolean snakeCollision() {
		int x = this.getX();
		int y = this.getY();
		
		for (int i = 4; i < snakePoints.size(); i++) {
			if (snakePoints.get(i).getX() == x 
				&& snakePoints.get(i).getY() == y) 
				return true;
		}
		return false;
		
	}
}
