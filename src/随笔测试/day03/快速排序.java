package 随笔测试.day03;

import java.util.Arrays;

public class 快速排序 {
	
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
	
	public static void sort(int[] array, int start, int end) {
		if (start > end || array == null) {    //在这里递归结束并且判断数组非空
			return;
		}
		int index = partition(array, start, end);
		sort(array, start, index - 1);
		sort(array, index + 1, end);
	}
	
	public static void main(String[] args) {
		int[] array = {6,5,4,3,2,1};
		sort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
