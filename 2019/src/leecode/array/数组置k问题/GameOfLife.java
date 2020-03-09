package leecode.array.数组置k问题;

/**
 * @Author wangxi
 * @Time 2020/3/9 10:17
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbor = getNeighbor(board, i, j);
                if (board[i][j] == 1) {
                    // 本来就是存活，那么下一代置为3
                    if (neighbor == 2 || neighbor == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    // 死而复生，置为2
                    if (neighbor == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int getNeighbor(int[][] board, int row, int col) {
        int result = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    result += board[i][j] & 1;
                }
            }
        }
        result -= board[row][col] & 1;
        return result;
    }
}
