package day03.part1;

/**
 * @Author:王喜
 * @Description : 不能改变数组元素的位置与地址的指向,长度n+1数组里的数字都在1~n范围内
 * @Date: 2018/5/20 0020 10:55
 */
public class P3_2 {

    /**
     * 时间O(nlogn)，空间O(1)，以时间换空间
     * 注意：这种方法无法找到所有重复的数字
     * @param num
     */
    public static void getDuplicate1(int[] num) {
        if (num == null || num.length <= 0) {
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 1 || num[i] > num.length - 1) {
                System.out.println("输入数据不合法");
                return;
            }
        }
        int start = 1;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int count = countRange(num, start, mid);
            if (count > (mid - start + 1)) {
                end = mid;
            }else {
                start = mid + 1;
            }
            if (start == end) {  //指向同一个数，在二分查找中说明找到这个数
                if (count > 1) {
                    System.out.println(start);
                    break;
                }
            }
        }
    }
    private static int countRange(int[] num, int start, int end) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= start && num[i] <= end) {
                count++;
            }
        }
        return count;
    }

    /**
     * 利用空间为n的辅助数组
     * @param num
     */
    public static void getDuplicate2(int[] num) {
        //鲁棒性
        int[] temp = new int[num.length - 1];
        for (int i = 0; i < num.length; i++) {
            if (num[i] == temp[num[i] - 1]) {
                System.out.print(num[i] + "  ");
            }else {
                temp[num[i] - 1] = num[i];
            }
        }
    }
    //还可以利用hash表

    public static void main(String[] args) {
        int[] num = {2,3,5,4,3,2,6,7};
        getDuplicate1(num);
        getDuplicate2(num);
    }
}
