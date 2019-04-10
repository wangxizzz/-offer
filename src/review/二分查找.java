package review;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/14 0014 23:02
 */
public class 二分查找 {
    //相对于排序数组
    public static void f1(int[] num, int val) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // 最开始判断是否相等。
            if (val == num[mid]) {
                System.out.println("找到了");
                break;
            } else if (val < num[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
