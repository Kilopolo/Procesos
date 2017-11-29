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

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelPrincipal extends JFrame implements Runnable, KeyListener {

	private final int HEIGHT = 600;
	private final int WIDTH = (HEIGHT * 16) / 9;
	private JPanel grafica;
	private boolean running = false;
	private Graphics gfx;
	private Image img;
	
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
		this.addKeyListener(this);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		start();
	}
	public void start() {
		
	}
	public void stop() {
		
	}
	
	public void movimiento() {
		
		
		
	}
	
	public void pintar(Graphics g) {
		
		
		
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
				movimiento();
				delta--;
			}
			if (running) {
				pintar();
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

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
