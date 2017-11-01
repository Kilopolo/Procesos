package com.gmail.pablo23dr.applet;

import java.awt.*;

public class Player {
	private int x=200;
	private int y=200;
	private int radius=20;
	
	public void update(MiApplet mc) {
		
		x+=5;
		
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, radius*2, radius*2);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, radius*2, radius*2);
	}
}
