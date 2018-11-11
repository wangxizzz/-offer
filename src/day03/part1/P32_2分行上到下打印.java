package day03.part1;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/20 0020 15:18
 */
public class P32_2分行上到下打印 {

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int toBePrinted = 1;   //当前层需要打印的节点的数量
        int nextNodes = 0;    //下一层需要打印节点的数量
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.val + "  ");
            toBePrinted--;
            if (temp.left != null) {
                queue.add(temp.left);
                nextNodes++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextNodes++;
            }
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextNodes;
                nextNodes = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
