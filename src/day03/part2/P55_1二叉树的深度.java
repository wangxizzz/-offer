package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 *     递归思想其实很简单，代码也清晰易懂，即左右子树的较高者加上1（root高度为1）即可。
 *      树的高度等价于从根节点到叶子节点的最长路径的长度。
 * @Date: 2018/7/7 0007 20:48
 */
public class P55_1二叉树的深度 {
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left,right;
        left = getHeight(root.left);
        right = getHeight(root.right);
        if (left > right) {    // 这种写法更加直观
            return left + 1;
        }
        return right + 1;
//        return (left > right) ? (left + 1) : (right + 1);
    }
}
