package day03.part2;

/**
 * @Author: wangxi
 * @Description : 0~n-1中缺失的数字。注意：数组是排序的
 * @Date: 2018/7/6 0006 21:48
 */
public class P53_2MissingNumber {
    /**
     * 找出数组中缺失的数字 ， 时间O(longn),若没有缺失的数字，下标和数字相等
     * @param num
     * @return
     */
    public static int getMissingNumber(int[] num) {
        if (num == null || num.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (num[mid] == mid) {
                start = mid + 1;
            }else {
                if ((mid > 0) && (num[mid - 1] == mid - 1) || mid == 0) {
                    return mid;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] num = {0,1,2,3,5};
        System.out.println(getMissingNumber(num));
    }
}
