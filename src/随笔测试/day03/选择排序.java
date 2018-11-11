package 随笔测试.day03;

import java.util.Arrays;

public class 选择排序 {
	//时间O(n*n)
	public static void sort(int[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int min = array[i];
			int index = i;     //注意：index初始化为i，防止下面的if判断可能没有进去
			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			array[i] = array[index];
			array[index] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int[] array = {6,5,4,3,2,1};
		sort(array);
	}
}
