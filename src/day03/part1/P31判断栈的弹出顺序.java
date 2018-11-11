package day03.part1;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description : 判断一个栈的弹出序列是否正确
 * @Date: 2018/5/31 0031 19:31
 */
public class P31判断栈的弹出顺序 {
    /**
     * 需要创建一个辅助栈   这个算法适用于压入栈有重复的元素。
     * @param popNum 需要判断的出栈序列
     * @param pushNum 给定的进栈序列
     * @return
     */
    public static boolean isCorrectOrder(int[] popNum, int[] pushNum) {
        if (popNum == null || pushNum == null || popNum.length <= 0 || pushNum.length <= 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < popNum.length; i++) {
            while (stack.isEmpty() || stack.peek() != popNum[i]) {
                if (start >= pushNum.length) {
                    return false;
                }
                stack.push(pushNum[start++]);
            }
            //为下一次不进栈作比较
            if (stack.peek() != popNum[i]) {
                return false;
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushNum = {1,2,3,4,5,5};
        int[] popNum1 = {4,5,5,3,2,1};
        int[] popNum2 = {4,3,5,1,2,5};   //注意，题目说的出栈一定是完整的出栈序列，但不一定正确。
        int[] popNum3 = {5,4,3,2,1,5};
        System.out.println(isCorrectOrder(popNum1, pushNum));
        System.out.println(isCorrectOrder(popNum2, pushNum));
        System.out.println(isCorrectOrder(popNum3, pushNum));
    }
}
