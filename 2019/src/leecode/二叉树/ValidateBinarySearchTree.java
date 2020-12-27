package leecode.二叉树;

/**
 * @author wangxi created on 2020/12/27 10:27
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
 *
 * 判断二叉搜索树，采用递归中序遍历来判断，因为BST的中序遍历一定是单调递增序列。
 * 如果单单利用 left.val < root.val < right.val 就会出现左子树的某一节点 > 右子树某一节点
 */
public class ValidateBinarySearchTree {
    boolean flag = true;
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        dfs(root);
        return flag;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 采用中序遍历
        dfs(root.left);
        if (!flag) {
            return;
        }
        if (pre == null) {
            pre = root;
        } else {
            if (pre.val >= root.val) {
                flag = false;
                return;
            }
            pre = root;
        }
        dfs(root.right);
    }
}
