package demos.二叉树的操作;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/8 0008 20:37
 */
public class 中序遍历 {
    /**
     * 二叉树的中序遍历非递归算法
     * @param root
     */
    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !s.isEmpty()) {
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.left;
            }
            if (!s.isEmpty()) {
                curNode = s.pop();
                System.out.print(curNode.val + " ");
            }
            curNode = curNode.right;
        }
    }

    public static void inOrderWithRecursive(TreeNode root){
        if (root == null) {
            return;
        }
        inOrderWithRecursive(root.left);
        System.out.print(root.val + " ");
        inOrderWithRecursive(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        inOrder(root);
        System.out.println();
        inOrderWithRecursive(root);
    }
}
