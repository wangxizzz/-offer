package day01;
/**
 * 面试15
 */
public class 二进制中1的个数 {
	
	public static void f1(int n) {
		int count = 0;
		while (n != 0) {
			//把n的最右边的1变为0
			n = (n - 1) &n;
			count++;
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {

		f1(0);
	}
}
