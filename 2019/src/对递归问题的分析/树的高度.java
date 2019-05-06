package 对递归问题的分析;

import util.TreeNode;

/**
 * <Description>
 *
 * @author wangxi
 */
public class 树的高度 {
    public static void main(String[] args) {
        TreeNode D = new TreeNode("D", null, null);
        TreeNode B = new TreeNode("B", null, D);
        TreeNode C = new TreeNode("C", null, null);
        TreeNode root = new TreeNode("A", B, C);

        System.out.println(maxDepth(root));
    }
    // DFS
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

