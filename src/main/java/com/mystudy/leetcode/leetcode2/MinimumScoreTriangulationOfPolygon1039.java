package com.mystudy.leetcode.leetcode2;

public class MinimumScoreTriangulationOfPolygon1039 {
    public int minScoreTriangulation(int[] A) {
        if (null == A || A.length < 3) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len][len];
        for (int le = 1; le <= len; le ++) {
            for (int i = 0; i + le - 1< len; i ++) {
                int j = i + le - 1;
                if (le < 3) {
                    continue;
                }
                int tm = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k ++) {
                    tm = Math.min(tm, dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
                dp[i][j] = tm;
            }
        }
        return dp[0][len-1];
    }

    public static void main(String...args) {
        int nums[] = {1,2,3};
        System.out.println(new MinimumScoreTriangulationOfPolygon1039().minScoreTriangulation(nums));
    }


}
