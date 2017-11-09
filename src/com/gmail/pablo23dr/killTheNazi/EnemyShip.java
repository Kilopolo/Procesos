package com.gmail.pablo23dr.killTheNazi;

import java.awt.Color;
import java.awt.Graphics;

public class EnemyShip {
	double x, velX;
	boolean leftAccel, rightAccel;
	int y, proportion;
	final double GRAVITY = 0.40;

	public EnemyShip() {

		leftAccel = false;
		rightAccel = false;

		x = 300;
		y = 10;
		proportion = 4;

		velX = 0;

	}

	public void move() {

		// for (int i = 300; i < 600; i++) {
		// if (i%2==0) {
		// x=i;
		// }
		// }
		// for (int i = 600; i > 0 ; i--) {
		// if (i%2==0) {
		// x=i;
		// }
		// }
		// for (int i = 0; i < 600; i++) {
		// if (i%2==0) {
		// x=i;
		// }
		// }
		//

	}

	/**
	 * 
	 * @param g
	 */
	public void draw2(Graphics g) {
		/**
		 * estrella= x,y 1=1.1 2=1.2 3=3.2 4=3.3 5=1.3 6=1.6 7=2.6 8=2.4 9=3.4 10=3.6
		 * 11=6.6 12=6.5 13=4.5 14=4.4 15=6.4 16=6.1 17=5.1 18=5.3 19=4.3 20=4.1 21=1.1
		 * 
		 */

		int xStarPoints[] = { 1, 1, 3, 3, 1, 1, 2, 2, 3, 3, 6, 6, 4, 4, 6, 6, 5, 5, 4, 4, 1 };
		int yStarPoints[] = { 1, 2, 2, 3, 3, 6, 6, 4, 4, 6, 6, 5, 5, 4, 4, 1, 1, 3, 3, 1, 1 };
		int nStarPoints = 21;
		int xStarProPoints[] = new int[nStarPoints];
		int yStarProPoints[] = new int[nStarPoints];

		for (int i = 0; i < yStarProPoints.length; i++) {
			xStarProPoints[i] = (int) (getX() + (xStarPoints[i] * getProportion()));
			yStarProPoints[i] = (int) (getY() + (yStarPoints[i] * getProportion()));
		}

		g.setColor(Color.CYAN);
		g.fillPolygon(xStarProPoints, yStarProPoints, nStarPoints);

	}

	public void draw1(Graphics g) {
		/**
		 * alas = x,y 0 = 0,0 1 = 0,1 2 = 1,1 3 = 1,3 4 = 2.3 5 = 2.1 6 =3.1 7 = 3.2 8 =
		 * 4.2 9 = 4.3 10=5.3 11=5.2 12=6.2 13=6.1 14=7.1 15=7.3 16=8.3 17=8.1 18=9.1
		 * 19=9.0 20=0.0
		 * 
		 * cabina =x,y 0 =2.0 1 =2.2 2 =3.2 3 =3.4 4 =4.4 5 =4.6 6 =5.6 7 =5.4 8 =6.4 9
		 * =6.2 10=7.2 11=7.0 12=2.0
		 * 
		 */
		int xAlasPoints[] = { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0 };
		int yAlasPoints[] = { 0, 1, 1, 3, 3, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 3, 3, 1, 1, 0, 0 };
		int nAlasPoints = 21;
		int xAlasProPoints[] = new int[nAlasPoints];
		int yAlasProPoints[] = new int[nAlasPoints];

		for (int i = 0; i < yAlasPoints.length; i++) {
			xAlasProPoints[i] = (int) (getX() + (xAlasPoints[i] * getProportion()));
			yAlasProPoints[i] = (int) (getY() + (yAlasPoints[i] * getProportion()));

		}

		int xCabinaPoints[] = { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 2 };
		int yCabinaPoints[] = { 0, 2, 2, 4, 4, 6, 6, 4, 4, 2, 2, 0, 0 };
		int nCabinaPoints = 13;
		int yCabinaProPoints[] = new int[nCabinaPoints];
		int xCabinaProPoints[] = new int[nCabinaPoints];

		for (int i = 0; i < yCabinaPoints.length; i++) {
			xCabinaProPoints[i] = (int) (getX() + (xCabinaPoints[i] * getProportion()));
			yCabinaProPoints[i] = (int) (getY() + (yCabinaPoints[i] * getProportion()));
		}

		g.setColor(Color.CYAN);
		g.fillPolygon(xCabinaProPoints, yCabinaProPoints, nCabinaPoints);
		g.setColor(Color.RED);
		g.fillPolygon(xAlasProPoints, yAlasProPoints, nAlasPoints);
		g.setColor(Color.YELLOW);
		g.fillRect((int) getX() + (getProportion() * 4), getY() - getProportion(), getProportion(), getProportion());

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
