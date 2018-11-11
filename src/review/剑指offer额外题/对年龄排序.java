package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description :设置排序算法。要求时间O(n)，空间O(1)。对公司员工按照年龄排序。
 * @Date: 2018/8/10 0010 11:55
 */
public class 对年龄排序 {
    /**
     * 对公司员工按照年龄排序。
     * @param ages 输入的是公司员工的年龄。比如43,32,32,56,21,22,23,22,12.......然后排序
     *     可以根据年龄的限制建立数组
     */
    public static void sort(int[] ages){
        if (ages == null || ages.length <= 0) {
            return;
        }
        // 年龄0-99岁
        int[] timeOfAge = new int[100];
        for (int i = 0; i < ages.length; i++) {
            timeOfAge[ages[i]]++;
        }
        int index = 0;   // 要一个全局变量
        for (int i = 0; i < 100; i++) {    // 表示年龄
            for (int j = 0; j < timeOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }
}
