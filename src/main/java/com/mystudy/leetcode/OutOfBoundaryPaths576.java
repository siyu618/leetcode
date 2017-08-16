package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 17/8/4.
 */
public class OutOfBoundaryPaths576 {
    public int findPaths(int m, int n, int N, int x, int y) {
        long[][][] dp = new long[N+1][m][n];
        int mod = 1000000000 + 7;

        for (int k = 1; k <= N; k ++) {
            for (int i  = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    long tmp = 0;
                    tmp += (i == 0) ? 1 : dp[k-1][i-1][j];
                    tmp += (j == 0) ? 1 : dp[k-1][i][j-1];
                    tmp += (i == m-1) ? 1 : dp[k-1][i+1][j];
                    tmp += (j == n-1) ? 1 : dp[k-1][i][j+1];
                    dp[k][i][j] = tmp % mod;
                }
            }
        }
        return (int)dp[N][x][y];
    }
}
