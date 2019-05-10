package 对递归问题的分析;

import util.CreateIntegerTree;

/**
 * <Description>
 *
 * @author wangxi
 */
public class PathSum {


public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

    public static void main(String[] args) {
        String data = "5 4 8 11 null 13 4 7 2 null null null 1 null null null null null null ";

        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize(data);
        System.out.println(root.left);

        System.out.println(new PathSum().hasPathSum(root, 22));
    }

    public boolean hasPathSum(CreateIntegerTree.TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum, sum);
    }
    private boolean helper(CreateIntegerTree.TreeNode root, int sum, int rest) {
        if (rest < 0) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (root.val == rest && root.left == null && root.right == null) {
            return true;
        }
        boolean l = helper(root.left, sum, rest - root.val);
        // 提前结束递归
        if (l) {
            return true;
        }
        boolean r = helper(root.right, sum, rest - root.val);
        // 左子树若为true，那么递归回退时，左子树始终为true
        return l || r;
    }
}

