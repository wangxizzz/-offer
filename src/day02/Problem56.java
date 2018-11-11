package day02;
/**
 * 数组中只出现一次的数字有2个（不能超过2个，否则结果会被异或覆盖），其他数字都出现2次
 * @author admin
 *
 */
public class Problem56 {
	
	public static void findNumsAppearOnce(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return;
		}
		int result1 = 0;
		int result2 = 0;
		int resultExclusiveOr = 0;
		for (int i = 0; i < nums.length; i++) {
			//相同两个数的异或运算=0
			resultExclusiveOr ^= nums[i];
		}
		int indexOf1 = findFirstBits1(resultExclusiveOr);
		System.out.println(indexOf1);
		//把数组的数字分为两组
		for (int i = 0; i < nums.length; i++) {
			if (isBit1(nums[i], indexOf1)) {
				result1 ^= nums[i];
			}else {
				result2 ^= nums[i];
			}
		}
		System.out.println(result1);
		System.out.println(result2);
	}
	//找到最右边的1
	private static int findFirstBits1(int val) {
		int index = 0;
		while (((val & 1) == 0) && index < 32) {
			index++;
			val = val >> 1;
		}
		return index;
	}
	//判断第index位是否为1
	private static boolean isBit1(int val, int index) {
		int result = val >> index;
		return (result & 1) == 1;
	}
	
	public static void main(String[] args) {
//		int a = 10;
//		System.out.println(a);
//		System.out.println(a & 1);
//		a = a >> 1;
//		System.out.println(a & 1);
		int[] nums = {2,4,3,6,3,2,5,5};
		findNumsAppearOnce(nums);
	}
}
