package leecode.回溯排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangxi created on 2020/12/19 23:53
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * [10,1,2,7,6,1,5], target = 8  数组有重复元素
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        // 一定需要先排序
        Arrays.sort(candidates);
        dfs(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int target, List<Integer> list, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 组合天然就有不会往后走的优势，因此不用考虑前面元素是否use的情况
            //  注意：i > start
            if (i > start && nums[i] == nums[ i -1]) {
                continue;
            }
            list.add(nums[i]);
            // 不能往后走，否则会有逻辑错误
            dfs(result, nums, target - nums[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
