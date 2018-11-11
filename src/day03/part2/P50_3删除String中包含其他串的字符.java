package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/4 0004 22:05
 */
public class P50_3删除String中包含其他串的字符 {
    /**
     * 删除str1中包含str2的字符
     * @param str1
     * @param str2
     * @return
     */
    public static String deleteCharacters(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        if ("".equals(str1) || "".equals(str2)) {
            return str1;
        }
        boolean[] temp = new boolean[128];
        System.out.println(temp[0]);
        for (int i = 0; i < str2.length(); i++) {
            temp[str2.charAt(i)] = true;
        }
        StringBuilder sb = new StringBuilder(str1);
        for (int i = 0; i < sb.length(); i++) {
            if (temp[sb.charAt(i)]) {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(deleteCharacters("We are Student", "aeiou"));
    }
}
