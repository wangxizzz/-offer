package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/28 0028 10:16
 */
public class P39超过一半的数字 {

    //基于快排的思想（改变了数组中元素的位置），时间O(n)
    public static Integer getMoreThanHalfNum(int[] num) {
        if (num == null || num.length <= 0) {
            return null;
        }
        int mid = num.length >> 1;
        int start = 0;
        int end = num.length - 1;
        int index = partition(num, start, end);
        while (mid != index) {
            if (index > mid) {
                end = index - 1;
                index = partition(num, start, end);
            }else if (index < mid) {
                start = index + 1;
                index = partition(num, start, end);
            }
        }
        return num[mid];
    }

    private static int partition(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && array[end] >= temp) {
                end--;
            }
            array[start] = array[end];  //注意：只交换小于的，等于不交换
            while (start < end && array[start] <= temp) {
                start++;
            }
            array[end] = array[start];
        }
        array[end] = temp;
        return end;
    }


    //不移动元素的位置，时间O(n)
    public static int getNumNotRemoveElement(int[] num) {
        if (num == null) {
            return -1;  //输入不合法
        }
        int result = num[0];
        int times = 1;
        for (int i = 1; i < num.length; i++) {
            if (times == 0) {
                result = num[i];
            }
            if (num[i] == result) {
                times++;
            }else {
                times--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] num = {1,2,3,2,2,2,5,4,2};
        System.out.println(getMoreThanHalfNum(num));
        System.out.println(getNumNotRemoveElement(num));
    }
}
