package test.test01;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 9:51
 */
public class 打印菱形 {
    public static void main(String[] args) {
        int lay=5;
        for (int i=1;i<=lay;i++) //i表示空心菱形上半部分行数；类似于金字塔行数
        {
            for (int j=1;j<=lay-i;j++) //j表示每行"*"号前面的空格数
            {
                System.out.print(" ");
            }
            for (int k=1;k<=2*i-1;k++) //k表示每行要打印的"*"号
            {
                if (k==1||k==2*i-1) //如果要打印的"*"是第一个或最后一个则打印出来
                {
                    System.out.print("*");
                }
                else
                    System.out.print(" "); //如果要打印的"*"不是第一个或最后一个则打印空格
            }
            System.out.println();
        }        //以上打印出来的是空心菱形的上半部分
        for (int i=1;i<=lay-1;i++)  //空心菱形下半部分的行数为lay-1行；比如上半部分4行，则下半部分为3行才能构成菱形
        {
            for (int j = 1; j <= i; j++) //每行空格数
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (lay - i) - 1; k++) //下半部分每行总的"*"数
            {
                if (k == 1 || k == 2 * (lay - i) - 1) //如果"*"处在第一和最后一位则打印出来
                {
                    System.out.print("*");
                } else
                    System.out.print(" "); //如果"*"不是处在第一和最后一位则打印出空格
            }
            System.out.println();
        }
    }
}
