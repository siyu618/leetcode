package com.mystudy.leetcode.leetcode2;

public class LargestSumOfAverages813 {
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        int[] sum = new int[len+1];
        double[][] dp = new double[len][K];

        for (int i = 0; i < len; i ++) {
            sum[i+1] = sum[i] + A[i];
            dp[i][0] = sum[i+1] * 1.0 / (i+1);
        }

        for (int k = 1; k < K; k ++) {
            for (int i = 0; i < len; i ++) {
                for (int j = 0; j < i; j ++) {
                    dp[i][k] = Math.max(dp[i][k], (sum[i+1]-sum[j+1])*1.0/(i-j) + dp[j][k-1]);
                }
            }
        }
        return dp[len-1][K-1];
    }
    public double largestSumOfAverages2(int[] A, int K) {
        int len = A.length;
        int[] sum = new int[len+1];
        double[][] dp = new double[len][K];

        for (int i = 0; i < len; i ++) {
            sum[i+1] = sum[i] + A[i];
        }
        for (int i = 0; i < len; i ++) {
            dp[i][0] = (sum[len] - sum[i]) * 1.0 / (len-i);
        }

        for (int k = 1; k < K; k ++) {
            for (int i = 0; i + 1 < len; i ++) {
                for (int j = i + 1; j < len; j ++) {
                    dp[i][k] = Math.max(dp[i][k], (sum[j]-sum[i])*1.0/(j-i) + dp[j][k-1]);
                }
            }
        }
        return dp[0][K-1];
    }

    public static void main(String ... args) {
        int[] nums = {9,1,2,3,9};
        int k = 3;
        System.out.println(new LargestSumOfAverages813().largestSumOfAverages(nums, k));
    }
}
