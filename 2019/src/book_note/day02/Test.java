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
        List<String> list = new ArrayList<>();
        String s = "abc";
        list.add(s);
        String ss = s;
        s = s + 'g';
        System.out.println(ss);
        System.out.println(list);

        new Test().permutation("abc");
    }


    public String[] permutation(String s) {
        if (s == null || s.length() <= 0) {
            String[] error = new String[0];
            return error;
        }
        List<String> list = new ArrayList<>();
        int len = list.size();
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs(String s, List<String> list, String str) {
        if (str.length() == s.length()) {
            String ss = str;
            list.add(ss);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (str.contains(c + "")) {
                continue;
            }
            dfs(s, list, str + c);
        }
    }
}

