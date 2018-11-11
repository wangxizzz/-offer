package test;


import util.ListNode;

import java.util.*;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/11 0011 21:56
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(k);
        if (nums == null || nums.length <= 0) {
            return list;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> temp = new ArrayList<>(map.entrySet());
        Collections.sort(temp, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();  // 大到小排序
            }
        });
        for (int i = 0; i < k; i++) {
            int key = temp.get(i).getKey();
            list.add(key);
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        topKFrequent(nums, 2);
    }

}
