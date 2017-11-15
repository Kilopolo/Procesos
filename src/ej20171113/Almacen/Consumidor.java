package ej20171113.Almacen;

import java.util.Random;

public class Consumidor extends Thread {

	private Almacen almacen;
	private long retardo;

	public Consumidor(Almacen almacen, long retardo) {
		this.almacen = almacen;
		this.retardo = retardo;
	}

	@Override
	public void run() {
		while (true) {
			int producto = almacen.retirar();
			System.out.println("Retirado: " + producto);
			try {
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}