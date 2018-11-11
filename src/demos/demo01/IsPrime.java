package demos.demo01;

/**
 * @Author:王喜
 * @Description :判断一个数是否为素数
 * @Date: 2018/4/16 0016 22:45
 */
public class IsPrime {

    public static boolean isPrime(int data) {
        if (data <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(data); i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(4));
    }
}
