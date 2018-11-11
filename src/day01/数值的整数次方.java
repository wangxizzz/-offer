package day01;
/**
 * 面试16
 */
public class 数值的整数次方 {
	
	public static double pow(double base, int exp) throws Exception {
		double result = 0;
		//排除基数为0，并且exp为负数的情况  pow(0,0)=1
		if (equal(base,0.0) && exp < 0) {
			throw new Exception("0的负次幂无意义！");
		}
		
		if (exp >= 0) {
			result = powerWithExponent(base, exp);
		} else {
			result = 1.0/powerWithExponent(base, exp);
		}
		return result;
	}
	private static double powerWithExponent(double base, int exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}
		double result = 1.0;
		for (int i = 0; i < Math.abs(exp); i++) {
			result = result * base;
		}
		return result;
	}
	private static boolean equal(double num1, double num2) {
		if (num1-num2 > -0.0000001 && num1 - num2 < 0.0000001) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(pow(2, -2));
	}
}
