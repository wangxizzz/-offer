package review.day02;

/**
 * @Author: wangxi
 * @Description : 最长公共子序列
 * @Date: 2018/8/25 0025 20:22
 */
public class LCS {

    public static int[][] getLength(String s1, String s2) {
        if (s1 == null || s1.length() <= 0 || s2 == null || s2.length() <= 0) {
            return null;
        }
        int rows = s1.length() + 1;
        int cols = s2.length() + 1;
        int[][] a = new int[rows][cols];
        int[][] b = new int[rows][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else {
                    if (a[i - 1][j] >= a[i][j - 1]) {  // 带等号
                        a[i][j] = a[i - 1][j];
                        b[i][j] = 0;
                    } else {
                        a[i][j] = a[i][j - 1];
                        b[i][j] = 1;
                    }
                }
            }
        }
        System.out.println(a[rows - 1][cols - 1]);
        return b;
    }

    public static void display(int[][] b, int i, int j, StringBuilder sb, String s1){
        if (i < 1 || j < 1) {
            return;
        }
        if (b[i][j] == 1) {
            display(b, i - 1, j - 1, sb, s1);
            sb.append(s1.charAt(i - 1));
        }
        if (b[i][j] == 0) {
            display(b, i - 1, j, sb, s1);
        }
        if (b[i][j] == -1)
        {
            display(b, i, j - 1, sb, s1);
        }
    }

    public static void main(String[] args) {
        String s1 = "abccade";
        String s2 = "dgcadde";
        int[][] b = getLength(s1, s2);
        StringBuilder sb = new StringBuilder();
        display(b, b.length - 1, b[0].length - 1, sb, s1);
        System.out.println(sb.toString());
    }
}
