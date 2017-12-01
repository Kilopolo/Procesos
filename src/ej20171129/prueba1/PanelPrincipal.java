package ej20171129.prueba1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelPrincipal extends JFrame implements Runnable {

	private final int HEIGHT = 600;
	private final int WIDTH = (HEIGHT * 16) / 9;
	private JPanel grafica;
	private boolean running = false;
	private Graphics gfx;
	private Image img;
	private Ball ball;
	
	public static void main(String[] args) {
		new PanelPrincipal();
	}

	public PanelPrincipal() {
		// JFRAME
		setTitle("Pelotas que Rebotan");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		getContentPane().setLayout(new FlowLayout());

		// GRAFICA
		grafica = new JPanel();
		grafica.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		grafica.setBackground(Color.BLACK);
		add(grafica);
		
		//OTROS
		this.addKeyListener(new KeyInput());
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		start();
	}
	public void start() {
		
	}
	public void stop() {
		
	}
	
	public void move() {
		
		
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics gfx = bs.getDrawGraphics();

		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		// ----------------------------------------------
		
	
		
		
		// ----------------------------------------------
		gfx.dispose();
		bs.show();

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 1.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				move();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS" + frames);
				frames = 0;
			}
		}
		stop();

	}

	
}
