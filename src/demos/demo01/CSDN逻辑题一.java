package demos.demo01;

/**
 * @Author:王喜
 * @Description :打印
1
3    4
5   8    12
7   12   20   32
9    16  28    48   80
.....


输入任意一个奇数，输出那一行的数据
 * @Date: 2018/4/22 0022 14:52
 */
public class CSDN逻辑题一 {

    public static void f1(int n) {
        if (n <= 0 || n % 2 == 0) {
            System.out.println("n不是奇数");
            return;
        }
        int length = 2*n-1;
        //存放结果的数组
        int[] result = new int[length];
        result[0] =  length;
        for (int i = 1; i < length; i++) {
            result[i] = (int) (result[i - 1] *2 - Math.pow(2, i));
        }

        //输出结果
        for (int i : result) {
            System.out.print(i + "   ");
        }
    }

    //采用普通的方法
    public static void f2(int n) {
        //先得到二维数组，然后再输出指定行
        int[][] temp = new int[n][];
        for (int i = 0; i < n; i++) {
            //列的长度每次都变化。每次都要重新申请空间(长度)
            temp[i] = new int[i+1];
            temp[i][0] = (i+1)*2 - 1;
            for (int j = 1; j < i+1; j++) {
                temp[i][j] = temp[i-1][j-1] + temp[i][j-1];
            }
        }
        //遍历二维数组，在列动态变化的情况下
        for (int[] i : temp) {  //遍历每一行
            for (int j : i) {   //遍历该行每一列
                System.out.print(j+ "   ");
            }
            System.out.println();
        }

        System.out.println();

        for (int[] i : temp) {
//            System.out.println(i[0]);
            //i[0]表示该行的第一列
            if (i[0] == 2*n-1) {
                for (int j : i) {
                    System.out.print(j + "   ");
                }
            }
        }

    }

    public static void f3(int n) {
        int num = n;
        //行数
        int row = num / 2 + 1;
        int[][] datas = new int[row][];
        for (int i = 0; i < row; i++) {
            //每行列数
            int column = i + 1;
            datas[i] = new int[column];
            for (int j = 0; j < column; j++)
                if (j == 0)
                    datas[i][j] = 2 * column - 1;
                else
                    datas[i][j] = datas[i - 1][j - 1] + datas[i][j - 1];
        }
        for (int[] arr : datas)
            //只输出给定行
            if (arr[0] == num)
                for (int data : arr)
                    System.out.print(data + " ");
    }

    public static void main(String[] args) {
        f2(3);
//        f3(3);
    }
}
