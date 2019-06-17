package 对递归问题的分析.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <Description>
 *
 * @author wangxi
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        new CourseScheduleII().findOrder(2, new int[][]{{1,0}});
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> s = new Stack<>();
        int[] visited = new int[numCourses];
        for (int i = 0 ; i < numCourses; i++) {
            if (!dfs(graph, i, s, visited)) {
                return new int[0];
            }
        }
        int size = s.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = s.pop();
        }
        return result;
    }
    // 0表示没拜访，1表示正在拜访，2表示访问过了
    // 参考网址：https://leetcode.com/problems/course-schedule-ii/discuss/301709/JAVA-%2BBFS-%2BDFS

    // TODO 总结数组中变量递归访问时变化：
    // TODO 数组分配在堆上，因此在任何一个方法里修改，都反映到底层的元素中的修改，不论递归回退。
    // TODO 可以参考NumberOfIslands
    private boolean dfs(List<List<Integer>> graph, int course, Stack<Integer> s, int[] visited) {
        if (visited[course] == 2) {
            return true;
        }
        visited[course] = 1;
        List<Integer> list = graph.get(course);
        for (int val : list) {
            if (visited[val] == 1) {
                return false;
            }
            if (visited[val] == 0) {
                if (!dfs(graph, val, s, visited)) {
                    return false;
                }
            }
        }
        visited[course] = 2;
        s.push(course);
        return true;
    }
}

