package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 15/11/9.
 */
public class PalindromeNumber {
    public int getLength(int n) {
        int len = 0;
        if (n == 0) { return 1;}
        while( n != 0) {
            len ++;
            n /= 10;
        }
        return len;
    }
    public boolean isPalindrome(int x) {
        int len = getLength(x);
        int mid = len >> 1;
        int left = x;
        int right = x;
        int div = (int)(Math.pow(10, len-1));
        for (int i = 1; i <=mid; i++) {
            int l = left / div;
            int r = right % 10;
            if (l != r ) {
                return false;
            }
            left %=  div;
            right = right / 10;
            div /=10;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeNumber ob
                 = new PalindromeNumber();
        for (int i : Arrays.asList(0,2,-3,100,1001,10001)) {
            System.out.println(i + ":" + ob.isPalindrome(i));
        }
    }
}
