package productorconsumidor;

public class EjemploProductorConsumidor {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		
		Thread p = new SensorProductor(b);
		Thread c = new SensorConsumidor(b);
		
		p.start();
		c.start();
	}
	
}
