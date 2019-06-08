package 对递归问题的分析.day01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        new PalindromePartitioning().partition("aabbssdss");
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        process(s, result, new LinkedList<>());
        return result;
    }

    private void process(String s, List<List<String>> result, List<String> current) {
        if (s.isEmpty()) {
            result.add(new ArrayList<>(current));
            // 回退到上一级变量的值。
            return;
        }

        for (int i=1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isPalindrome(str)) {
                current.add(str);
                process(s.substring(i), result, current);
                current.remove(current.size()-1);
            }

        }
        // 方法结束，也会回退.递归回退，所有的变量也会回退到当初压入线程栈的变量值。
    }

    private boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }



}

