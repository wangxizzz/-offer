package test;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/9/6 0006 22:38
 */
public class 函数split测试 {

    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String[] nums =s.split("\\:");
        System.out.println(Arrays.toString(nums));
        String s1 = "172.16.254.1";
        String[] nums1 = s1.split("\\.");
        System.out.println(Arrays.toString(nums1));
    }
}
