package com.mystudy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yidianadmin on 15-3-6.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S.isEmpty() || T.isEmpty()) {
            return  "";
        }
        int nNotMatched = 0;

        int[] required = new int[256];
        int[] real = new int[256];
        for (int i = 0; i < 256; i++) {
            required[i] = -1;
            real[i] = 0;
        }
        for (byte b : T.getBytes()) {
            int i = (int)b;
            if (required[i] == -1) {
                required[i] = 1;
            }
            else {
                required[i] ++;
            }
            nNotMatched ++;
        }
        int left = 0;
        int right = 0;
        String res = "";
        while (left <S.length() && right < S.length()) {
            while (right < S.length() && nNotMatched > 0) {
                int ch = (int)S.charAt(right);
                if (required[ch] > 0) {
                    real[ch] ++;
                    if (real[ch] <= required[ch]) {
                        nNotMatched --;
                    }
                }
                right ++;
            }
            if (nNotMatched == 0) {
                String tmp = S.substring(left, right);
                if (res.equals("") || res.length() > tmp.length()) {
                    res = tmp;
                }
                while (left <= right && nNotMatched == 0) {
                    int ch = (int)S.charAt(left);

                    if (required[ch] > 0) {
                        real[ch] --;
                        if (real[ch] < required[ch]) {
                            nNotMatched++;
                        }
                    }
                        if (right-left < res.length()) {
                            res = S.substring(left, right);
                        }
                    left ++;
                }
                while (left < right) {
                    int ch = (int)S.charAt(left);
                    if (required[ch] == -1) {left ++;}
                    else {break;}
                }
            }
            else {
                break;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("bba", "ab"));

        System.out.println(minimumWindowSubstring.minWindow("aa", "aa"));
        System.out.println(minimumWindowSubstring.minWindow("ab", "b"));
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
