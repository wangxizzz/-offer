package demos.算法文章;

/**
 * @Author: wangxi
 * @Description :参考网址：https://blog.csdn.net/u013063153/article/details/49593353
 *                          https://blog.csdn.net/fjssharpsword/article/details/51953952
 * @Date: 2018/6/26 0026 10:49
 */
public class 最长公共子序列 {
    /**
     *保留空字符串是为了getLength()方法的完整性
        也可以不保留，但是在getLength()方法里面必须额外的初始化c[][]第一个行第一列
     * @param s1 String[] s1 = {"", "A", "B", "C", "B", "D", "A", "B"};
     * @param s2 String[] s2 = {"", "B", "D", "C", "A", "B", "A"};
     * @return
     */
    public static int[][] getLength(String[] s1, String[] s2) {
        if (s1 == null || s2 == null) {
            return null;
        }

        int length1 = s1.length;
        int length2 = s2.length;
        int[][] a = new int[length1][length2];  //a数组存储的是博客上的图
        int[][] b = new int[length1][length2];  //b数组便于输出序列结果
        //初始化a,b数组
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (s1[i] == s2[j]) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                }else if (a[i - 1][j] >= a[i][j - 1]) {
                    a[i][j] = a[i - 1][j];
                    b[i][j] = -1;
                } else {
                    a[i][j] = a[i][j - 1];
                    b[i][j] = 0;
                }
            }
        }
        System.out.println("最长子序列的长度是" + a[length1 - 1][length2 - 1]);
        return b;
    }
    //从后往前回溯
    public static void getResult(int[][] b, String[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            //压栈
            getResult(b, x, i - 1, j - 1);
            System.out.print(x[i]);
        }
        if (b[i][j] == -1) {
            getResult(b, x, i - 1, j);
        }
        if (b[i][j] == 0) {
            getResult(b, x, i ,j - 1);
        }
    }

    public static void main(String[] args) {
        String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"", "B", "D", "C", "A", "B", "A"};

        int[][] b = getLength(x, y);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        getResult(b, x, x.length - 1, y.length - 1); //把具体的元素传进去
    }
}
