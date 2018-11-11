package day01;
/**
 * 面试5
 */
public class 替换空格 {
	//根据空格的数量计算出替换后的长度，然后复制
	public static void replaceBlank(String s) {
		if (s == null || "".equals(s)) {
			return;
		}
		int length = s.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		char[] array = new char[length + 2*count];
		for (int i = 0; i < length; i++) {
			array[i] = s.charAt(i);
		}
		int p = array.length - 1; //数组新长度
		int q = length - 1;		  //原来的长度	
		while (p >= 0 && p > q) {
			if (array[q] != ' ') {
				array[p] = array[q];
			} else {
				array[p] = '0';
				p = p-1;
				array[p] = '2';
				p = p-1;
				array[p] = '%';
			}
			q--;
			p--;
		}
		
		for (char c : array) {
			System.out.print(c);
		}
		
	}
	
	public static void main(String[] args) {

		replaceBlank("we are happy!");
	}
}
