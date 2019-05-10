package com.mystudy.leetcode.leetcode2;

public class OnesAndZeroes474 {

    private int countOne(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '1') {
                res  ++;
            }
        }
        return res;
    }
    private int[][] genLens(String[] strs) {
        int[][] lens = new int[strs.length][2];
        for (int i = 0; i < strs.length; i ++) {
            lens[i][1] = countOne(strs[i]);
            lens[i][0] = strs[i].length() - lens[i][1] ;
        }
        return lens;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        if (null == strs || strs.length == 0) {
            return 0;
        }

        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        int[][] lens = genLens(strs);

        int res = 0;
        for (int i = 1; i <= len; i ++) {
            for (int j = 0; j <= m; j ++) {
                for (int k = 0; k <= n; k ++) {
                    if (lens[i-1][0] <= j && lens[i-1][1] <= k) {
                        dp[i][j][k] = Math.max(dp[i-1][j-lens[i-1][0]][k-lens[i-1][1]] + 1, dp[i-1][j][k]);
                    }
                    else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                    res = Math.max(res, dp[i][j][k]);
                }
            }
        }
        return res;
    }

    public static void main(String... args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;


        String[] strs2 = {"10","0", "1"};
        int m2 = 1;
        int n2 = 1;
        System.out.println(new OnesAndZeroes474().findMaxForm(strs2, m2, n2));
    }
}
