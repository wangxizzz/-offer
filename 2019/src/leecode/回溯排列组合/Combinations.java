package leecode.回溯排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxi created on 2020/12/20 00:07
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/combinations/
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(result, new ArrayList<>(), nums, k, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            // 维护一个i，防止往后退
            dfs(result, list, nums, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
