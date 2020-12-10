package leecode.array.递归.二叉树;

import util.CreateIntegerTree;

/**
 * Author wangxi03
 * Date 2020/12/9 4:34 下午
 * Version 1.0
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public CreateIntegerTree.TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null || inorder.length <= 0) {
            return null;
        }
        int rootVal = preorder[0];
        CreateIntegerTree.TreeNode root = new CreateIntegerTree.TreeNode(rootVal);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                break;
            }
        }
        // 没有左子树
        if (i <= 0) {
            root.left = null;
        }
        // 有左子树
        else {
            int[] pre = new int[i];
            int[] in = new int[i];
            for (int j = 0; j < i; j++) {
                // 从0开始，随着指针移动
                pre[j] = preorder[j + 1];
            }
            for (int j = 0; j < i; j++) {
                in[j] = inorder[j];
            }
            root.left = buildTree(pre, in);
        }

        // 没有右子树
        if (i >= inorder.length - 1) {
            root.right = null;
        } else {
            int[] in = new int[inorder.length - i - 1];
            int[] pre = new int[in.length];
            for (int j = 0; j < in.length; j++) {
                // 指针需后移
                pre[j] = preorder[i + j + 1];
                in[j] = inorder[i + j + 1];
            }
            root.right = buildTree(pre, in);
        }
        return root;
    }
}
