package 基础算法.day01.走迷宫;

import java.util.*;

/**
 * <Description>
 * case1:
 * 6 5
 * 0 1 0 0 0
 * 0 0 0 1 0
 * 0 1 0 1 0
 * 1 1 1 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * case2:
 * 6 5
 * 0 0 0 1 1
 * 1 1 0 1 1
 * 1 1 0 0 1
 * 1 1 1 0 1
 * 1 1 1 0 1
 * 1 1 1 0 0
 * case3:
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * @author wangxi
 * 参考网址：https://blog.csdn.net/wuhengde/article/details/18733927
 */
public class MazeByBFS {
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
        int[][] visited = new int[row][col];
        Stack<Point> path = new Stack<>();   // 用于输出路径
        helper(q, nums, visited, path);
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    private static Stack<String> result = new Stack<>();

    private static void helper(Queue<Point> q, int[][] nums, int[][] visited, Stack<Point> path) {
        int row = nums.length;
        int col = nums[0].length;
        Point head = new Point(0, 0, -1, -1, 0);
        q.offer(head);
        while (!q.isEmpty()) {
            Point point = q.poll();
            visited[point.x][point.y] = 1;
            // 把满足条件的节点全部放入栈中
            path.push(point);
            for (Point dir : dirs) {
                int newX = dir.x + point.x;
                int newY = dir.y + point.y;
                // 判断是否找到出口条件
                if (newX == row - 1 && newY == col - 1 && visited[newX][newY] == 0 && nums[newX][newY] == 0) {
                    // 打印路径
                    Point top = path.pop();
                   // System.out.println("走了" + top.step + 1 + "步出迷宫");
                   // System.out.println("打印路径：");
                    //System.out.println("(" + newX + "," + newY + ")"); // 出口节点
                    result.push("(" + newX + "," + newY + ")");
                    result.push("(" + top.x + "," + top.y + ")");
                   // System.out.println("(" + top.x + "," + top.y + ")");  // 倒数第二个节点
                    int preX = top.preX;
                    int preY = top.preY;
                    while (!path.isEmpty()) {
                        // 弹出倒数第三个节点
                        Point pre = path.pop();
                        if (pre.x == preX && pre.y == preY) {   //判断栈顶元素是否和当前节点的前一个节点的坐标相等
                            result.push("(" + pre.x + "," + pre.y + ")");
                            //System.out.println("(" + pre.x + "," + pre.y + ")");
                            preX = pre.preX;
                            preY = pre.preY;
                        }
                    }
                    // 找到路径
                    return;
                }
                // 把上下左右满足条件的点加入队列
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && nums[newX][newY] == 0 && visited[newX][newY] == 0) {
                    Point newPoint = new Point(newX, newY, point.x, point.y, point.step + 1);
                    q.offer(newPoint);
                }
            }
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
    }
}

