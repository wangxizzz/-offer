package leecode.回溯排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxi created on 2020/12/19 23:39
 * @version v1.0
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 注意有两个条件：
 * 所有数字（包括 target）都是正整数。（可以使用target<0来当做递归退出的条件）
 * 解集不能包含重复的组合。
 *  candidates = [2,3,6,7], target = 7
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
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
            list.add(nums[i]);
            // 不能往后走，否则会有逻辑错误
            // 注意，start参数只能使用i来递归。因为在for循环中,i的值会变，而循环中start不会变
            dfs(result, nums, target - nums[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
