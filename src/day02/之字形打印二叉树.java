package day02;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author:王喜
 * @Description :面试32 三   使用两个栈存储
 * @Date: 2018/4/14 0014 21:58
 */
public class 之字形打印二叉树 {

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        //偶数层节点的栈
        Stack<TreeNode> s1 = new Stack<>();
        //奇数层节点的栈
        Stack<TreeNode> s2 = new Stack<>();
        s2.add(root);
        int level = 1;
        while (!s1.isEmpty() || !s2.isEmpty()) {
           if (level % 2 == 0) {
               while (!s1.isEmpty()) {
                   TreeNode temp = s1.pop();
                   System.out.print(temp.val + "   ");
                   if (temp.right != null) {
                       s2.push(temp.right);
                   }
                   if (temp.left != null) {
                       s2.push(temp.left);
                   }
               }
               System.out.println();
           } else {
              while (!s2.isEmpty()) {
                  TreeNode temp = s2.pop();
                  System.out.print(temp.val + "   ");
                  if (temp.left != null) {
                      s1.push(temp.left);
                  }
                  if (temp.right != null) {
                      s1.push(temp.right);
                  }
              }
               System.out.println();
           }
           level++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        print(root);
    }
}
