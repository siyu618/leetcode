package com.mystudy.leetcode.leetcode2;

public class MinimumCostToMergeStones1000 {
    public int mergeStones2(int[] stones, int K) {
        // REFER TO : https://blog.csdn.net/liuyh73/article/details/88642905
        // REFER TO : https://www.cnblogs.com/lz87/p/6949751.html
        if (null == stones || stones.length < 1) {
            return 0;
        }
        if ((stones.length - 1)%(K-1) != 0) {
            return -1;
        }
        int stonesLength = stones.length;
        int[] preSum = new int[stonesLength + 1];
        int[][] dp = new int[stonesLength][stonesLength];
        for (int i = 0; i < stonesLength; i ++) {
            preSum[i+1] = preSum[i] + stones[i];
        }

        for (int len = K; len <= stonesLength; len ++) {
            for (int i = 0; i + len - 1 < stonesLength; i ++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k += K-1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                }
                if ((j-i)%(K-1) == 0) {
                    dp[i][j] += preSum[j+1] - preSum[i];
                }
            }
        }

        return dp[0][stonesLength-1];

    }


    public int mergeStones(int[] stones, int K) {
        // REFER TO : https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1000-minimum-cost-to-merge-stones/
        if (null == stones || stones.length < 1) {
            return 0;
        }
        if ((stones.length - 1)%(K-1) != 0) {
            return -1;
        }
        final int INF = Integer.MAX_VALUE;
        int stonesLength = stones.length;
        int[] preSum = new int[stonesLength + 1];
        int[][][] dp = new int[stonesLength][stonesLength][K+1];
        for (int i = 0; i < stonesLength; i ++) {
            for (int j = 0; j < stonesLength; j ++) {
                for (int k = 0; k < K + 1; k ++) {
                    dp[i][j][k] = INF;
                }
            }
        }


        for (int i = 0; i < stonesLength; i ++) {
            preSum[i+1] = preSum[i] + stones[i];
            dp[i][i][1] = 0;
        }

        for (int len = 2; len <= stonesLength; len ++) {
            for (int i = 0; i + len - 1 < stonesLength; i ++) { // start
                int j = i + len - 1; // end
                for (int k = 2; k <= K; k ++) { // split into k piles
                    for (int m = i; m < j; m += K - 1) { // split point
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m+1][j][k-1]);
                    }
                }
                dp[i][j][1] = dp[i][j][K] + preSum[j+1] - preSum[i];
            }
        }

        return 0;

    }

}
