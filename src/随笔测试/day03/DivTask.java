package 随笔测试.day03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class DivTask implements Runnable{
	int a, b;
	public DivTask(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double result = a / b;
		System.out.println(result);
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService  pool = Executors.newCachedThreadPool();
//		for (int i = 0; i < 5; i++) {         //异常被吃了
//			pool.submit(new DivTask(100, i));
//		}
		System.out.println("================================================");
		for (int i = 0; i < 5; i++) {
			pool.execute(new DivTask(100, i));
		}
		pool.shutdown();
		System.out.println("===================================================");
		for (int i = 0; i < 5; i++) {
			Future<?> future = pool.submit(new DivTask(100, i));
			future.get();
		}
	}
}
