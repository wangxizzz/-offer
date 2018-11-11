package day02;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/15 0015 22:54
 */
public class 合并两个有序的数组 {

    public static void mergeTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                //i++表示先用后加1
                result[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                result[k++] = nums2[j++];
            } else {
                result[k++] = nums1[i];
                result[k++] = nums1[i++];
                j++;
            }
        }
        while(i < length1) {
            result[k++] = nums1[i++];
        }
        while (j < length2) {
            result[k++] = nums2[j++];
        }
        for (int temp : result) {
            System.out.print(temp + "   ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,3,4,5,6};
        mergeTwoSortedArray(nums1, nums2);
    }
}
