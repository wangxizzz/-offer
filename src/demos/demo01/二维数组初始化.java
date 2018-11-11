package demos.demo01;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/22 0022 15:43
 */
public class 二维数组初始化 {
    public static void main(String[] args) {

        //第一种方式：
        int a[][]={{1,2,3},{4,5,6}};

        //第二种方式；
        int[][] ints = new int[4][2];

        //第三种方式：第二维的长度可以动态申请
        int[][] arr3 = new int[5][];//五行的长度
        for(int i=0; i<arr3.length; ++i){
            arr3[i]=new int[i+1];   //列的长度每次都变化。每次都要重新申请空间(长度)
            for(int j=0; j<arr3[i].length; ++j)
                arr3[i][j]= i+j;
        }
    }
}
