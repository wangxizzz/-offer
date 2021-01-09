package leecode.array;

import java.util.Arrays;

/**
 * @author wangxi created on 2021/1/9 20:17
 * @version v1.0
 * <p>
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 * 把数组排成最小的数
 */
public class MinNumberWithArray {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(strs[i]);
        }
        return buffer.toString();
    }
}
