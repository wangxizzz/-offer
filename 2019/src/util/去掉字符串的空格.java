package util;

import java.util.Scanner;

/**  
 * @ClassName: 去掉字符串的空格  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月20日 下午10:45:06  
*/
public class 去掉字符串的空格 {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入字符串：");
		String string = scanner.nextLine();
		System.out.println(string.replaceAll(" ", ""));
	}
}
