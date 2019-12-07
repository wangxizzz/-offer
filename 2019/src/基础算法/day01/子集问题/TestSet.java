package 基础算法.day01.子集问题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author wangxi
 * @Time 2019/12/7 18:06
 * AbstractList重写了hashCode与equals()方法。因此可以使用Set存储
 * 注意：List{1,2,3} 和 List{3,2,1}的equals方法是不相等的。
 */
public class TestSet {
    public static void main(String[] args) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        result.add(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(2);
        System.out.println(result.add(list2));
    }
}
