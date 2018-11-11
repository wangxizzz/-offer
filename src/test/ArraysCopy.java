package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:王喜
 * @Description :测试数组的copyOfRange方法
 * @Date: 2018/4/15 0015 10:24
 */
public class ArraysCopy {

    public static void main(String[] args) {
//        String s = Integer.toBinaryString(n);
        ArrayList<Integer> list = new ArrayList<>(3);
        list.add(100);
//        System.out.println(list.get(2));
        int[] array = {1,2,3,4,5,6,7};
        //新数组长度是to-from
        int[] a = Arrays.copyOfRange(array, 0, 3);
        for (int i : a) {
            System.out.println(i);
        }
        String s = "As,,";
        s = s.toLowerCase();
        System.out.println(s);
    }
}
