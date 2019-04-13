package 基础算法.day01.排列组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class 组合3 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        combinationSum(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }
    private void combinationSum(List<List<Integer>> result, int[] candidates, int rest, List<Integer> list, int start) {
        if (rest < 0) {
            return;
        }
        if (rest == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            // 元素可以重复使用。
            combinationSum(result, candidates, rest - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}

