package day03.part1;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/20 0020 21:59
 */
public class P4递增二维数组找数 {
    /**
     * 时间复杂度O(n)，每比较一次淘汰一行或一列。比较n次，就相当于找到了。
     * @param num
     * @param val
     * @return
     */
    public static boolean find(int[][] num, int val) {
        if (num == null || num.length <= 0) {
            return false;
        }
        boolean flag = false;
        int i = 0;
        int j = num[i].length - 1;
        while (i < num.length && j >= 0) {
            if (num[i][j] > val) {
                j--;
            } else if (num[i][j] < val) {
                i++;
            }else {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 对每一行进行折半查找，时间O(nlongn)
     * @param num
     * @param val
     * @return
     */
    public static boolean find2(int[][] num, int val) {
        //鲁棒性
        for (int i = 0; i < num.length; i++) {
            int p = 0;
            int q = num[i].length - 1;
            while (p <= q) {
                int mid = (p + q) / 2;
                if (num[i][mid] == val) {
                    return true;
                }else if (num[i][mid] > val) {
                    q = mid - 1;
                } else {
                    p = mid + 1;
                }
            }
        }
        return false;
    }
    //还有就是for循环遍历O(n*m)

    public static void main(String[] args) {
        int[][] num = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(num, 72));
        System.out.println(find2(num, 42));
    }
}
