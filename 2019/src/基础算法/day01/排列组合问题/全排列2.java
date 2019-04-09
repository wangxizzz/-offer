package 基础算法.day01.排列组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <Description>
 * 1,1,2 全排列：112,121,211
 * 参考网址：https://www.cnblogs.com/zhizhizhiyuan/p/3821442.html
 * @author wangxi
 */
public class 全排列2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 为后面的剪枝做铺垫
        Arrays.sort(nums);
        boolean[] flags = new boolean[nums.length]; // 默认都是 false
        backtrack(list, new ArrayList<>(), nums, flags);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] flags) {
        if (templist.size() == nums.length) {
            list.add(new ArrayList<>(templist));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (flags[i]) {
                    continue; // 如果这个元素使用过了，就不再加入进去
                }
                /**
                 * 去重代码：这个剪枝代码的正确性需要数组已经排序作为保证。
                 * 1. 与前一个相等；2. 前一个没有被访问。这样就能保证相同的元素按顺序每层只访问一个。
                 */
                if (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1]){
                    continue; //
                }
                flags[i] = true;
                templist.add(nums[i]);
                backtrack(list, templist, nums, flags);
                templist.remove(templist.size() - 1);
                flags[i] = false;
            }
        }


    }

}

