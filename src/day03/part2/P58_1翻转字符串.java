package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/8 0008 21:45
 */
public class P58_1翻转字符串 {

    public static String reverseSentence(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        char[] temp = str.toCharArray();
        //翻转整个句子
        reverseString(temp, 0, temp.length - 1);
        //翻转独个单词
        int i = 0;
        int j = 0;
        for (; j < temp.length; j++) {
            if (temp[j] == ' ') {
                reverseString(temp, i, j - 1);
                i = j + 1;
            }
            if (j == temp.length - 1) {
                reverseString(temp, i, j);
            }
        }
        return String.valueOf(temp);
    }

    private static void reverseString(char[] num, int start, int end) {
        while (start < end) {
            char temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("Iaw am a Students"));
    }
}
