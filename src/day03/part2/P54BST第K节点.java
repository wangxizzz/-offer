package day03.part2;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :  参考网址：https://blog.csdn.net/ouyangyanlan/article/details/72876105
 * @Date: 2018/7/7 0007 20:40
 */
public class P54BST第K节点 {
    /**
     * 中序遍历，因为为BST，非递归算法
     * @param root
     * @param k
     * @return
     */
    public static TreeNode getKNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            count++;
            if (count == k) {
                return temp;
            }
            temp = temp.right;
        }
        return null;
    }
}
