package 对递归问题的分析.day01;

import util.CreateIntegerTree;

/**
 * <Description>
 *
 * @author wangxi
 */
public class PathSum {

    public int age;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

    public static void main(String[] args) {
        String data = "5 4 8 11 null 13 4 7 2 null null null 1 null null null null null null ";

        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize(data);
        System.out.println(root.left);

        System.out.println(new PathSum().hasPathSum(root, 22));

//        PathSum s1 = new PathSum();
//        s1.age = 100;
//        // s2与s1指向同一块内存区域
//        PathSum s2 = s1;
//        s2.age = 33;
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println(s1.age);
    }

    public boolean hasPathSum(CreateIntegerTree.TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum, sum);
    }
    private boolean helper(CreateIntegerTree.TreeNode root, int sum, int rest) {
        // 考虑sum题目给负数的情况
//        if (rest < 0) {
//            return false;
//        }
        if (root == null) {
            return false;
        }
        if (root.val == rest && root.left == null && root.right == null) {
            return true;
        }
        // 这种情况是节点已经是下一个节点，但是rest减去的仍然是当前节点的值，
        // 那么这个情况，就需要判断rest是否和叶子节点相等了，不能用rest等于0来判断。
        boolean l = helper(root.left, sum, rest - root.val);
        // 提前结束递归，不让它进入右子树
        if (l) {
            return true;
        }
        boolean r = helper(root.right, sum, rest - root.val);
        // 左子树若为true，那么递归回退时，左子树始终为true
        return l || r;
    }
}

