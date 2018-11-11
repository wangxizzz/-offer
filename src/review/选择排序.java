package review;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/14 0014 22:52
 */
public class 选择排序 {

    public static void f1(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int min = num[0];
            int l = i;  //l初始化为每个范围的头元素。以防万一下面的if判断没有进去
            for (int j = i; j < num.length; j++) {
                if (num[j] < min) {
                    min = num[j];
                    l = j;
                }
            }
            num[l] = num[i];
            num[i] = min;
        }
    }

    public static void main(String[] args) {

    }
}
