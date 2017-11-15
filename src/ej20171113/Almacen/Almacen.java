package ej20171113.Almacen;

public class Almacen {

	// 0x10 es 16 en hexadecimal
	private int[] productos = new int[0x10];

	private int primero = 0;
	private int stock = 0;

	public synchronized void agregar(int producto) {
		
		if (stock == productos.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		while (stock == productos.length);
		// -------------------------------------------------
		// int posicion = primero + stock;
		// if(posicion >= productos.length) {
		// posicion -= productos.length;
		// }
		// productos[posicion] = producto;
		// stock++;
		// -------------------------------------------------

		// esto tb se puede sustituir por lo de arriba
		// esto funciona porque el array tiene el tamaño que tiene.
		productos[primero + stock++ & 0xf] = producto;
		notifyAll();
	}

	public synchronized int retirar() {

		if (stock ==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		while (stock == 0);
		int producto = productos[primero];
		// -------------------------------------------------
		// if (++primero == productos.length) {
		// primero = 0;
		// }
		// stock--;
		// -------------------------------------------------

		// esto tb se puede sustituir por lo de arriba
		primero = primero + 1 & 0xf;
		stock--;
		notifyAll();
		return producto;
	}
}
