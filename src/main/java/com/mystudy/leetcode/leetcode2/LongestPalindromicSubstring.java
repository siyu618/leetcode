package com.mystudy.leetcode.leetcode2;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i ++) {
            dp[i][i] = 1;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        for (int k = 2; k <= len; k ++) {
            for (int i = 0; i + k - 1 < len; i ++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (k == 2) {
                        dp[i][j] = 2;
                    }
                    else if (dp[i+1][j-1] > 0) {
                        dp[i][j] = Math.max(dp[i+1][j-1] + 2, dp[i][j]);
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    left = i;
                    right = j;
                }
            }
        }
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return s.substring(left, right + 1);

    }

    public static void main(String[] args) {
        String str = "bb";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome(str));
    }
}
