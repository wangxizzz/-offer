package day03.part2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangxi
 * @Description : 参考网址：https://blog.csdn.net/baidu_26439387/article/details/53968938
 * @Date: 2018/6/23 0023 13:41
 */
public class P37序列化二叉树 {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "" + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deSerialize(String str){
        Queue<String> queue = new LinkedList<String>();
        String[] deals = str.split(",");
        for(int i = 0; i < deals.length; i++){
            queue.add(deals[i]);
        }
        TreeNode root = preOrder(queue);
        return root;

    }
    TreeNode preOrder(Queue<String> q){
        String deal = q.poll();
        if("#".equals(deal)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(deal));
        node.left = preOrder(q);
        node.right = preOrder(q);
        return node;
    }
}
