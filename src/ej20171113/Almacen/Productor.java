package ej20171113.Almacen;

import java.util.Random;

public class Productor extends Thread {

	private Random r = new Random();
	private Almacen almacen;
	private long retardo;

	public Productor(Almacen almacen, long retardo) {
		this.almacen = almacen;
		this.retardo = retardo;
	}

	@Override
	public void run() {
		while (true) {
			int producto = r.nextInt(9000) + 10000;
			almacen.agregar(producto);
			System.out.println("Agregado: "+producto);
			try {
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
