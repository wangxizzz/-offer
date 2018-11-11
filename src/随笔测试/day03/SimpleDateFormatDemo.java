package 随笔测试.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
	/**
	 * 把Date类型的时间或者以long型表示的时间格式化为自定义的字符串
	 */
	public static void formatTime() {
		SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        SimpleDateFormat bDate=new SimpleDateFormat("yyyy-mmmmmm-dddddd");
//        long now=System.currentTimeMillis();
        Date now = new Date();
        System.out.println(aDate.format(now));   //format()方法返回的是字符串类型
        System.out.println(bDate.format(now));
        
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat myFmt4=new SimpleDateFormat("一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        System.out.println(myFmt.format(now));
        System.out.println(myFmt1.format(now));
        System.out.println(myFmt2.format(now));
        System.out.println(myFmt3.format(now));
        System.out.println(myFmt4.format(now));
	}
	/**
	 * 把字符串解析为Date类型的时间或者是long表示的时间类型
	 */
	public static void parseTime(String strTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0L;
        try {
            time = format.parse(strTime).getTime();
            Date date = format.parse(strTime);
            System.out.println(time);
            System.out.println(date);
            //解析完成后又可以格式化自己想要的字符串
            System.out.println(format.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

    
	
	public static void main(String[] args) {
		formatTime();
		System.out.println("======================================================");
		System.out.println("分割线下面为解析时间：");
		System.out.println("======================================================");
		String aString="2017-11-12";
        parseTime(aString);
	}
}
