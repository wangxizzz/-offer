package leecode.二叉树;

import util.CreateIntegerTree;

/**
 * @author wangxi created on 2020/12/27 00:10
 * @version v1.0
 */
public class PathSumIII {

    public static void main(String[] args) {
        PathSumIII obj = new PathSumIII();
        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize("1 null 2 null 3 null 4 null 5 null null");

        int i = obj.pathSum(root, 3);

        System.out.println(i);
    }

    int count = 0;
    public int pathSum(CreateIntegerTree.TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void dfs(CreateIntegerTree.TreeNode root, int sum) {
        if (root == null) {
            return ;
        }
        if (sum - root.val == 0) {
            count++;
            // 不能return,后面的节点之和可能为0
            //return;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
