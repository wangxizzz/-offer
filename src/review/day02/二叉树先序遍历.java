package review.day02;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/28 0028 9:54
 */
public class 二叉树先序遍历 {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode curNode = root;
        while (!s.isEmpty() || curNode != null) {
            while (curNode != null) {
                s.push(curNode);   // 为后面访问右节点需要用到
                System.out.println(curNode.val);
                curNode = curNode.left;
            }
            curNode = s.pop();
            curNode = curNode.right;
        }
    }
}
