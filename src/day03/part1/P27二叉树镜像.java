package day03.part1;

import util.TreeNode;

/**
 * @Author: wangxi
 * @Description : 输入一个二叉树，输出它的镜像
 * @Date: 2018/5/30 0030 21:02
 */
public class P27二叉树镜像 {
    public static void getMirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            getMirror(root.left);
        }
        if (root.right != null) {
            getMirror(root.right);
        }
    }
}
