package 随笔测试.day03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo implements Runnable{
	Semaphore semp = new Semaphore(5);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			semp.acquire();
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getId() + "done");
			semp.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
		ExecutorService pool =  new ThreadPoolExecutor(20, 20, 1000, TimeUnit.MILLISECONDS, workQueue);
		SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			pool.submit(semaphoreDemo);
		}
		pool.shutdown();
	}
}
