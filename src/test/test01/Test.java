package test.test01;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 20:36
 */
public class Test {
    public static void main(String[] args) {
        char c = '1';
        System.out.println(c + "" + "22");
        System.out.println(0.06+0.05);
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
