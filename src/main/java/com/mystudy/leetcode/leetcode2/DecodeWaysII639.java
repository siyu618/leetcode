package com.mystudy.leetcode.leetcode2;

public class DecodeWaysII639 {

    public int numDecodings(String s) {
        if (null == s || s.isEmpty() || s.indexOf("00") != -1) {
            return 0;
        }
        int N = s.length();
        char[] arr = s.toCharArray();
        long[] dp = new long[N + 1];

        if (arr[0] == '0') {
            return 0;
        }
        int MOD = 1000000007;
        dp[1] = arr[0] == '*' ? 9 : 1;
        dp[0] = 1;
        for (int i = 2; i <= N; i++) {
            char ch1 = arr[i - 2];
            char ch2 = arr[i - 1];
            // single
            if (ch2 == '*') {
                dp[i] = dp[i - 1] * 9;
            } else if (ch2 != '0') {
                dp[i] = dp[i - 1];
            }
            // double
            if (ch1 == '*') {
                if (ch2 == '*') {
                    dp[i] += dp[i - 2] * 15;
                } else if (ch2 >= '7') {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += dp[i - 2] * 2;
                }
            } else if (ch1 == '1') {
                if (ch2 == '*') {
                    dp[i] += dp[i - 2] * 9;
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (ch1 == '2') {
                if (ch2 == '*') {
                    dp[i] += dp[i - 2] * 6;
                } else if (ch2 < '7') {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= MOD;
        }
        return (int) dp[N];
    }

    public static void main(String... args) {
        System.out.println(new DecodeWaysII639().numDecodings("*10*1"));

        System.out.println(new DecodeWaysII639().numDecodings("1*72*"));
    }
}
