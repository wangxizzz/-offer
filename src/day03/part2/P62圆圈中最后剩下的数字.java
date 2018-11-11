package day03.part2;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangxi
 * @Description : 参考网址：https://blog.csdn.net/derrantcm/article/details/46798717
 * @Date: 2018/7/10 0010 21:16
 */
public class P62圆圈中最后剩下的数字 {
    /**
     * 时间O()
     * @param n  n个数字（是0~n-1数字组成的圆圈）
     * @param m  每次删第m个数字
     * @return
     */
    public static int getLastRestNum(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int index = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            index = index + m - 1;
            index = index % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(getLastRestNum(5,3));
    }
}
