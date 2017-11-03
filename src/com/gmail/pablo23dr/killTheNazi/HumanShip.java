package com.gmail.pablo23dr.killTheNazi;

import java.awt.Color;
import java.awt.Graphics;

public class HumanShip {

	double x, dirX;
	boolean leftAccel, rightAccel;
	int y, proportion;
	final double GRAVITY = 0.94;

	public HumanShip() {

		x = 40;
		y = 40;
		proportion = 4;
	}

	public void move() {

	}



	public void draw(Graphics g) {
		/**
		 * alas = x,y 0 = 0,0 1 = 0,1 2 = 1,1 3 = 1,3 4 = 2.3 5 = 2.1 6 =3.1 7 = 3.2 8 =
		 * 4.2 9 = 4.3 10=5.3 11=5.2 12=6.2 13=6.1 14=7.1 15=7.3 16=8.3 17=8.1 18=9.1
		 * 19=9.0 20=0.0
		 * 
		 * cabina =x,y 0 =2.0 1 =2.2 2 =3.2 3 =3.4 4 =4.4 5 =4.6 6 =5.6 7 =5.4 8 =6.4 9
		 * =6.2 10=7.2 11=7.0 12=2.0
		 */
		int xAlasPoints[] = { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0 };
		int yAlasPoints[] = { 0, 1, 1, 3, 3, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 3, 3, 1, 1, 0, 0 };
		int nAlasPoints = 21;
		int xAlasProPoints[]= new int[nAlasPoints];
		int yAlasProPoints[]= new int[nAlasPoints];
		
		for (int i = 0; i < yAlasPoints.length; i++) {
			xAlasProPoints[i]=(int) (getX()+(xAlasPoints[i]*getProportion()));
			yAlasProPoints[i]=(int) (getY()+(yAlasPoints[i]*getProportion())*-1);
			
		}
		
		int xCabinaPoints[] = { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 2 };
		int yCabinaPoints[] = { 0, 2, 2, 4, 4, 6, 6, 4, 4, 2, 2, 0, 0 };
		int nCabinaPoints = 13;
		g.setColor(Color.RED);
		g.fillPolygon(xAlasProPoints, yAlasProPoints, nAlasPoints);
		g.setColor(Color.CYAN);
		g.fillPolygon(xCabinaPoints, yCabinaPoints, nCabinaPoints);

	}
	public int getProportion() {
		return proportion;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getDirX() {
		return dirX;
	}

	public void setDirX(double dirX) {
		this.dirX = dirX;
	}

	public boolean isLeftAccel() {
		return leftAccel;
	}

	public void setLeftAccel(boolean leftAccel) {
		this.leftAccel = leftAccel;
	}

	public boolean isRightAccel() {
		return rightAccel;
	}

	public void setRightAccel(boolean rightAccel) {
		this.rightAccel = rightAccel;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
