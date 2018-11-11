package day03.part1;

/**
 * @Author:王喜
 * @Description :p81 对公司员工按照年龄进行排序
 *                抽象：对范围1 ~ 100的数组进行排序，数组为n，里面有大量重复的数字。
 * @Date: 2018/5/24 0024 16:10
 */
public class P10_2员工年龄排序 {

    /**
     * 时间O(n)，空间O(1)
     * @param age 存储员工年龄的数组
     *       此题不适合使用快排。因为数组中的元素的范围是1-100固定的范围
     */
    public static void sortByAge(int[] age) {
        if (age == null || age.length <= 0) {
            return;
        }
        //用一个数组来存储每个年龄存储的次数
        int[] timesOfAge = new int[100]; //年龄100以下
        for (int i = 0; i < age.length; i++) {
            if (age[i] >= 100 || age[i] < 0) {
                return;
            }
            int temp = age[i];
            timesOfAge[temp]++;  //对应年龄的位置+1
        }
        int index = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                age[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
