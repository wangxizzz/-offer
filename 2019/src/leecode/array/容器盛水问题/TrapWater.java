package leecode.array.容器盛水问题;

import java.util.Stack;

/**
 * @author wangxi created on 2021/3/6 18:43
 * @version v1.0
 *
 * 利用单调栈（具体是单调递减栈,并不是严格的单调递减，可以存在重复元素）
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
 */
public class TrapWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        // 存储元素的下标
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            // 构建单调递减栈
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIndex = stack.pop();
                while (!stack.isEmpty() && height[curIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackPeekIndex = stack.peek();
                    int width = i - stackPeekIndex - 1;
                    int h = Math.min(height[stackPeekIndex], height[i]) - height[curIndex];
                    result += width * h;
                }
            }
            stack.push(i);
        }
        return result;
    }

    // 返回long
    // https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=188&tqId=37528&rp=1&ru=%2Fta%2Fjob-code-high-week&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
    public long trap1(int[] height) {
        if (height == null || height.length <= 0) {
            return 0L;
        }
        // 存储元素的下标
        Stack<Integer> stack = new Stack<>();
        long result = 0L;
        for (int i = 0; i < height.length; i++) {
            // 构建单调递减栈
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIndex = stack.pop();
                while (!stack.isEmpty() && height[curIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackPeekIndex = stack.peek();
                    int width = i - stackPeekIndex - 1;
                    int h = Math.min(height[stackPeekIndex], height[i]) - height[curIndex];
                    // int * int 类型是int类型，即使使用long型元素接收，需要强转才有效
                    long temp = (long)width * h;
                    result = result + temp;
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // 测试int * int 类型的溢出
        int a = 1234556677;
        int b = 1234556677;
        long c = a * b;
        long d = (long)a * b;
        System.out.println(c);

        System.out.println(d);
    }
}
