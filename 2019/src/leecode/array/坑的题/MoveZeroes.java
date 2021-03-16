package leecode.array.坑的题;

/**
 * @author wangxi03 created on 2021/3/15 1:05 下午
 * @version v1.0
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        obj.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (zeroIndex == -1 && nums[i] == 0) {
                zeroIndex = i;
            } else {
                if (zeroIndex != -1 && nums[i] != 0) {
                    int temp = nums[zeroIndex];
                    nums[zeroIndex] = nums[i];
                    nums[i] = temp;
                    zeroIndex++;
                }
            }
        }
    }
}
