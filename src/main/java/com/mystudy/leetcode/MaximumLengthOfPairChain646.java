package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 17/7/24.
 */
public class MaximumLengthOfPairChain646 {

    public int findLongestChain(int[][] pairs) {
        if (null == pairs || pairs.length < 2) {
            return 0;
        }
        int len = pairs.length;
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            else {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[len];

        for (int j = 0; j < len; j ++) {
            dp[j] = 1;
        }
        int max = 1;

        for (int i = 1; i < len; i ++) {
            for (int j =  0; j < i; j ++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arrs = {{1,2}, {2,3}, {3,4}};
        int[][] arr2 = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        System.out.println(new MaximumLengthOfPairChain646().findLongestChain(arr2));
        System.out.println(new MaximumLengthOfPairChain646().findLongestChain(arrs));
    }

}
