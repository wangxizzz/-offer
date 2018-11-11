package day02;


import java.util.Stack;

/**
 * @Author:王喜
 * @Description :面试34
 * @Date: 2018/4/15 0015 10:34
 */
public class 二叉树和的路径 {

    public static void findPath(Tree root, int sum) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        findPathHelp(root, sum, stack);
    }

    private static void findPathHelp(Tree root, int sum, Stack<Integer> stack) {
        if (root != null) {
            stack.push(root.val);
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            System.out.println("找到路径");
            for (int i : stack) {
                System.out.print(i + "  ");
            }
        }
        if (root.left != null) {
            findPathHelp(root.left, sum-root.val, stack);
        }
        if (root.right != null) {
            findPathHelp(root.right, sum-root.val, stack);
        }
        //回溯后出栈
        stack.pop();
    }

    public Tree create() {
        Tree node1 = new Tree(4, null, null);
        Tree node2 = new Tree(2, node1, null);
        Tree node3 = new Tree(3, null, null);
        Tree node4 = new Tree(1, node2, node3);
        return node4;
    }

    public static void main(String[] args) {
        二叉树和的路径 temp = new 二叉树和的路径();
        Tree root = temp.create();
        findPath(root,7);
    }

    class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }

        public Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


