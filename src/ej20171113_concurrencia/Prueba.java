package ej20171113_concurrencia;


public class Prueba {

	private static Contador c = new Contador(100);
	
	public static void main(String[] args) {
		//hilo 1
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i=0; i<100; i++) {
					//hasta que no acabe uno no acaba otro
					//
					synchronized (c) {
						c.incrementar();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};

		//hilo 2
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i=0; i<100; i++){
					synchronized (c) {
						c.decrementar();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Contador: " + c.getValor());
		
	}

}
