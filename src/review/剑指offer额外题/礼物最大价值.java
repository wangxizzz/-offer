package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description :P47  P233
 * @Date: 2018/8/10 0010 13:31
 */
public class 礼物最大价值 {

    public static int getMaxValue(int[][] num){
        if (num == null || num.length <= 0 || num[0].length <= 0) {
            return -1;
        }
        int rows = num.length;
        int cols = num[0].length;
        int[][] max = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = max[i - 1][j];
                }
                if (j > 0) {
                    left = max[i][j - 1];
                }
                max[i][j] = Math.max(up, left) + num[i][j];
            }
        }
        return max[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] num = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxValue(num));
    }
}
