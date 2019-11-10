package leecode.测试使用;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author wangxi
 * @Time 2019/11/10 23:10
 */
public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>(list));
        list.set(0, 2);
        list.set(1, 1);
        System.out.println(result.contains(list));
        result.add(new ArrayList<>(list));
        System.out.println(result);
    }
}
