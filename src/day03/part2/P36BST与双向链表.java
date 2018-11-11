package day03.part2;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description : 参考网址：https://blog.csdn.net/u013309870/article/details/70136132
 * @Date: 2018/6/23 0023 13:20
 */
public class P36BST与双向链表 {

    public static TreeNode convertToList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode preNode = null;
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();  //第一次是最左节点
            if (preNode == null) {
                root = curNode;    //最左节点当做链表的头结点
                preNode = curNode;  //初始化
            } else {
                preNode.right = curNode;
                curNode.left = preNode;
                preNode = curNode;
            }

            curNode = curNode.right;  //当前节点向右移动，可以看成链表向右移动
        }
        return root;
    }
}
