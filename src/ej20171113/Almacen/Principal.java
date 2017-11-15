package ej20171113.Almacen;

public class Principal {
	public static void main(String[] args) {
		
		Almacen almacen = new Almacen();
		Productor productor = new Productor(almacen, 1000);
		Consumidor consumidor = new Consumidor(almacen, 1600);
		productor.start();
		consumidor.start();
		
		while (true) {
			try {
				productor.join();
				consumidor.join();
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
