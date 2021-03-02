package leecode.array.二分查找问题;

/**
 * @author wangxi created on 2021/3/1 23:36
 * @version v1.0
 */
public class MySqrt {

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(Integer.MAX_VALUE);
        int i = mySqrt.mySqrt(2147395599);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            //二分查找
            int mid = l + (r - l) / 2;
            //这里要防止溢出
            long cur = x / mid;
            if (cur == mid) {
                return mid;
            } else if (cur > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 去l还是r,拿 8举例子
        return r;
    }
}
