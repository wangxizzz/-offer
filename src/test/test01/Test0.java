package test.test01;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/9/1 0001 10:47
 */
public class Test0 {
    boolean flag = false;
    public boolean findPath(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int curSum = 0;
        findPath(root, target, s);
        return flag;
    }
    private void findPath(TreeNode root, int target, Stack<Integer> s) {
        if (root == null) {
            return;
        }
        s.push(root.val);
        //curSum += root.val;
        if (root.left == null && root.right == null) {

            flag = true;
        }
        if (root.left != null) {
            findPath(root.left, target, s);
        }
        if (root.right != null) {
            findPath(root.right, target, s);
        }
        s.pop();
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        val = val;
    }
}
