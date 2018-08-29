package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/8/22.
 */
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];

        int res = 0;
        for (int i = 0; i < len; i ++) {
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nusm = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(nusm));
    }
}
