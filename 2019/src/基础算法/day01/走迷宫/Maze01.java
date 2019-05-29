package 基础算法.day01.走迷宫;

import java.util.*;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Maze01 {
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
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        int[][] steps = new int[row][col];
        helper(q, nums, steps);
    }

    private static void helper(Queue<Point> q, int[][] nums, int[][] steps) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == nums.length - 1 && cur.y == nums[0].length - 1) {
                break;
            }
            for (Point dir : dirs) {
                Point next = add(cur, dir);

            }
        }
    }

    public static Point add(Point cur, Point dir) {
        return new Point(cur.x + dir.x, cur.y + dir.y);
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

