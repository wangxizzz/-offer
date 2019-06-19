package 基础算法.day01.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <Description>
 *作者：番茄焖鸡蛋
 * 链接：https://www.nowcoder.com/discuss/199361?type=0&order=0&pos=11&page=1
 * 来源：牛客网
 *
 * 【题目描述】我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕***孔连顺。和我一起行动的还有另外两名特工，我提议我们在字节跳动大街的N个建筑中选定3个埋伏地点。为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
 *
 * 我特喵是个天才！经过缜密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
 *
 * ......
 *
 * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了接跳动大街。只怪他的伪装太成功了，就算杨过本人来了也发现不了的！
 *
 * 请听题：给定N(可选做为埋伏点的建筑物数)、D(两两埋伏点直接最大距离)以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 *
 * 输入描述：
 * 第一行包含空格分隔的两个数字N和D（1<=N<=1000000;1<=D<=1000000）
 * 第二行包含N个建筑物的位置，每个位置用一个整数（取值区间为[0,1000000]）表示，从小打大排序
 * 输出描述：
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对99997867取模
 *
 * 输入样例1：
 * 4 3
 * 1 2 3 4
 * 输出样例1：
 * 4
 * PS：可选方案 (1,2,3,)，(1,2,4)，(1,3,4)，(2,3,4)
 * 输入样例2：
 * 5 19
 * 1 10 20 30 50
 * 输出样例2：
 * 1
 * PS：可选方案 (1,10,20)
 * @author wangxi
 */
// 题目本质是3个数的组合问题，加上一些剪枝条件。
public class Solution {
    private int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String NDs = scanner.nextLine();
        String[] ND = NDs.split(" ");
        int N = Integer.parseInt(ND[0]);
        int D = Integer.parseInt(ND[1]);
        String[] s = scanner.nextLine().split(" ");
        int len = s.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(new Solution().getResult(nums, D));
    }

    public int getResult(int[] nums, int distance) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        dfs(nums, new ArrayList<>(), 0, distance);
        return result;
    }

    private void dfs(int[] nums, List<Integer> list, int start, int distance) {
        if (list.size() == 3) {
            if (validate(list, distance)) {
                result++;
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, i + 1, distance);
            list.remove(list.size() - 1);
        }
    }

    private boolean validate(List<Integer> list, int distance) {
        int num1 = list.get(0);
        int num2 = list.get(1);
        int num3 = list.get(2);
        if (num2 - num1 > distance || num3 - num1 > distance || num3 - num2 > distance) {
            return false;
        }
        return true;
    }
}

