package 随笔测试.day03;

public class 旋转数组最小值 {
	
	public static int findMinNum(int[] array) {
		if (array == null || array.length <= 0) {
			return -1;
		}
		int length = array.length;
		int start = 0;
		int end = length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (end - start == 1) {
				return array[end];
			}
			if (array[mid] >= array[start]) {
				start = mid;
			}else if (array[mid] <= array[end]) {
				end = mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,5,6,0,1,2};
		System.out.println(findMinNum(array));
	}
}
