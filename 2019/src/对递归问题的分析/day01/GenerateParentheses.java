package 对递归问题的分析.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangxi
 * @Time 2020/5/11 00:14
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        // 回溯法
        dfs(result, 0, 0, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, int n, String s) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }
        if (left < n) {
            dfs(result, left + 1, right, n, s + "(");
        }
        if (right < n) {
            dfs(result, left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {

    }
}
