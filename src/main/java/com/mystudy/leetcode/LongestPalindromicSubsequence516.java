package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 17/7/25.
 */
public class LongestPalindromicSubsequence516 {


    public int longestPalindromeSubseq(String str) {
        int len  = str.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len;  i ++) {
            dp[i][i] = 1;
        }
        for (int k = 1; k < len; k ++) {
            for (int i = 0, j = k; j < len; i ++, j ++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];

    }


    public int longestPalindromeSubseq2(String str) {
        int len  = str.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len;  i ++) {
            dp[i][i] = 1;
        }
        return help(str, dp, len,0, len-1);


    }

    private int help(String str, int[][] dp, int len, int left, int right) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = 1;
        }
        else if (left > right) {
            return 0;
        }
        else if  (str.charAt(left) == str.charAt(right)) {
            dp[left][right] = 2 + help(str, dp, len,left+ 1, right-1);
        }
        else {
            dp[left][right] = Math.max(help(str, dp, len,left+ 1, right), help(str, dp, len,left, right-1));
        }
        return dp[left][right];
    }
}
