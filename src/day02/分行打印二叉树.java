package day02;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:王喜
 * @Description :面试32 二
 * @Date: 2018/4/14 0014 21:16
 */
public class 分行打印二叉树 {

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int toBePrint = 1;
        int temp = 0;  //代表每一层节点的个数
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.remove();
            toBePrint--;
            System.out.print(tempNode.val + "   ");
            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
                temp++;
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
                temp++;
            }
            if (toBePrint == 0) {
                toBePrint = temp;
                temp = 0;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        print(root);
    }
}
