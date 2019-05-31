package 基础算法.day01.走迷宫;

import java.util.*;
/**
 * <Description>
 测试case1:

5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
 * @author wangxi
 */
public class MazeByDFS {
    private static List<Point> dirs = new ArrayList<>();
    static {
        dirs.add(new Point(-1, 0));
        dirs.add(new Point(1, 0));
        dirs.add(new Point(0, -1));
        dirs.add(new Point(0, 1));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] mn = s.split(" ");
        int row = Integer.parseInt(mn[0]);
        int col = Integer.parseInt(mn[1]);
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = scanner.nextLine();
            String[] parts = str.split(" ");
            for (int j = 0; j < col; j++) {
                nums[i][j] = Integer.parseInt(parts[j]);
            }
        }
        int[][] visited = new int[row][col];
        Stack<Point> path = new Stack<>();   // 用于输出路径
        helper(nums, visited, path, 0, 0);
        System.out.println(path);
    }
    private static boolean flag = false;   // 是否找到结果的标志
    private static void helper(int[][] nums, int[][] visited, Stack<Point> path, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] == 1 || visited[i][j] == 1 || flag) {
            return;
        }
        path.push(new Point(i, j));
        visited[i][j] = 1;
        if (i == nums.length - 1 && j == nums[0].length - 1) {
            flag = true;
            return;
        }
        // 上、下、左、右
        helper(nums, visited, path, i - 1, j);
        helper(nums, visited, path, i + 1, j);
        helper(nums, visited, path, i, j - 1);
        helper(nums, visited, path, i, j + 1);
        // 结果找到了，就不出栈
        if (!flag) {
            path.pop();
            visited[i][j] = 0;
        }
    }

    private static class Point {
        int x;
        int y;
        int preX;   // 前一个节点X坐标
        int preY;   // 前一个节点Y坐标
        int step;   // 走的第几步
        public Point(int x, int y, int preX, int preY, int step) {
            this.x = x;
            this.y = y;
            this.preX = preX;
            this.preY = preY;
            this.step = step;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}

