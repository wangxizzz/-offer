package 对递归问题的分析.day01;

import util.CreateIntegerTree;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class PathSum2 {
    public static void main(String[] args) {
        String data = "5 4 8 11 null 13 4 7 2 null null 5 1 null null null null null null null null";
        CreateIntegerTree.TreeNode root = CreateIntegerTree.deserialize(data);
        System.out.println(new PathSum2().pathSum(root, 22));
    }


    public List<List<Integer>> pathSum(CreateIntegerTree.TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(root, result, new ArrayList<>(), sum, sum);
        return result;
    }
    private void pathSum(CreateIntegerTree.TreeNode root, List<List<Integer>> result, List<Integer> list, int sum, int rest) {
//        if (rest < 0) {
//            return;
//        }
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == rest && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
            // 如果没加这一步，那么会少弹出一个元素。
            list.remove(list.size() - 1);
            return;
        }
        pathSum(root.left, result, list, sum, rest - root.val);
        pathSum(root.right, result, list, sum, rest - root.val);
        list.remove(list.size() - 1);
    }
}

