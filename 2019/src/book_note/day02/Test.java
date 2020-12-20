package book_note.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Test {

    public static void main(String[] args) {
        new Test().reverseWords("the sky is blue");
    }


    public String reverseWords(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                int j = i;
                for (; j >= 0; j--) {
                    if (j > 0 && s.charAt(j - 1) == ' ') {
                        buffer.append(s.substring(j, i + 1)).append(" ");
                        i = j;
                        break;
                    }
                }
            }
        }
        return buffer.toString().trim();
    }
}

