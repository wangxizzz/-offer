package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description :P267
 * @Date: 2018/8/10 0010 13:36
 */
public class 数组下标与数值相等元素 {

    public static int findNum(int[] num){
        if (num == null || num.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == mid) {
                return mid;
            }else if (num[mid] > mid){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {-1,-2,1,3,8,9};
        System.out.println(findNum(num));
    }
}
