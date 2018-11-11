package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/3 0003 10:38
 */
public class P44数字序列中某一位的数字 {

    public static int getNum(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers) {
                return digitAtIndex(index, digits);
            }
            index = index - digits * numbers;
            digits++;
        }
    }
    //统计digits位数一共多少个数字
    private static int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int)(Math.pow(10, digits - 1)); //尽量少一次pow操作
        return 9 * count;
    }

    private static int digitAtIndex(int index, int digits) {
        int number = begin(digits) + index / digits;
        int indexRight = digits - index % digits;
        for (int i = 1; i < indexRight; i++) {
            number = number / 10;
        }
        return number % 10;
    }

    private static int begin(int digit) {
        if (digit == 1) {
            return 10;
        }
        return (int)(Math.pow(10, digit - 1));
    }

    public static void main(String[] args) {
        System.out.println(getNum(1001));
    }
}
