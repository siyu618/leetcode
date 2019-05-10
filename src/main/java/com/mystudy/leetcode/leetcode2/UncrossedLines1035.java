package com.mystudy.leetcode.leetcode2;

public class UncrossedLines1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        if (null == A || null == B) {
            return 0;
        }
        int lenA = A.length;
        int lenB = B.length;
        if (lenA * lenB == 0) {
            return 0;
        }

        int[][] dp = new int[lenA+1][lenB+1];

        int max = 0;
        for (int i = 0; i < lenA; i ++) {
            for (int j = 0; j < lenB; j ++) {
                if (A[i] == B[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[lenA][lenB];

    }

    public static void main(String...args) {
        int[] A = {1,4,2};
        int[]  B = {1,2,4};
        System.out.println(new UncrossedLines1035().maxUncrossedLines(A, B));
    }
}
