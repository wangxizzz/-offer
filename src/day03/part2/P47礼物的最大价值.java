package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/3 0003 18:56
 */
public class P47礼物的最大价值 {
    /**
     * 动态规划，时间复杂度O(m*n),可以只用以为数组保存中间结果
     * @param num
     * @return
     */
    public static int getMaxPrice(int[][] num){
        if (num == null || num.length <= 0) {
           return -1;
        }
        int rows = num.length;
        int cols = num[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = result[i - 1][j];
                }
                if (j > 0) {
                    left = result[i][j - 1];
                }
                result[i][j] = Math.max(up, left) + num[i][j];
            }
        }
        return result[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] num = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxPrice(num));
    }
}
