package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wangxi
 * @Description :  https://www.nowcoder.com/discuss/75367
 * @Date: 2018/8/31 0031 20:10
 */
public class 最小的数 {
    /**
     * 给定1/2/3/4/5五个数，已知现在有m = 12543。
     * 求用这五个数凑出大于m的最小值（数字不能重复，如：111111）。
     */

    public static void min(int m) {

        String s = String.valueOf(m);
        char[] array = s.toCharArray();
        int length = s.length();
        int i = length - 1;
        List<Character> list = new ArrayList<>();
        // 从后往前找找到第一个比后面元素小的元素的下标
        for (; i > 0; i--) {

            if (s.charAt(i - 1) < s.charAt(i)) {
                break;
            }
        }
        // 然后定位到该下标
        i = i - 1;
        char min = array[length - 1];
        int j = length - 1;
        // 找出下标后面的元素的最小值的下标
        for (int k = length - 1; k > i; k--) {
            if (array[k] < min) {
                min = array[k];
                j = k;
            }
        }
        // 把两个下表对应的元素交换
        array[j] = array[i];
        array[i] = min;
        // 把后面的数排成最小的数返回
        for (int k = length - 1; k > i; k--) {
            list.add(array[k]);
        }
        String res = getMin(list);
        StringBuilder sb = new StringBuilder();
        // 组合前面的数
        for (int k = i; k >= 0; k--) {
            sb.insert(0, array[k]);
        }
        sb.append(res);
        System.out.println(Integer.parseInt(sb.toString()));
    }
    private static String getMin(List<Character> list) {
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return (o1 + "" + o2).compareTo(o2 + "" + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        min(12543);
    }
}
