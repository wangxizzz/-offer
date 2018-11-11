package demos.demo01;

/**
 * @Author:王喜
 * @Description :面试49
 * @Date: 2018/4/17 0017 20:47
 */
public class 丑数 {

    public static boolean uglyNumber(int n) {
        if (n <= 0) {
            return false;
        }
        while(n % 2 == 0) {
            n = n/2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return (n == 1) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(uglyNumber(102));
    }
}
