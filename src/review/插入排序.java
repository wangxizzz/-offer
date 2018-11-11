package review;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/14 0014 22:40
 */
public class 插入排序 {

    public static void f1(int[] num) {
        if (num == null || num.length <= 0) {
            return;
        }
        int j = 0;
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            for (j = i; j > 0 && temp < num[j-1]; j--) {
                num[j] = num[j - 1];
            }
            num[j] = temp;
        }
    }

    public static void main(String[] args) {

    }
}
