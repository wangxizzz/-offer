package day03.part1;

import util.TreeNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/31 0031 9:52
 */
public class P28对称二叉树 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }
    private static boolean isSymmetric(TreeNode left, TreeNode right) {
       if (left == null && right == null) {    //当只有一个根节点时
           return true;
       }
       if (left == null || right == null) {
           return false;
       }
       return (left.val == right.val) && (isSymmetric(left.left, right.right)) && (isSymmetric(left.right, right.left));
    }
}
