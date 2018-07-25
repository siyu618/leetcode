package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 18/7/6.
 */
public class StickersToSpellWord691 {
    public int minStickers(String[] stickers, String target) {
        int len = target.length();
        int m = 1 << len;
        int[] dp = new int[m];
        dp[0] = 0;
        for (int i = 1; i < m; i ++) {
            dp[i] = -1;
        }

        for (int i = 0; i < m; i ++) {
            if (dp[i] == -1) { continue;}
            for (String sticker : stickers) {
                int curState = i;
                for (char ch : sticker.toCharArray()) {
                    for (int j = 0; j < len; j ++) {
                        if (target.charAt(j) == ch && ((curState>>j) & 1) == 0) {
                            curState |= (1<<j);
                            break;
                        }
                    }
                }
                if (dp[curState] == -1 || dp[curState] > dp[i] + 1) {
                    dp[curState] = dp[i] + 1;
                }
            }

        }

        return dp[m-1];

    }

    public static void main(String...args) {
        String[] arr = new String[]{"with","example","science"};
        String target  = "thehat";
        System.out.println(new StickersToSpellWord691().minStickers(arr, target));
    }
}
