package day03.part1;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/20 0020 14:57
 */
public class P32_1上到下打印二叉树 {

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.val + "  ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        print(root);
    }
}
