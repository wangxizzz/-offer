package day03.part1;

/**
 * @Author: wangxi
 * @Description : 任何数的0次幂都为0
 * @Date: 2018/5/27 0027 13:31
 */
public class p16数值的整数次方 {

    public static double pow(double base, int exp) {
        //考虑base = 0, exp < 0 的无意义情况
        if (base == 0 && exp < 0) {
            System.out.println("参数错误");
            return 0.0;
        }
        double result = multiply(base, Math.abs(exp));
        if (exp < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private static double multiply(double base, int exp) {
        double result = 1.0;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 此方法只适合exp >= 0的  P112
     * @param base 基数
     * @param exp  幂数
     * @return
     */
    public static double pow2(double base, int exp) {
        if (exp == 0) {
            return 1.0;
        }
        if (exp == 1) {
            return base;
        }
        double result = pow2(base, (exp >> 1));
        result = result * result;
        //判断exp奇、偶性
        if ((exp & 1) == 1) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(-2, -3));
        System.out.println(pow2(2, 4));
    }
}
