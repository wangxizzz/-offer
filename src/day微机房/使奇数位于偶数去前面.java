package day微机房;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/11 0011 11:04
 */
public class 使奇数位于偶数去前面 {
    public static void reOrderOddEvent(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i]%2 != 0) {
                //在这里i的值发生改变，因此在这层的while循环要加i<j的条件
                i++;
            }
            while (i < j && nums[j]%2 == 0) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        reOrderOddEvent(nums);
        for (int i : nums) {
            System.out.print(i + "     ");
        }
    }
}
