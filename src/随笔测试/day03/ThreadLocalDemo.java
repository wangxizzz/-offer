package 随笔测试.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 线程安全的SimpleDateFormat的使用
 * @author Administrator
 *
 */
public class ThreadLocalDemo implements Runnable{
	private int i = 0;
	public ThreadLocalDemo(int i) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}
	public static final ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>(); 
	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			if (t1.get() == null) {
				t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			}
			//直接解析字符串为时间，返回Date类型
			Date time = t1.get().parse("2018-07-09 18:30:" + i % 60);
			//先解析为long类型的时间表示法，然后再进行格式化为字符串
			long time1 = t1.get().parse("2018-07-09 18:30:" + i % 60).getTime();
			String time2 = t1.get().format(time1);
			System.out.println(i + ":" + time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExecutorService eService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 20; i++) {
			eService.execute(new ThreadLocalDemo(i));
		}
		eService.shutdown();
	}
}
