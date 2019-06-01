package com.mystudy.leetcode.leetcode2;

import java.util.Arrays;

public class LongestStringChain1048 {
    private boolean isPredecessor(String a, String b) {
        if (a.length() + 1 != b.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i ++;
                j ++;
            }
            else {
                j ++;
            }
        }
        return i == a.length();

    }

    public int longestStrChain(String[] words) {
        if (null == words || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int len = words.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i ++) {
            dp[i] = 1;
        }
        int res = 1;

        for (int i = 0; i < len; i ++ ) {
            for (int j =  0; j < i; j ++) {
                String a = words[j];
                String b = words[i];
                if (isPredecessor(a, b)) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String...args) {
        String[] strs = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        System.out.println(new LongestStringChain1048().longestStrChain(strs));
    }
}
