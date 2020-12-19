package leecode.回溯排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangxi created on 2020/12/19 23:30
 * @version v1.0
 * https://leetcode-cn.com/problems/permutations-ii/solution/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return result;
        }
        boolean[] flag = new boolean[nums.length];
        // 排序
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, flag);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] flag) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 可以画二叉树来看出剪枝条件
            if (flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) {
                continue;
            }
            flag[i] = true;
            list.add(nums[i]);
            dfs(result, list, nums, flag);
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
