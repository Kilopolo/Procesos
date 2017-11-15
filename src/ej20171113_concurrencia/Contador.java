package ej20171113_concurrencia;

public class Contador {
	private int valor;

	/**
	 * todos los objetos en java tienen un cerrojo. Los hilos cuando entran en ese
	 * objeto sincronizado se apoderan de ese cerrojo de ese objeto sincronizado es
	 * decir que cuando uno entra coje el cerrojo, y cuando entra el otro ya esta
	 * cojido ese cerrojo y no puede entrar hasta que esta libre ese cerrojo.
	 * OJO! a nivel de objeto no de clase!
	 * @param valor
	 */
	public Contador(int valor) {
		this.valor = valor;
	}

	public void incrementar() {
		valor++;
	}

	public void decrementar() {
		valor--;
	}

	public int getValor() {
		return valor;
	}
}
