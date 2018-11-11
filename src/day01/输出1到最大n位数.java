package day01;
/**
 * 面试17:注意技巧
 */
public class 输出1到最大n位数 {
	//需要考虑n很大的情况
	public void toMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('0');
		}
		//默认返回的是false，没有溢出
		while (!increment(sb)) {
			printNumber(sb);
		}
		sb = null;
	}
	private void printNumber(StringBuilder sb) {
		//设置标志位
		boolean isBeginning0 = true;
		int n = sb.length();
		//输出一个数字
		for (int i = 0; i < n; i++) {
			if (isBeginning0 && sb.charAt(i) != '0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(sb.charAt(i));
			}
		}
		System.out.println();
	}

	private boolean increment(StringBuilder sb) {
		boolean isOverFlow = false;
		int carray = 0;
		int n = sb.length();
		for (int i = n - 1; i >= 0; i--) {
			int sum = sb.charAt(i) - '0' + carray;
			if (i == n - 1) {
				sum++;
			}
			if (sum >= 10) {
				if (i == 0) {
					isOverFlow = true;
				} else {
					sum = sum - 10;
					carray = 1;
					//把9置为0
					sb.setCharAt(i, (char)(sum + '0'));
				}
			}else {
				sb.setCharAt(i, (char)(sum + '0'));
				break;
			}
		}
		return isOverFlow;
	}
	//测试ascII码
	public static int ascII(char c) {
		return c;
	}
	public static void main(String[] args) {
		System.out.println(ascII('0')); //48
		System.out.println(ascII('1'));	//49
		System.out.println(ascII('a'));	//97
		System.out.println(ascII('A'));	//65
		int sum = 1;
		System.out.println(sum + '1');  //把sum变为ascII，再相加'49+1'
		
		输出1到最大n位数 s = new 输出1到最大n位数();
		s.toMaxOfNDigits(2);
	}
}
