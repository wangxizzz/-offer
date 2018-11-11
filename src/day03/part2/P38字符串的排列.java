package day03.part2;

/**
 * @Author: wangxi
 * @Description : 参考网址：https://blog.csdn.net/bitcarmanlee/article/details/51558272
 * @Date: 2018/6/26 0026 19:48
 */
public class P38字符串的排列 {

    public static void pailie(char[] s, int start, int end) {
        if (end <= 1) {   //当元素只有一个
            return;
        }
        //到达末尾
        if (start == end) {
            System.out.println(s);
        }
        for (int i = start; i <= end; i++) {
            swap(s, start, i);   //把第一个字符与后面的所有字符交换
            pailie(s, start + 1, end);  //把每种情况拿出来 固定一个字符，求后面的全排列
            swap(s, i, start);
        }
    }
    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c'};
        pailie(s, 0, s.length - 1);
    }
}
