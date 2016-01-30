package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/10/19.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {return false;}
        if (s1.length() + s2.length() != s3.length()) { return false;}
        if (s1.length() == 0) {return s2.equals(s3);}
        if (s2.length() == 0) {return s1.equals(s3);}
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        boolean[][] match = new boolean[ch2.length+1][ch1.length+1];
        match[0][0] = true;
        for (int j = 0; j < ch1.length; j ++) {
            match[0][j+1] = match[0][j] && (ch1[j] == ch3[j]);
        }
        for (int i = 0; i < ch2.length; i ++) {
            match[i+1][0] = match[i][0] && (ch2[i] == ch3[i]);
        }
        for (int i = 1; i <= ch2.length; i ++) {
            for (int j = 1; j <= ch1.length; j ++) {
                int k = i + j;
                match[i][j] = match[i][j] || (ch1[j-1] == ch3[k-1] && match[i][j-1]);
                match[i][j] = match[i][j] || (ch2[i-1] == ch3[k-1] && match[i-1][j]);
            }
        }
        return match[ch2.length][ch1.length];
    }

    public static void main(String[] args) {
        InterleavingString interleavingString= new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
