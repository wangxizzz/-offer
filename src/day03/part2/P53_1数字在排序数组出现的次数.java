package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/6 0006 21:11
 */
public class P53_1数字在排序数组出现的次数 {
    /**
     * 因为是排序数组，先二分查找找到第一个k,再找到最后一个k，下标相减。
     *  时间O(longn)
     * @param k
     * @return
     */
    public static int getNumOfK(int[] num, int k) {
        if (num == null || num.length <= 0) {
            return -1;
        }
        int firstK = getFirstK(num, k);
        int lastK = getLastK(num, k);
        if (firstK == -1 || lastK == -1) {
            return -1;
        }
        return (lastK - firstK + 1);
    }

    private static int getFirstK(int[] num, int k) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] > k) {
                end = mid - 1;
            }else if (num[mid] < k) {
                start = mid + 1;
            }else {   //如果找到了k，判断k前面是否为k，若不是，即为第一个k
                if ((mid > 0) && (num[mid - 1] != k) || mid == 0) {
                    return mid;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;  //没找到
    }

    private static int getLastK(int[] num, int k) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] > k) {
                end = mid - 1;
            }else if (num[mid] < k) {
                start = mid + 1;
            }else {   //如果找到了k，判断k前面是否为k，若不是，即为第一个k
                if ((mid < num.length - 1) && (num[mid + 1] != k) || (mid == num.length - 1)) {
                    return mid;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;  //没找到
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,3,3,3,3,4,4,5};
        System.out.println(getNumOfK(num, 4));
    }
}
