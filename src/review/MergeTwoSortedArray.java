package review;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/25 0025 21:35
 */
public class MergeTwoSortedArray {

    public static void mergeTwoSortedArray(int[] num1, int[] num2) {
        if (num1 == null || num2 == null) {
            return;
        }
        int i = 0;
        int j = 0;
        int[] result = new int[num1.length + num2.length];
        int k = 0;
        while (i < num1.length && j < num2.length) {  //小到大
            if (num1[i] <= num2[j] ) {
                result[k++] = num1[i++];
            } else {
                result[k++] = num2[j++];
            }
        }
        while (i < num1.length) {
            result[k++] = num1[i++];
        }
        while (j < num2.length) {
            result[k++] = num2[j++];
        }
        for (int a : result) {
            System.out.print(a + "   ");
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,7};
        int[] num2 = {2,3,4,5,5,5};
        mergeTwoSortedArray(num1, num2);
    }
}
