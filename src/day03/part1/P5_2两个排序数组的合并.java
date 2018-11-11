package day03.part1;

/**
 * @Author:王喜
 * @Description :两个排序数组的合并
 * @Date: 2018/5/21 0021 22:22
 */
public class P5_2两个排序数组的合并 {

    /**
     * 时间O(n),空间O(m+n)
     * @param num1 小到大
     * @param num2 小到大
     */
    public static void merge(int[] num1, int[] num2) {
        //鲁棒性的判断

        int[] result = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                result[k++] = num1[i++];
            }else if (num1[i] > num2[j]) {
                result[k++] = num2[j++];
            }else {
                result[k++] = num1[i++];
                result[k++] = num2[j++];
            }
        }
        while (i < num1.length) {
            result[k++] = num1[i++];
        }
        while (j < num2.length) {
            result[k++] = num2[j++];
        }
        int w = 0;
        for (int q : result) {
            w++;
            System.out.print(q + "  ");
        }
        System.out.println();
        System.out.println(w);
    }

    public static void main(String[] args) {
        int[] num1 = {3,6,8};
        int[] num2 = {2,5};
        merge(num1, num2);
    }
}
