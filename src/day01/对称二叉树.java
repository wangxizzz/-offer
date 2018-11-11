package day01;

import util.TreeNode;

/**
 * @Author:王喜
 * @Description :面试28
 * @Date: 2018/4/11 0011 14:05
 */
public class 对称二叉树 {
    public boolean isSymmertrical(TreeNode root) {
        if (root == null) {
            return false;
        }
       return compare(root.left, root.right);
    }
    private boolean compare(TreeNode lroot, TreeNode rroot) {
        if (lroot == null || rroot == null) {
            return false;
        }
        if (lroot == null && rroot == null) {
            return true;
        }
        //只要又不等的就return false，减少判断次数
        if (lroot.val != rroot.val) {
            return false;
        }
        return (compare(lroot.left, rroot.right)) && (compare(lroot.right, rroot.left));
    }
}
