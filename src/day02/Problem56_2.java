package day02;

/**
 * @Author:王喜
 * @Description : 数组中只有一个数字出现了一次，其他都出现了3次。
 * @Date: 2018/5/10 0010 18:34
 */
public class Problem56_2 {

    public static void findNumberAppearingOnce(int[] num) {
        if (num == null || num.length <= 0) {
            return ;
        }
        int[] temp = new int[32];
        for (int i = 0; i < num.length; i++) {
            StringBuilder sb = new StringBuilder();
            String s = Integer.toBinaryString(num[i]);
            sb.append(s);
            int length = s.length();
            for (int q = length; q < 32; q++) {
                sb.insert(0, '0');
            }
            for (int j = 0; j < 32; j++) {
                int a = (int)(sb.charAt(j)) - 48;
                temp[j] += a;
            }
            sb = null;
        }
        //把二进制转化为10进制
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int q = temp[i] % 3;
            result += q << (31 - i);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
//        System.out.println((int)'1');
        int[] num = {2,3,4,5,2,3,4,4,3,2};
        findNumberAppearingOnce(num);

        /**
         * toBinaryString方法省去了前面的0。
         */
        System.out.println(Integer.toBinaryString(10));
    }

}
