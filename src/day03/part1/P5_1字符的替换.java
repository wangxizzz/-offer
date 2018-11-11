package day03.part1;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/21 0021 21:55
 */
public class P5_1字符的替换 {

    /**
     * 时间O(n),空间O(n+m)的新数组
     * @param array
     */
    public static String replaceSpace(char[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        int countSpace = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                countSpace++;
            }
        }
        int newLength = array.length + countSpace * 2;
        char[] num = new char[newLength];
        int small = array.length - 1;
        int big = newLength - 1;
        while (small >= 0) {   //small == big 时确实没有空格，但是需要把原数组的所有内容复制到新数组
            if (array[small] != ' ') {
                num[big--] = array[small--];
            }else {
                small--;
                num[big--] = '0';
                num[big--] = '2';
                num[big--] = '%';
            }
        }
        return String.valueOf(num);
    }

    public static void main(String[] args) {
        String s = "hello world.";
        char[] num = s.toCharArray();
        System.out.println(replaceSpace(num));
        //jdk中的方法
        s = s.replaceAll(" ", "%20");
        System.out.println(s);
    }
}
