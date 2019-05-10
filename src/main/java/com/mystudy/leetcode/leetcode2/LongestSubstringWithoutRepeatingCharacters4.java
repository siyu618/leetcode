package com.mystudy.leetcode.leetcode2;

public class LongestSubstringWithoutRepeatingCharacters4 {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        boolean[] exists = new boolean[256];
        int left = 0;
        int right = 1;
        int res = 1;
        exists[s.charAt(0) - 0] = true;
        while (left <= right && right < s.length()) {
            char cr = s.charAt(right);
            if (!exists[cr - 0]) {
                res = Math.max(res, right - left + 1);
            }
            else {
                while (s.charAt(left) != cr) {
                    exists[s.charAt(left)-0] = false;
                    left ++;
                }
                exists[s.charAt(left)-0] = false;
                left ++;
            }
            exists[cr - 0] = true;
            right ++;
        }
        return res;
    }

    public static void main(String... ars) {
        LongestSubstringWithoutRepeatingCharacters4 test = new LongestSubstringWithoutRepeatingCharacters4();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}
