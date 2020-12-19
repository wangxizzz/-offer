package leecode.回溯排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxi created on 2020/12/19 23:16
 * @version v1.0
 * https://leetcode-cn.com/problems/permutations/
 *
 * 解题的步骤是：先画图，再编码
 *
 * 在画图的过程中思考清楚：
 *  1、分支如何产生；
 *  2、题目需要的解在哪里？是在叶子结点、还是在非叶子结点、还是在从跟结点到叶子结点的路径？
 *  3、哪些搜索会产生不需要的解的？例如：产生重复是什么原因，如果在浅层就知道这个分支不能产生需要的结果，应该提前剪枝，剪枝的条件是什么，代码怎么写？
 *
https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1,2,3};
        permutations.permute01(nums);
        permutations.permute02(nums);
    }


    public List<List<Integer>> permute02(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>(len);

        dfs02(nums, len, path, used, res);
        return res;
    }

    private void dfs02(int[] nums, int len,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs02(nums, len, path, used, res);

                used[i] = false;
                path.remove(path.size() - 1);
                System.out.println("递归之后 => " + path);
            }
        }
    }


    // 解法1
    public List<List<Integer>> permute01(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        dfs01(nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs01(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs01(nums, list, res);
            // 想要判断回退后i的值，只需要根据回退前最后一个压栈i的值，即就是return的i的值
            list.remove(list.size() - 1);
        }
    }
}
