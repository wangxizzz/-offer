package 基础算法.day01.走迷宫;

import java.util.*;
/**
 * <Description>
 *
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
        helper(nums, visited, path);
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    private static Stack<String> result = new Stack<>();

    private static void helper(int[][] nums, int[][] visited, Stack<Point> path) {

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
    }
}

