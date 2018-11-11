package day02;

/**
 * @Author:王喜
 * @Description :面试39
 * @Date: 2018/4/15 0015 22:44
 */
public class 超过数组长度一半数字 {

    public static Integer moreThanHalfNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (result == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        int time = 0;
        //防止根本没有这个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                time++;
            }
        }
        if (time * 2 > nums.length) {
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,5,4,2,3};
        System.out.println(moreThanHalfNumber(nums));
    }
}
