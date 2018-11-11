package day03.part1;

/**
 * @Author: wangxi
 * @Description :  判断给定的序列是否是二叉搜索树的后序序列，
 *                 前提条件： 给定的数组元素是不重复的
 * @Date: 2018/6/20 0020 16:23
 */
public class P33_1BST后序序列 {

    /**
     *
     * @param num 给定的数组序列
     * @param start  开始值，比如0
     * @param end  表示最后一个元素的索引 ，比如num.length - 1
     * @return
     */
    public static boolean postOrder(int[] num, int start, int end) {
        if (num == null || num.length <= 0) {
            return false;
        }
        int root = num[end];
        //找出左子树
        int i = start;
        for (; i < end; i++) {  //不需要比较最后一个root
            if (num[i] > root) {
                break;
            }
        }
        //判断右子树节点
        for (int j = i; j < end; j++) {
            if (num[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > start) {   //表示有左子树
            left = postOrder(num, start, i - 1);
        }
        boolean right = true;
        if (i < end - 1) {  //注意是end - 1,根节点不是右子树
            right = postOrder(num, i, end - 1);
        }
        return (left && right);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] b= {4,7,5,6,12,10};
        System.out.println(postOrder(b, 0, b.length - 1));
        System.out.println(postOrder(a, 0, a.length - 1));
    }
}
