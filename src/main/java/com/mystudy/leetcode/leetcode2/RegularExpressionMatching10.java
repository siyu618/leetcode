package com.mystudy.leetcode.leetcode2;

public class RegularExpressionMatching10 {

    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    private boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (j == p.length() - 1 || p.charAt(j+1) != '*') {
            if (i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')) {
                return false;
            }
            else {
                return helper(s, p, i + 1, j + 1);
            }
        }
        while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            if (helper(s, p, i, j + 2)) {
                return true;
            }
            i ++;
        }
        return helper(s, p, i, j + 2);
    }


    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        for (int i = 1; i <= m; i ++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; j ++) {
            dp[0][j] = j > 1 && '*' == pp[j-1] && dp[0][j-2];
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (pp[j-1] != '*') {
                    dp[i][j] =  dp[i-1][j-1] && (ss[i-1 ] == pp[j-1] || '.' == pp[j-1]);
                }
                else {
                    dp[i][j] = dp[i][j-2] || ((ss[i-1] == pp[j-2] || '.' == pp[j-2]) && dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
