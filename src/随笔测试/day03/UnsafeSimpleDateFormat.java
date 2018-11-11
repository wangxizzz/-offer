package 随笔测试.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 参考网址：https://www.cnblogs.com/zemliu/archive/2013/08/29/3290585.html
 * @author Administrator
 *
 */
public class UnsafeSimpleDateFormat implements Runnable{
	private int i;
	public UnsafeSimpleDateFormat(int i) {
		this.i = i;
	}
	//一定需要设置为static类型，可以线程之间共享。如果不加static，则是每个UnsafeSimpleDateFormat独占一个，这样不存在线程问题。
	public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public void run() {
		try {
			Date date = format.parse("2018-07-09 16:30:" + i % 60);
			System.out.println(i + ":" + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			e.execute(new UnsafeSimpleDateFormat(i));
		}
		e.shutdown();
	}
}
