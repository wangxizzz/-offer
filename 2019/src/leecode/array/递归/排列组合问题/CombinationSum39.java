package leecode.array.递归.排列组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangxi
 * @Time 2019/11/10 21:00
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        help(candidates, new ArrayList<>(), target, 0, result, 0);
        return result;
    }

    private void help(int[] nums, List<Integer> list, int target, int sum, List<List<Integer>> result, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            //list.remove(list.size() - 1);
            return ;
        }
        if (sum > target) {
            //list.remove(list.size() - 1);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            /**
             * 总结：
             * 1. 如果想要局部变量随着return的执行而回退到上个值，那么这个变量的计算一定要放到
             * 递归方法的里面，如下sum的计算所示；否则就需要手动回退到上个值，另外堆变量需要手动remove元素
             * 2.注意，start指针的用法。
             */
            list.add(nums[i]);
            //sum += nums[i];
            // 只要函数return或结束，都会走到递归的最初地方下一行代码，也就是这儿list.remove函数，
            // 当然如果递归函数又返回值，那么会跳到递归的最初地方赋值
            help(nums, list, target, sum + nums[i], result, i);
            list.remove(list.size() - 1);
            //sum -= nums[i];
        }
        // 当list本来就只有一个元素，又正好满足剪枝函数移除了一个，此时就为空。
//        if (!list.isEmpty()) {
//            list.remove(list.size() - 1);
//        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(new CombinationSum39().combinationSum(nums, 7));
    }
}
