package 常见的排序算法实现.day01;


/**  
 * 原理：每一趟从待排序的记录中选出最小的元素，
 * 顺序放在已排好序的序列最后，直到全部记录排序完毕。
 * 
 *  简单选择排序的基本思想：给定数组：int[] arr={里面n个数据}；
 *  第1趟排序，在待排序数据arr[1]~arr[n]中选出最小的数据，
 *  将它与arrr[1]交换；第2趟，在待排序数据arr[2]~arr[n]中选出最小的数据，
 *  将它与r[2]交换；以此类推，第i趟在待排序数据arr[i]~arr[n]中选出最小的数据，
 *  将它与r[i]交换，直到全部排序完成。
 * @ClassName: 选择排序  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月13日 下午10:28:40  
 * 	O(n) = n*n; 
*/
public class 选择排序 {
	
	public static void f1(int[] array) {
		//健壮性
		if (array == null || array.length <= 0) {
			return;
		}
		int min = 0;
		int l = 0; 
		for (int i = 0; i < array.length; i++) {
			min = array[i];
			//l代表每次遍历最小元素的下标，注意，每次下标的初值应与每次遍历的头元素下标相等。
			// l = 0;  这是错误的。
			l = i;
			//找出i到尾的最小元素
			for (int j = i; j < array.length; j++) {
				if (min > array[j]) {
					min = array[j];
					l = j;
				}
			}
			array[l] = array[i];
			array[i] = min;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {6,3,7,2,4,1};
		f1(array);
		for (int i : array) {
			System.out.print(i+ "  ");
		}
	}
}
