package 随笔测试.day03;

import java.util.Arrays;

public class 数组的中位数 {
	/**
	 * 中位数的概念：对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。
	 * 		如果观察值有偶数个，通常取最中间的两个数值的平均数作为中位数。
	 */


	public static int findMidNum(int[] array) {
		if (array == null || array.length <= 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
//		int mid = array.length >> 1;
		int mid = (start + end) / 2;
		int index = partition(array, start, end);
		while (index != mid) {
			if (index > mid) {
				end = index - 1;
				index = partition(array, start, end);
			}else if (index < mid) {
				start = index + 1;
				index = partition(array, start, end);
			}
		}
		return array[index];  //返回值需要判断数组元素总数的奇偶性
	}
	
	public static int partition(int[] array, int start, int end) {
		int key = array[start];
		while (start < end) {
			while (start < end && array[end] >= key) {
				end--;
			}
			array[start] = array[end];
			while (start < end && array[start] <= key) {
				start++;
			}
			array[end] = array[start];
		}
		array[end] = key;
		return end;
	}
	
	public static void main(String[] args) {
		int[] array = {6,3,7,1,8,9,4,2,10,-1};  //
//		int[] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(findMidNum(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
