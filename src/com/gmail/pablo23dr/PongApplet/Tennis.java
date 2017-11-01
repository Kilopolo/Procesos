package com.gmail.pablo23dr.PongApplet;

import java.applet.*;
import java.awt.*;


public class Tennis extends Applet implements Runnable, KeyListener{
	
	final int WITDH = 700, HEIGHT = 500;
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WITDH, HEIGHT);
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {

		for(;;) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
