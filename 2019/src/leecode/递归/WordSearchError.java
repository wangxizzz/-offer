package leecode.递归;

/**
 * @Author wangxi
 * @Time 2019/12/1 17:07
 * https://leetcode.com/problems/word-search/
 */
public class WordSearchError {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0 || board[0].length <= 0 || word == null || word.length() <= 0) {
            return false;
        }
        int len1 = board.length;
        int len2 = board[0].length;
        boolean[][] flag = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (help(board, i, j, flag, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean help(char[][] nums, int i, int j, boolean[][] flag, String word, int index) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || flag[i][j] || word.charAt(index) != nums[i][j]) {
            return false;
        }
        flag[i][j] = true;
        if (index == word.length() - 1) {
            return true;
        }
        /**
         * 注意：index++表示 ：
         * index = index + 1;
         * help(nums, i + 1, j, flag, word, index)
         * 局部变量不是在递归的方法参数相加的，所以回退时，并不能回退到上个值
         */
        if (help(nums, i + 1, j, flag, word, index++) ||
                help(nums, i - 1, j, flag, word, index + 1) ||
                help(nums, i, j - 1, flag, word, index + 1) ||
                help(nums,i, j + 1, flag, word, index + 1)) {
            return true;
        }
        flag[i][j] = false;
        return false;
    }
}
