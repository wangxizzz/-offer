package day02;

/**
 * @Author:王喜
 * @Description : 面试49 利用已经计算好的结果
 * @Date: 2018/4/17 0017 20:45
 */
public class 第1500个丑数 {

    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int mutiply2 = 0;
        int mutiply3 = 0;
        int mutiply5 = 0;
        for (int i = 1; i < index; i++) {
            int min = getMin(uglyArray[mutiply2] * 2, uglyArray[mutiply3] * 3,
                    uglyArray[mutiply5] * 5);
            uglyArray[i] = min;  //从第二个位置存储丑数
            //防止有重复的丑数
            while (uglyArray[mutiply2] * 2 == uglyArray[i]) {
                mutiply2++;
            }
            while (uglyArray[mutiply3] * 3 == uglyArray[i]) {
                mutiply3++;
            }
            while (uglyArray[mutiply5] * 5 == uglyArray[i]) {
                mutiply5++;
            }
        }
        return uglyArray[index - 1];
    }

    private static int getMin(int x, int y, int z) {
        int temp = (x < y) ? x : y;
        return (temp < z) ? temp : z;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
    }
}
