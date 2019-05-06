package 基础算法.day01.排列组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 * 此题给的数组元素没有重复，因此没有剪枝函数，不需要排序，当然本身就是有序的。
 * https://leetcode.com/problems/combinations/
 * @author wangxi
 */
public class 组合 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k || n < 1 || k < 1) {
            return result;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        combine(nums, result, new ArrayList<>(), k, 0);
        return result;
    }
    private static void combine(int[] nums, List<List<Integer>> result, List<Integer> list, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            // 始终与i后面一个组合.只维持一个变量i的改变
            combine(nums, result, list, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(combine(4, 2));
    }
}

