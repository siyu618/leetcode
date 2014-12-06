package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-11-18.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int max(int x, int y) {
        if (x > y) {
            return x;
        }
        else {
            return y;
        }
    }
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int[] hash = new int[256];
        for (int i = 0; i < hash.length; i ++) {hash[i] = -1;};
        int maxLen = 0;
        int m = 0;
        for (int i = 0; i < s.length(); i ++) {
            m = max(m, hash[s.charAt(i)-'\0']+1);
            hash[s.charAt(i)-'\0'] = i;
            maxLen = max(maxLen, i-m+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "ababc";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    }
}
