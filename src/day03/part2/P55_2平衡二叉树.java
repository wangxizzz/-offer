package day03.part2;

/**
 * @Author: wangxi
 * @Description : 参考网址：https://blog.csdn.net/u014282557/article/details/72879108
 * @Date: 2018/7/7 0007 21:16
 */
public class P55_2平衡二叉树 {
    /*平衡二叉搜索树（Balanced Binary Tree）具有以下性质：

它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树*/


    static boolean isBalance = true;
    public static boolean isBalanceTreeNode(TreeNode root) {
        //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
        getHeight(root);
        return isBalance;
    }
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return (left > right) ? (left + 1) : (right + 1);   //得到遍历节点的高度
    }
}
