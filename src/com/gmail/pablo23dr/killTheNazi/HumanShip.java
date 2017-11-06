package com.gmail.pablo23dr.killTheNazi;

import java.awt.Color;
import java.awt.Graphics;

public class HumanShip {

	double x, velX;
	boolean leftAccel, rightAccel;
	int y, proportion;
	final double GRAVITY = 0.40;

	public HumanShip() {

		leftAccel= false;
		rightAccel = false;
		
		x = 300;
		y = 590;
		proportion = 4;
		
		velX=0;
		
		
	}

	public void move() {
		if (leftAccel) {
			velX -=2;
		}else if (rightAccel) {
			velX +=2;
		}else if (!leftAccel && !rightAccel) {
			velX*=GRAVITY;
		}
		
		if (velX>=20) {
			velX=20;
		}else if (velX<=-20) {
			velX=-20;
		}
		
		x += velX;
		
		if (x<-40) {
			x=600;
		}else if(x>600) {
			x=-40;
		}
		
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
		int yCabinaProPoints[]= new int [nCabinaPoints];
		int xCabinaProPoints[]= new int [nCabinaPoints];
		
		for (int i = 0; i < yCabinaPoints.length; i++) {
			xCabinaProPoints[i]=(int) (getX()+(xCabinaPoints[i]*getProportion()));
			yCabinaProPoints[i]=(int) (getY()+(yCabinaPoints[i]*getProportion())*-1);
		}
		
		g.setColor(Color.CYAN);
		g.fillPolygon(xCabinaProPoints, yCabinaProPoints, nCabinaPoints);
		g.setColor(Color.RED);
		g.fillPolygon(xAlasProPoints, yAlasProPoints, nAlasPoints);
		g.setColor(Color.YELLOW);
		g.fillRect((int)getX()+(getProportion()*4), getY()-getProportion(), getProportion(), getProportion());
		//g.fillOval((int)getX()+(getProportion()*4), getY()-getProportion()+5, getProportion()+4, getProportion()*4);

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
		return velX;
	}

	public void setDirX(double dirX) {
		this.velX = dirX;
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
