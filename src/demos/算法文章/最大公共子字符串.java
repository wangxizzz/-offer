package demos.算法文章;

/**
 * @Author: wangxi
 * @Description :
 *          编程找出两个字符串中最大公共子字符串,如"abccade","dgcadde"的最大子串为"cad"
 *          参考网址：https://blog.csdn.net/xiaoyi357/article/details/70209164/
 * @Date: 2018/8/9 0009 11:35
 */
public class 最大公共子字符串 {

    public static String findLongestCommonSubString(String s1, String s2){
        if (s1 == null || s2 == null) {
            return null;
        }

        int length1 = s1.length() + 1;
        int length2 = s2.length() + 1;
        int[][] temp = new int[length1][length2];
        int maxLength = 0;
        int pos = 0;  // 记录最大长度的列
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {   // 填表
                    temp[i][j] = temp[i - 1][j -1] + 1;
                    if (temp[i][j] > maxLength) {
                        maxLength = temp[i][j];
                        pos = j;
                    }
                }else{
                    temp[i][j] = 0;
                }
            }
        }
        System.out.println("最大长度为：" + maxLength);
        System.out.println("所在的列为：" + pos);

        String result = s2.substring(pos - maxLength, pos);
        System.out.println(result);
        return "";
    }

    public static void main(String[] args) {
        findLongestCommonSubString("bab", "caba");
    }
}
