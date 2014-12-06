package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-11-21.
 */
public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        if (nRows >= s.length() || nRows < 2) {return  s;}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            int j = i;
            if (i == 0 || i == nRows - 1) {
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += 2 * nRows - 2;
                }
            }
            else {
                int step = 0;
                int stepWidth;
                while (j < s.length()) {
                    if (step % 2 == 0) {
                        stepWidth = 2 * (nRows - 1 - i);
                    }
                    else {
                        stepWidth = 2 * i;
                    }
                    step ++;
                    sb.append(s.charAt(j));
                    j += stepWidth;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        char[] a = new char[4];
        int tmp = a[3];
        System.out.println(tmp);
        System.out.println(ZigZagConversion.convert("abcdefghij", 4));
    }
}
