package com.mystudy.leetcode.leetcode2;

public class LongPressedName925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }

        int row = name.length();
        int col = typed.length();
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        boolean[][] dp = new boolean[row+1][col+1];
        dp[0][0] = true;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (i > j) {
                    continue;
                }
                if (name.charAt(i) == typed.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] ||  (dp[i+1][j] && typed.charAt(j) == typed.charAt(j-1)) ;
                }
                else {
                    dp[i+1][j+1] = (dp[i+1][j] && typed.charAt(j) == typed.charAt(j-1));
                }
            }
        }
        return dp[row][col];


    }

    public static void main(String... args) {
        String name = "alex";
        String typed = "aaleex";
        System.out.println(new LongPressedName925().isLongPressedName(name, typed));
    }
}
