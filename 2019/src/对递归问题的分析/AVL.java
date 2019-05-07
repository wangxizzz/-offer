package 对递归问题的分析;

import util.TreeNode;

/**
 * <Description>
 *
 * @author wangxi
 */
public class AVL {
    public static void main(String[] args) {
        TreeNode F = new TreeNode("E", null, null);
        TreeNode E = new TreeNode("E", null, null);
        TreeNode D = new TreeNode("D", null, E);
        TreeNode B = new TreeNode("B", null, D);
        TreeNode C = new TreeNode("C", null, F);
        TreeNode root = new TreeNode("A", B, C);

        System.out.println(isBalanced(root));
    }
    private static boolean flag = true;
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return flag;
    }
    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 增加递归退出条件，需要放在递归的前面，可以防止无畏的递归。只要找到一个false就可以退出
        if (flag == false) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
            return 0;
        }
        System.out.println(root.val);
        return (left > right) ? (left + 1) : (right + 1);
    }
}

