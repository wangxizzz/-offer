package review.day02;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 21:04
 */
public class 最大价值礼物 {

    public static int getMaxPrice(int[][] nums){
        if (nums == null || nums.length <= 0 || nums[0].length <= 0) {
            return -1;
        }
        int rows = nums.length;
        int cols = nums[0].length;
        int[][] max = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i != 0) {
                    up = max[i - 1][j];
                }
                if (j != 0) {
                    left = max[i][j - 1];
                }
                max[i][j] = Math.max(up, left) + nums[i][j];
            }
        }
        return max[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] num = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxPrice(num));
    }
}
