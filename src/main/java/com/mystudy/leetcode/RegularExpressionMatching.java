package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-2.
 */
public class RegularExpressionMatching {
    public static boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean matrix[][] = new boolean[s.length()+1][p.length()+1];
        matrix[0][0] = true;
        for (int i = 1; i <= s.length(); i ++) {matrix[i][0] = false;}
        for (int j = 1; j < p.length(); j ++) {
            if (j > 1 && p.charAt(j-1) == '*') {matrix[0][j] = matrix[0][j-2];}
            else {matrix[0][j] = false;}
        }
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    matrix[i][j] = matrix[i-1][j-1];
                }
                else if (p.charAt(j-1) == '*' && (j>1)) {
                    // match x* => , x* => 0, x* => xx
                    boolean match = false;
                    match = match || matrix[i][j-2]; // 0
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') { //match 1
                        match = match || matrix[i][j-1] || matrix[i-1][j];
                    }
                    matrix[i][j] = match;

                }
            }
        }
        return matrix[s.length()][p.length()];
    }


    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public static boolean isMatch(char[] s, char[] p, int sIndex, int pIndex) {
        if (sIndex > s.length ||pIndex > p.length) {
            return false;
        }
        if (pIndex == p.length) {
            return s.length == sIndex;
        }
        if (sIndex == s.length) {
            if ((p.length - pIndex) % 2 == 0) {
                while (pIndex+1 < p.length) {
                   if(p[pIndex+1] == '*') {
                       pIndex += 2;
                   }
                   else {
                       return false;
                   }
                }
                return true;
            }else {
                return false;
            }
        }
        if ((pIndex + 1 < p.length && p[pIndex+1] != '*') || (pIndex + 1 == p.length)) {
            if (s[sIndex] == p[pIndex] || '.' == p[pIndex]) {
                return isMatch(s, p, sIndex + 1, pIndex + 1);
            }
            else {
                return false;
            }
        }
        else {
            if ((pIndex + 2 < p.length) &&  isMatch(s, p, sIndex, pIndex + 2)) {
                return true;
            } else {
                if (s[sIndex] == p[pIndex] || '.' == p[pIndex]) {
                    return isMatch(s, p, sIndex + 1, pIndex);
                }else {
                    return false;
                }

            }
        }


    }

    public static void main(String[] args) {
        System.out.println(isMatch("bb", ".bab"));// false
        System.out.println(isMatch("ab", ".*c"));// false
        System.out.println(isMatch("aa","a"));// false
        System.out.println(isMatch("aa","aa"));//true
        System.out.println(isMatch("aaa","aa"));//false
        System.out.println(isMatch("aa", "a*"));//true
        System.out.println(isMatch("aa", ".*"));//true
        System.out.println(isMatch("ab", ".*"));//true
        System.out.println(isMatch("aab", "c*a*b"));//true
    }
}
