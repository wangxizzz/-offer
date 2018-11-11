package demos.二叉树的操作;

import com.sun.jndi.dns.DnsUrl;
import util.TreeNode;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/8 0008 20:38
 */
public class 后序遍历 {

    /**
     * 二叉树的后序遍历非递归算法 参考网址：https://blog.csdn.net/zhuqiuhui/article/details/51319165
     *
     后序遍历递归定义：先左子树，后右子树，再根节点。

     后序遍历的难点在于：需要判断上次访问的节点（打印的节点）是位于左子树，还是右子树。
         若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
         若是位于右子树，则直接访问根节点。
     */
    public static void postOrder(TreeNode root){
        if (root == null) {
            return;
        }
        // TODO 更多详细注释参考博客内容
        Stack<TreeNode> s = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVisitedNode = null;
        while (curNode != null) {
            s.push(curNode);
            curNode = curNode.left;
        }
        while (!s.isEmpty()) {    // 注意：这里不能加curNode != null ，否则报错
            curNode = s.pop();
            if (curNode.right != null && curNode.right != lastVisitedNode) {
                s.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    s.push(curNode);
                    curNode = curNode.left;
                }
            }else{
                System.out.print(curNode.val + " ");
                lastVisitedNode = curNode;
            }
        }
    }

    public static void postOrderRecursive(TreeNode root){
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode();
        postOrder(root);
        System.out.println();
        postOrderRecursive(root);
    }
}
