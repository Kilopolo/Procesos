package ej20171129.prueba1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);

	}

}
