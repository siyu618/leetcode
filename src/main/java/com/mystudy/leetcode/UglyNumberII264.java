package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/8/7.
 */
public class UglyNumberII264 {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int curMax = 1;
        for (int i = 1; i < n;) {
            int t2 = nums[i2] * 2;
            int t3 = nums[i3] * 3;
            int t5 = nums[i5] * 5;
            int tmpMin = 0;
            if (t2 <= t3 && t2 <= t5) {
                i2 ++;
                tmpMin = t2;
            }
            else if (t3 <= t2 && t3 <= t5) {
                i3 ++;
                tmpMin = t3;
            }
            else {
                i5 ++;
                tmpMin = t5;
            }
            if (tmpMin <= curMax) {
                continue;
            }
            else {
                curMax = tmpMin;
                nums[i] = tmpMin;
                i ++;
            }
        }
        return nums[n-1];
    }

    public static void main(String...args) {
        System.out.println(new UglyNumberII264().nthUglyNumber(10));
    }
}
