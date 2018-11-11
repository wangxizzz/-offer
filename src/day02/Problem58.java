package day02;

/**
 * @Author:王喜
 * @Description : 继Problem58_error的修正版
 * @Date: 2018/5/16 0016 11:05
 */
public class Problem58 {
    /** 解法一：
     *
     * 考虑到String类型不可变，因此翻转它并不能改变原本的值，因此用char数组
     * @param array 待翻转的字符串的char数组
     *
     * @return 时间复杂度O(n),空间复杂度O(1)
     */
    public static String reverseSentence(char[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        //翻转整个字符串
        reverse(0, array.length - 1, array);
        /**
         * 注意 ： char数组并没有重写toString()方法，因此array.toString()方法返回地址。
         */
        System.out.println(String.valueOf(array));
        //然后再翻转单个单词，按照空格进行切分.
        int i = 0;
        int j = 0;
        for (; j < array.length; j++) {
            if (array[j] == ' ') {
                reverse(i, j - 1, array);
                i = j + 1;
            }
            if (j == array.length - 1) {
                reverse(i, j, array);
            }
        }
        System.out.println(String.valueOf(array));
        return null;
    }

    private static void reverse(int begin, int end, char[] array) {
        if (array == null || array.length <= 0) {
            return ;
        }
        while (begin < end) {
            char temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
    }

    /**
     * 通过按照空格进行切分。空格是不需要转义的.
     * @param str  这种方法有bug  不建议使用，无法通过牛客网的测试
     * @return 时间O(n),空间O(n)
     */
    public static String reverseSentenceBySplit(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        if (" ".equals(str)) {
            return " ";
        }
        String[] temp = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            sb.append(temp[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Iwa am a student.";
        char[] array = s.toCharArray();
        reverseSentence(array);
        System.out.println(reverseSentenceBySplit(" ").length());

    }
}
