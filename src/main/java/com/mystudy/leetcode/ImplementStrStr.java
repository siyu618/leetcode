package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-6.
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            for (int j = 0; j <= needle.length(); j ++) {
                if (j == needle.length()) {
                    return i;
                }
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }

        }
        return -1;
    }

    public static int[] genNext(String pattern) {
        if (null == pattern && pattern.isEmpty()) {
            return null;
        }
        int[] next = new int[pattern.length() + 1];
        int i = 0;
        int k = -1;
        next[0] = -1;
        while (i < pattern.length()) {
            if (k == -1 || pattern.charAt(i) == pattern.charAt(k)) {
                i ++;
                k ++;
                next[i] = k;
            }
            else
            {
                k = next[k];
            }
        }
        return next;
    }
    public static int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int[] next = genNext(needle);
        int i = 0, j = 0;
        for (; i < haystack.length();) {
            if (j == needle.length()) {break;}
            if (j == - 1||haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            }
            else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("12334", "34"));
        System.out.println(strStr2("12334", "34"));
    }
}
