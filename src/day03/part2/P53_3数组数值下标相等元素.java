package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/6 0006 22:09
 */
public class P53_3数组数值下标相等元素 {

    public static int getNum(int[] num) {
        if (num == null || num.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == mid) {
                return num[mid];
            }
            else if (num[mid] > mid) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {-3,-1,1,3,5};
        System.out.println(getNum(num));
    }
}
