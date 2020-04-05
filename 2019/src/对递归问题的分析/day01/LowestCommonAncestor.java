package 对递归问题的分析.day01;

import util.CreateIntegerTree;

/**
 * @Author wangxi
 * @Time 2020/4/4 15:32
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        String data = "5 4 8 11 12 13 4 7 2 null null 5 1 null null null null null null null null";
        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize(data);
        CreateIntegerTree.TreeNode p = root.left.right;
        CreateIntegerTree.TreeNode q = root.left.left.left;
        CreateIntegerTree.TreeNode treeNode = new LowestCommonAncestor().lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }

    public CreateIntegerTree.TreeNode lowestCommonAncestor(CreateIntegerTree.TreeNode root, CreateIntegerTree.TreeNode p, CreateIntegerTree.TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        CreateIntegerTree.TreeNode left = lowestCommonAncestor(root.left, p, q);
        CreateIntegerTree.TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
