package demos.二叉树的操作;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/8 0008 20:29
 */
public class 先序遍历 {
    /**
     * 二叉树的先序遍历非递归算法
     * @param root
     */
    public static void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !s.isEmpty()) {
            while (curNode != null) {
                s.push(curNode);
                System.out.print(curNode.val + " ");
                curNode = curNode.left;
            }
            if (!s.isEmpty()) {
                curNode = s.pop();
            }
            curNode = curNode.right;
        }
    }

    /**
     * 先序遍历的递归算法
     * @param root
     */
    public static void preOrderWithRecursive(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderWithRecursive(root.left);
        preOrderWithRecursive(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        preOrder(root);
        System.out.println();
        preOrderWithRecursive(root);
    }
}
