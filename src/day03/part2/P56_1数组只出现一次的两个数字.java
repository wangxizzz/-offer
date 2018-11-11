package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/7 0007 22:00
 */
public class P56_1数组只出现一次的两个数字 {
    public static void findNumsAppearOnce(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int result1 = 0;
        int result2 = 0;
        if (array.length == 2) {
            result1 = array[0];
            result2 = array[1];
            return;
        }
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        int index = get1BitIndex(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {
                result1 ^= array[i];
            }else {
                result2 ^= array[i];
            }
        }
        System.out.println(result1);
        System.out.println(result2);

    }
    private static int get1BitIndex(int val) {
        int index = 0;
        while (index < 32) {
            index++;
            if ((val & 1) == 1) {
                break;
            }
            val = val >> 1;
        }
        return index;
    }
    private static boolean isBit1(int val, int index) {
        val = val >> (index - 1);
        return (val & 1) == 1;
    }

    public static void main(String[] args) {
        int[] num = {2,4,3,6,3,2,5,5};
        findNumsAppearOnce(num);
    }
}
