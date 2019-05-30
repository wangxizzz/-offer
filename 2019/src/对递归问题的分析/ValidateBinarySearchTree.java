package 对递归问题的分析;

import util.CreateIntegerTree;

/**
 * <Description>
 *
 * @author wangxi
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        String data = "1 2 null null null";
        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize(data);
        new ValidateBinarySearchTree().isValidBST(root);
    }
    private boolean flag = true;
    CreateIntegerTree.TreeNode pre = null;
    public boolean isValidBST(CreateIntegerTree.TreeNode root) {
        if (root == null) {
            return true;
        }

        dfs(root);
        return flag;
    }
    private void dfs(CreateIntegerTree.TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            if (root.val <= pre.val) {
                flag = false;
            }
        }
        if (!flag) {
            return;
        }
        pre = root;
        dfs(root.right);
    }
}

