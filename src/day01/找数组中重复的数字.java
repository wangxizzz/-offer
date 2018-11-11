package day01;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 面试题3 注意本题的限制条件：数组的元素是0 ~ n-1，第二种解法就是基于此的
 */
public class 找数组中重复的数字 {
	//采用hash查找，时间复杂度为O(n)，hashCode查找是O(1)。空间复杂度是O(n)的哈希表
	public static void findDuplicateElementI(int[] numbers) {
		if (numbers.length < 0) {
			return;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0) {
				return ;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsValue(numbers[i])) {
				System.out.println(numbers[i]);
			}else {
				map.put(i, numbers[i]);
			}
		}
	}
	//把每个元素放在数组对应的位置上。此方法是基于前提条件
	//时间O(n),空间O(1)，此方法充分利用数组索引的唯一性
	public static void findDuplicateElementII(int[] numbers) {
		if (numbers.length < 0) {
			return;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0) {
				return ;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			//错误代码：一定是i位置一定是number[i]
//			if (numbers[i] != i) {
//				if (numbers[i] == numbers[numbers[i]]) {
//					//说明有重复元素
//					System.out.println(numbers[i]);
//				} 
//				else {
//					int temp = numbers[i];
////					numbers[i] = numbers[numbers[i]];
//				//注意：下面的numbers[i]已经发生改变了
////					numbers[numbers[i]] = temp;
//				
//				numbers[i] = numbers[temp];
//				numbers[temp] = temp;
//				}
//				
//			}
			
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					//说明有重复元素
					System.out.println(numbers[i]);
					break;
				} 
				int temp = numbers[i];
//				numbers[i] = numbers[numbers[i]];
				//注意：下面的numbers[i]已经发生改变了
//					numbers[numbers[i]] = temp;
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] numbers = {2,3,1,0,2,5,3,5,0};
//		findDuplicateElementI(numbers);
		findDuplicateElementII(numbers);
	}
}
