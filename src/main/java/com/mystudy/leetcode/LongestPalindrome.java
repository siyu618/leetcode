package com.mystudy.leetcode;

import java.util.Scanner;

/**
 * Created by yidianadmin on 14-11-18.
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (null == s || s.isEmpty()) {return s;}
        int start=0, end=0;
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            // i is the middle
            int j = i-1, k = i+1;
            boolean found = false;
            for (; j>=0 && k < len; j --, k ++) {
                if (s.charAt(j) == s.charAt(k)) {found = true;}
                else {break;}
            }
            if (found && k-j-2>end-start) {
                start = j+1;
                end = k-1;
            }
            // i is the left middle
            found = false;
            j = i;
            k = i+1;
            for (; j>=0 && k < len; j --, k ++) {
                if (s.charAt(j) == s.charAt(k)) {found = true;}
                else {break;}
            }
            if (found && k-j-2>end-start) {
                start = j+1;
                end = k-1;
            }
            //
        }
        return s.substring(start, end+1);

    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str = s.nextLine();
        while (!str.isEmpty()) {
            String res = LongestPalindrome.longestPalindrome(str
            );
            System.out.println(res);
            str = s.nextLine();
        }
    }
}
