package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Leetcode56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return new int[0][0];
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                result.add(intervals[0]);
                j++;
                continue;
            }
            int[] pre = result.get(j - 1);
            if (pre[1] >= intervals[i][0] && pre[1] < intervals[i][1]) {
                pre[1] = intervals[i][1];
                result.set(j - 1, pre);
            } else if (pre[1] < intervals[i][0]) {
                result.add(intervals[i]);
                j++;
            }
        }
        int[][] nums = new int[result.size()][];
        return result.toArray(nums);
    }
}

