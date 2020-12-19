package leecode.回溯排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangxi created on 2020/12/20 00:34
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * [1,2,2]
 *
 *
 * 子集的题目与 组合的题目解法有很大的相似性
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        if (list.size() >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
