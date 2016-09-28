package com.mystudy.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 16/9/27.
 */
public class IntegerBreak {
    static int max(List<Integer> list) {
        int res = list.get(0);
        for (int i : list) {
            res = Math.max(res, i);
        }
        return res;
    }

    static public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1, k = i - j; j <= k; j++, k--) {
                dp[i] = max(Arrays.asList(dp[i],dp[j] * dp[k], j * k, j * dp[k], dp[j]*k));
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        for (int i : Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 10)) {
            System.out.println(integerBreak(i));
        }
    }
}
