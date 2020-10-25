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
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                res.add(intervals[i]);
                j++;
                continue;
            }
            int[] left = res.get(j - 1);
            int[] right = intervals[i];
            if (left[1] >= right[0] && left[1] <= right[1]) {
                left[1] = right[1];
            } else if (left[1] >= right[0] && left[1] >= right[1]) {
                continue;
            } else {
                res.add(intervals[i]);
                j++;
            }
        }
        int[][] resArr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}

