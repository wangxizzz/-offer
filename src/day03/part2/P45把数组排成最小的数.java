package day03.part2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/3 0003 13:03
 */
public class P45把数组排成最小的数 {
    /**
     * //只能定义为Integer[] num，否则的话没有Comparator方法
     * 数组元素进行拼接需要考虑大数的问题，用字符串来解决
     * @param num
     * @return
     */
    public static String getMinNumber(Integer[] num) {
        if (num == null || num.length <= 0) {
            return null;
        }

        Arrays.sort(num, new Comparator<Integer>() {
            //重写compare方法来比较o1,o2的大小，当o1+""+o2和o2+""+o1
            //都是字符串，比较o1,o2的大小其实是比较两个子串的大小
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 + "" + o2).compareTo((o2 + "" + o1));  //默认小到大
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] num = {3,32,321};
        System.out.println(getMinNumber(num));
    }
}
