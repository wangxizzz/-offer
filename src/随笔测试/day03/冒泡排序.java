package 随笔测试.day03;

import java.util.Arrays;

public class 冒泡排序 {
	//冒泡排序
	public static void sort(int[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		int n = array.length;
		for (int i = 1; i < n; i++) {   //一共n-1次冒泡
			for (int j = 1; j <= n - i; j++) {  //每次冒n-i次
				if (array[j] < array[j - 1]) {  //小到大进行排序
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int[] num = {3,1,2,5,9,6,7,0};
		sort(num);
	}
}
