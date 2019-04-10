package 基础算法.day01.排列组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <Description>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author wangxi
 */
public class 组合2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        // 需要排序
        Arrays.sort(candidates);
        combinationSum2(result, candidates, target, target, new ArrayList<>(), 0);
        return result;
    }
    private void combinationSum2(List<List<Integer>> result, int[] nums, int target, int rest,List<Integer> list, int start) {
        if (rest < 0) {
            return;
        }
        if (rest == 0) {
            result.add(new ArrayList<>(list));
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            // 去重
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            combinationSum2(result, nums, target, rest - nums[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}

