package demos.demo01;

/**
 * @Author:王喜
 * @Description :1+2+...n递归实现
 * @Date: 2018/5/24 0024 13:23
 */
public class Demo02 {

    public static int sum(int n) {
        //边界条件
        if (n == 1) {
            return 1;
        }
        int result = n;
        return result + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
    }
}
