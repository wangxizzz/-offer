package util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <Description>
 *
 * @author wangxi
 */
public class CreateIntegerTree {
    public static class TreeNode {
       public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {
        String data = "1 2 3 n n 4 5 n n n n";
        System.out.println(deserialize(data).left);
    }
    // 利用BFS
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("n ");
                continue;
            }
            sb.append(temp.val + " ");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() <= 0) {
            return null;
        }
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int len = values.length;
        for (int i = 1; i < len; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            i = i + 1;
            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}


