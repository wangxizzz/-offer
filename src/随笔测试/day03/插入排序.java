package 随笔测试.day03;

import java.util.Arrays;

public class 插入排序 {
	//时间O(n*n)
	public static void sort(int[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		int length = array.length;
		//默认第一个数数字已经排好序了
		for (int i = 1; i < length; i++) {
			int temp = array[i];
			int j = i - 1;   //如果在i之前有位置插入的话，在i之前找位置插入该数字。
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int[] array = {7,6,5,4,3,2,1};
		sort(array);
	}
}
