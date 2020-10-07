package leecode.array.递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxi created on 2020/10/7 21:18
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        generateParenthesis(res, "", 0, 0, n);
        return res;
    }
    private void dfsError(List<String> res, int n, int start, String s) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        // 深搜不是每个都是for循环，for循环的作用是获取根据下标获取数据或者string的字符元素
        for (int i = start; i < n; i++) {
            dfsError(res, n, start + 1, s + '(');
            dfsError(res, n, start + 1, s + ')');
        }
    }

    private void generateParenthesis(List<String> result, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (open < n) {
            generateParenthesis(result, str + "(", open + 1, close, n);
        }
        if (close < open) {
            generateParenthesis(result, str + ")", open, close + 1, n);
        }
        // 调式专用代码
        int s = 123;
    }

    public static void main(String[] args) {
        GenerateParenthesis o = new GenerateParenthesis();
        o.generateParenthesis(3);
    }
}
