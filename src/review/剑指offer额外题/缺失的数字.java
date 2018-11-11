package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description : P266
 * @Date: 2018/8/10 0010 13:36
 */
public class 缺失的数字 {

    public static int missingNumber(int[] num, int length){
        if (num == null || num.length < 2) {
            return 0;
        }
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == mid) {
                start = mid + 1;
            }else {
                if (mid == 0 || num[mid - 1] == mid - 1) {
                    return num[mid] - 1;
                }else{
                    end = mid - 1;
                }
            }

        }
        if (start == length - 1) {
            return length - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {0,1,2,3,4,6,7,8};
        System.out.println(missingNumber(num, 9));
        int[] num1 = {1,2,3,4,5,6,7,8};
        System.out.println(missingNumber(num1, 9));
        int[] num2 = {0,1,2,3,4,5,6,7};
        System.out.println(missingNumber(num2, 9));
    }
}
