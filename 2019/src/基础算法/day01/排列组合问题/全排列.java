package 基础算法.day01.排列组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <Description>
 *123 的全排列：123,132,213,231,312,321.
 *
 * 给的数字不重复，利用回溯法。
 * @author wangxi
 */
public class 全排列 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    public static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums){
        if (templist.size() == nums.length) {
            list.add(new ArrayList<>(templist));// 符合条件的加入进去
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (templist.contains(nums[i])){ // 这个判断是否包含重复
                continue;
            }
            templist.add(nums[i]);
            /**
             * 这里的递归可以看做：
             * 调用别的类的backtrack方法，返回执行完返回，这样就可以理解第一次return i=2,t=2。
             */
            backtrack(list, templist, nums);
            /**
             * 引用分配在堆上，因此需要手动删掉。
             * 如果是栈所持有的变量，在递归到下一层时，值是不会带到下一层的。
             * 比如：int 变量默认是0.
              */
            templist.remove(templist.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}

