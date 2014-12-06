package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-1.
 */
public class LongestCommonPrefix {
    public static String commonPrefix(String stra, String strb) {
        int index = 0;
        int lenA = stra.length();
        int lenB = strb.length();
        StringBuilder sb = new StringBuilder();
        while (index < lenA && index < lenB) {
            if (stra.charAt(index) == strb.charAt(index)) {
                index ++;
            }
            else
            {
                break;
            }
        }
        return stra.substring(0, index);

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            common = commonPrefix(common, strs[i]);
        }
        return common;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            common = commonPrefix(common, strs[i]);
        }
        return common;
    }
}
