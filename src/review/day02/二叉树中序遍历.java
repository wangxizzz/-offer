package review.day02;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/28 0028 9:55
 */
public class 二叉树中序遍历 {
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode curNode = root;
        while (!s.isEmpty() || curNode != null) {
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.left;
            }
            curNode = s.pop();
            System.out.println(curNode.val);
            curNode = curNode.right;
        }
    }
}
