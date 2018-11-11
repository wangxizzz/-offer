package 常见的排序算法实现.day01;


/**  
 * 
 * 不知道大家在生活中是如何思考排序这件事情的，
 * 就我来说，在打扑克牌（十三张那种哈）的时候，每拿到派发的一张牌，
 *  就会将这张牌插入到合适的位置，这样每次插完之后就是得到了一次排好序的牌。

插入排序就是用了这种思想，先给定一个排好序的序列（通常设定为给定要排序序列的第一个值），
然后陆续将后面的值与前面排好序的比较，如果是小于前面的值，
就插到前面去。就这样一直比较，然后最后总会插入到合适的位置，当然啦，
如果是插入到第一位了，也算完成了插入。
 * @ClassName: 插入排序  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月13日 下午10:33:12
 * 时间复杂度： O(n*n)  
*/   
public class 插入排序 {
	
	public static void f1(int[] array) {
		int temp = 0;
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			//从小到大进行排序
			for (j = i; j > 0 && array[j-1] > temp; j--) {
				array[j] = array[j-1];
			}
			array[j] = temp;
		}
	}
	public static void main(String[] args) {
		int[] array = {1,7,6,0,3,4};
		f1(array);
		for (int i : array) {
			System.out.print(i+ "  ");
		}
	}
}
