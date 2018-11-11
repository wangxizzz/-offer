package day03.part1;

/**
 * @Author: wangxi
 * @Description : BST中序序列是一个递增的数组
 * @Date: 2018/6/20 0020 16:57
 */
public class P33_3BST中序序列 {
    public static boolean UpSort(int a[]) {
        if (a == null || a.length <= 0) {
            return false;
        }
        if (a.length == 1) {
            return true;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1,0};
        System.out.println(UpSort(a));
    }
}

