package 对递归问题的分析;

import util.CreateIntegerTree;

/**
 * <Description>
 *
 * @author wangxi
 */
public class MaximumPathSum {
    int curSum = 0;
    int maxSum = 0;
    public static void main(String[] args) {
        String data = "1 2 3 null null null null";
        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize(data);
        System.out.println(new MaximumPathSum().maxPathSum(root));
    }

    public int maxPathSum(CreateIntegerTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum = root.val;
        return dfs(root);
    }
    private int dfs(CreateIntegerTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root.left);
        if (curSum <= 0) {
            curSum = root.val;
        } else {
            curSum += root.val;
        }

        if (curSum > maxSum) {
            maxSum = curSum;
        }
        dfs(root.right);
        return maxSum;
    }
}

