package 对递归问题的分析.day01;

/**
 * <Description>
 *
 * @author wangxi
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] nums = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};

        new NumberOfIslands().numIslands(nums);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                dfs(grid, i, j, visited);
                result++;
            }
        }
        return result;
    }
    private void dfs(char[][] nums, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(nums, i - 1, j, visited);
        dfs(nums, i + 1, j, visited);
        dfs(nums, i, j - 1, visited);
        dfs(nums, i, j + 1, visited);
    }
}

