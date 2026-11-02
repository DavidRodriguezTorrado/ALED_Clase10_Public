package executors;

public class HebraCalculo extends Thread {
	
	private int lo;
	private int hi;
	private int res;
	
	public HebraCalculo(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}
	
	@Override
	public void run() {
		// res = CalculoSecuencial.calculo(lo, hi);
		res = 0;
		
		for (int i = lo; i < hi; i++) {
			res += i * i;
		}
	}
	
	public int getRes() {
		return res;
	}
}
