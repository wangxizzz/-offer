package demos.demo01;

/**
 * @Author:王喜
 * @Description : 二维数组初始化
 * @Date: 2018/5/20 0020 22:41
 */
public class Demo01 {

    public static void init(int[][] num) {
        for (int i = 0; i < num.length; i++) {
//            num[i] = new int[2]; 如果设置了列的长度
            num[i] = new int[i+1];  //每一列的元素可以自己设置
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = 1;
            }
        }
    }

    public static void print(int[][] num) {
        if (num == null || num.length <= 0) {
            return;
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //方法一
        int[][] num1 = {{1,2},{2,3}};
        print(num1);
        //方法二
        int[][] num2 = new int[2][2];
        init(num2);
        print(num2);
        //方法三
        int[][] num3 = new int[2][];

    }
}
