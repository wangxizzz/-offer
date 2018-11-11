package day03.part2;


import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description : 此题的路径是：根节点到叶子节点
 * @Date: 2018/6/22 0022 14:27
 */
public class P34和为某一值的路径 {

    public static Stack<Integer> stack = new Stack<>();

    public static void printPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int currentSum = 0;
        printPath(root, sum, currentSum, stack);
    }
    private static void printPath(TreeNode root, int sum, int currentSum, Stack<Integer> stack) {
        if (root != null) {
            stack.push(root.val);
            currentSum = currentSum + root.val;
            if ((root.left == null && root.right == null) && sum == currentSum) {
                for (int i : stack) {
                    System.out.print(i + "  ");
                }
                System.out.println();
            }
            if (root.left != null) {
                printPath(root.left, sum, currentSum, stack);
            }
            if (root.right != null) {
                printPath(root.right, sum, currentSum, stack);
            }
            //到了叶子节点需要弹出栈顶元素
            stack.pop();
        }
    }

    public static void main(String[] args) {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
