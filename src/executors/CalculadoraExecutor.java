package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculadoraExecutor {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {		
		TareaExecutor t1 = new TareaExecutor(4, 5);
		TareaExecutor t2 = new TareaExecutor(5, 7);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Future<Integer> futuro1 = executor.submit(t1);
		Future<Integer> futuro2 = executor.submit(t2);
		
		Integer res1 = futuro1.get(); // Espera a que acabe la tarea
		Integer res2 = futuro2.get();
		
		System.out.println(res1 + res2);
		
		executor.shutdown();
		
	}
}
