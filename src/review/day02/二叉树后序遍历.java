package review.day02;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/28 0028 9:54
 */
public class 二叉树后序遍历 {

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curNode = root;
        Stack<TreeNode> s = new Stack<>();
        TreeNode lastVisited = null;
        // 先把左节点进栈
        while (curNode != null) {
            s.push(curNode);
            curNode = curNode.left;
        }
        while (!s.isEmpty()) {
            curNode = s.pop();
            if (curNode.right != null && curNode.right != lastVisited) {
                s.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    s.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                System.out.println(curNode.val);
                lastVisited = curNode;
            }
        }
    }

    public static void postOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.println(root.val);
    }
}
