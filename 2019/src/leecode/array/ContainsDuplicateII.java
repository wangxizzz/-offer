package leecode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wangxi
 * @Time 2020/2/22 20:49
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) {
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,0};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
