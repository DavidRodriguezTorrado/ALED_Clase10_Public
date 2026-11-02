package executors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculadoraExecutorAvanzado {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {		
		int start = 0;
		int end = 103;
		int tareaSize = 20;
		
		List<TareaExecutor> tareas = new ArrayList<>();
		
		for (int i = start; i <= end; i+= tareaSize) {
			if (i + tareaSize <= end) {
				TareaExecutor t = new TareaExecutor(i, i + tareaSize);
				tareas.add(t);
			} else {
				TareaExecutor t = new TareaExecutor(i, end);
				tareas.add(t);
			}
			
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		List<Future<Integer>> futuros = new ArrayList<>();
		
		for (TareaExecutor t: tareas) {
			futuros.add(executor.submit(t));
		}
		
		int res = 0;
		
		for (Future<Integer> f: futuros) {
			res += f.get();
		}
		
		System.out.println(res);
		
		executor.shutdown();
		
	}
}
