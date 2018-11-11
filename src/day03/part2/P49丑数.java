package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/4 0004 18:46
 */
public class P49丑数 {
    /**
     * 复用前面的结果,保证丑数数组从小到大是排序的
     *
     * @param index 第几个丑数
     * @return
     */
    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return -1;
        }
        int[] result = new int[index];
        result[0] = 1;   //结果数组从0开始
        int count = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        while (count < index) {
            int min = min(result[multiply2] * 2, result[multiply3] * 3, result[multiply5] * 5);
            result[count] = min;
            while (result[multiply2] * 2 == result[count])  {
                multiply2++;
            }
            while (result[multiply3] * 3 == result[count]) {
                multiply3++;
            }
            while (result[multiply5] * 5 == result[count]) {
                multiply5++;
            }
            count++;
        }
        return result[index - 1];
    }

    private static int min(int num1, int num2, int num3) {
        int minValue = num1 > num2 ? num2 : num1;
        return minValue > num3 ? num3 : minValue;
    }

    /**
     * 暴力解决
     * @param index
     * @return
     */
    public static int getNum(int index) {
        if (index <= 0) {
            return -1;
        }
        int count = 0; // 默认1为丑数
        int result = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUglyNum(i)) {
                count++;
            }
            if (count == index) {
                result = i;
                break;
            }
        }
        return result;
    }
    private static  boolean isUglyNum(int val) {
        while (val % 2 == 0) {
            val /= 2;
        }
        while (val % 3 == 0) {
            val /= 3;
        }
        while (val % 5 == 0) {
            val /= 5;
        }
        return val == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
        System.out.println(getNum(1500));
    }
}
