package com.mystudy.leetcode.leetcode2;

public class NumberOfLongestIncreasingSubsequence673 {
    public int findNumberOfLIS(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m+1];
        int[] count = new int[m+1];
        for (int i = 0; i < m; i ++) {
            dp[i] = 1;
            count[i] = 1;
        }


        for (int j = 1; j < m; j ++) {
            for (int i = 0; i < j; i ++) {
                if (nums[i] < nums[j]) {
                    if (dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                        count[j] = count[i];
                    }
                    else if (dp[i] + 1 == dp[j]) {
                        count[j] += count[i];
                    }
                }
            }
        }
        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }

        int res = 0;
        for (int i = 0; i < m; i ++ ) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;


    }

    public static void main(String... args) {
        int[] nums = {1,2,3,1,2,3,1,2,3};
        System.out.println(new NumberOfLongestIncreasingSubsequence673().findNumberOfLIS(nums));
    }
}
