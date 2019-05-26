package 对递归问题的分析;

/**
 * <Description>
 *
 * @author wangxi
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        new WordSearch().exist(board, "ASFD");
    }
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, word, rows, cols, i, j, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, String word, int rows, int cols, int i, int j, int index, boolean[][] flag) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j]) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        flag[i][j] = true;
        if (exist(board, word, rows, cols, i + 1, j, index + 1, flag)
                || exist(board, word, rows, cols, i - 1, j, index + 1, flag)
                || exist(board, word, rows, cols, i, j + 1, index + 1, flag)
                || exist(board, word, rows, cols, i, j - 1, index + 1, flag)) {
            return true;
        }
        flag[i][j] = false;
        return false;
    }
}

