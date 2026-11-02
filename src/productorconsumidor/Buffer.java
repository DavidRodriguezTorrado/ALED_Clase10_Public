package productorconsumidor;

public class Buffer {
	
	private int dato = -1;
	private boolean lleno = false;
	
	// Hebra Productora -> P
	public synchronized void guardar(int dato) {
		while (lleno) {
			// Dormir / parar
			try {
				wait(); // El wait libera el cerrojo
			} catch (InterruptedException e) {
				return;
			}
		}	
		this.dato = dato;
		this.lleno = true;
		System.out.println("Guardado valor: " + dato);
		notifyAll(); // Despierta a una hebra, pero no se cuál
	}
	
	// Hebra Consumidora -> C
	public synchronized int sacar() {
		while (!lleno) {
			// Dormir / parar
			try {
				wait(); // El wait libera el cerrojo
			} catch (InterruptedException e) {
				return -1;
			}
		}
		this.lleno = false;
		System.out.println("Sacado valor: " + dato);
		notifyAll();
		return dato;
	}
	
}
