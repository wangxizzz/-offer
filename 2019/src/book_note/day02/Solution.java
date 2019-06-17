package book_note.day02;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0] >= s ? 1 : 0;
        }
        int i = 0;
        int curSum = nums[i];
        int minLen = Integer.MAX_VALUE;
        int curLen = 1;
        int j = 0;
        while (i < len &&j < len) {
            if (i == j && nums[i] >= s) {
                return 1;
            }
            if (curSum >= s) {
                if (curLen < minLen) {
                    minLen = curLen;
                }
                curSum -= nums[i];
                i++;
                curLen--;
            } else {
                j++;
                if (j < len) {
                    curLen++;
                    curSum += nums[j];
                }
            }
        }
        return minLen;
    }
}

