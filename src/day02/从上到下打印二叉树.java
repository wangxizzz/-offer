package day02;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:王喜
 * @Description :面试32
 * @Date: 2018/4/14 0014 21:03
 */
public class 从上到下打印二叉树 {

    public static void printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.remove();
            System.out.println(temp.val);
            if (temp.left != null) {
                nodeQueue.add(temp.left);
            }
            if (temp.right != null) {
                nodeQueue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        printFromTopToBottom(root);
    }
}
