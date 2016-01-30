package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/10/19.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (null == s1 || null == s2) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        boolean match = true;
        for (int i = 0; i < len; i ++) {
            if (s1.charAt(i) == s2.charAt(len-i-1)) {
                continue;
            }
            else {
                match = false;
                break;
            }
        }
        if (match) {return true;}
        int[] count = new int[26];
        for(int i=0; i<len; i++)
        {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++)
        {
            if(count[i]!=0)
                return false;
        }

        for (int i = 1; i <= s1.length()-1; i ++) {
            if ( (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                    ||
                    (isScramble(s1.substring(0, i), s2.substring(len - i))
                            && isScramble(s1.substring(i), s2.substring(0, len-i)))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
         ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("abc", "bca"));
        System.out.println(scrambleString.isScramble("great", "rgeat"));
        System.out.println(scrambleString.isScramble("great", "rgtae"));
        System.out.println(scrambleString.isScramble("great", "rgtae"));

    }
}
