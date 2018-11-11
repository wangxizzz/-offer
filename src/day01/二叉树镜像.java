package day01;

import util.TreeNode;

/**
 * @Author:王喜
 * @Description :面试27
 * @Date: 2018/4/11 0011 13:30
 */
public class 二叉树镜像 {

    public static TreeNode mirrorBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //如果只有一个节点，直接返回
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = mirrorBinaryTree(root.right);
        root.right = mirrorBinaryTree(temp);
        return root;
    }

    public static void main(String[] args) {

    }
}
