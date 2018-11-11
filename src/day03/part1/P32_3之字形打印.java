package day03.part1;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/20 0020 15:18
 */
public class P32_3之字形打印 {

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();  //存储奇数层节点
        Stack<TreeNode> stack2 = new Stack<>();  //存储偶数层节点
        stack1.push(root);
        int currentLevel = 1;  //表示当前的层
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (currentLevel % 2 == 0) {  //当前节点时偶数层
                while (!stack2.isEmpty()) {
                    TreeNode temp = stack2.pop();
                    System.out.print(temp.val + "  ");
                    if (temp.right != null) {   //子节点在奇数层
                        stack1.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack1.push(temp.left);
                    }
                }
            }else {
                while (!stack1.isEmpty()) {
                    TreeNode temp = stack1.pop();
                    System.out.print(temp.val + "  ");
                    if (temp.left != null) {
                        stack2.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack2.push(temp.right);
                    }
                }
            }
            System.out.println();
            currentLevel++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        print(root);
    }
}
