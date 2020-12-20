package leecode.二叉树;

import util.CreateIntegerTree;

/**
 * @author wangxi created on 2020/12/20 22:33
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class KthLargest {

    public static void main(String[] args) {
        KthLargest obj = new KthLargest();
        CreateIntegerTree.TreeNode root = CreateIntegerTree
                .deserialize("5 3 6 2 4 null null 1 null null null null null");
        int res = obj.kthLargest(root, 3);
        System.out.println(res);
    }
    int result = -1;
    boolean flag = false;
    int count = 0;
    public int kthLargest(CreateIntegerTree.TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        count = k;
        dfs(root);
        return result;
    }

    private void dfs(CreateIntegerTree.TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        // k返回上一层是不能回退的。如果把k放在dfs方法参数上，返回上一层k值会回退。
        count--;
        if (flag) {
            return;
        }
        if (count == 0) {
            result = root.val;
            flag = true;
            return;
        }
        dfs(root.left);
    }
}
