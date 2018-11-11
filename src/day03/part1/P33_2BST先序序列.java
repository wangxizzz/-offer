package day03.part1;


/**
 * @Author: wangxi
 * @Description : 前提条件：二叉排序树
 * @Date: 2018/6/20 0020 16:56
 */
public class P33_2BST先序序列 {
    /**
     * 判断一个元素不重复的int数组序列是否是正确的BST的先序遍历
     * @param num
     * @param start 起始值
     * @param end  最后一个元素下标
     * @return
     */
    public static boolean preOrder(int[] num, int start, int end) {
        if (num == null) {
            return false;
        }
        int root = num[start];
        int i = start + 1;
        for (; i <= end; i++) {
            if (num[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j <= end; j++) {
            if (num[j] < root) {
                return false;
            }
        }
        boolean left = true;
        //判断是否有左子树
        if (i > (start + 1)) {
            left = preOrder(num, start + 1, i - 1);
        }
        boolean right = true;
        if (i < (end + 1)) {
            right = preOrder(num, i, end);
        }

        return (left && right);
    }

    public static void main(String[] args) {
        int[] num = {10,5,4,7,12,15};
        System.out.println(preOrder(num, 0, num.length - 1));
    }

}
