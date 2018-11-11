package review;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/24 0024 15:39
 */
public class QuickSort01 {

    public static int partition(int[] num, int start, int end) {
        int temp = num[start];
        int i = start;
        int j = end;
        while (i < j) {
            //从后面开始扫描
            while (i < j && num[j] >= temp) {
                j--;
            }
            num[i] = num[j];
            while (i < j && num[i] < temp) {
                i++;
            }
            num[j] = num[i];
        }
        num[j] = temp;
        return j;
    }

    public static void sort(int[] num, int start, int end) {
        if (num == null) {
            return;
        }
        if (start >= end) {
            return;
        }
        int index = partition(num, start, end);
        sort(num, start, index - 1);   //需要判断start与end的大小
        sort(num, index+ 1, end);
    }

    public static void main(String[] args) {
        int[] num = {3,4,2,6,9,1,0,4,10};
        sort(num, 0, num.length - 1);
        for (int i : num) {
            System.out.print(i + "  ");
        }
    }
}
