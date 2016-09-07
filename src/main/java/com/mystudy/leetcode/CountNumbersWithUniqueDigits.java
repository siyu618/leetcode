package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/9/4.
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {return 1;}
        else if (n == 1) {return 10;}
        else if (n == 2) {return 91;}
        else if (n >= 10) {n = 10;}
        int res = 91;
        int pre = 81;
        for (int i = 3; i <= n; i ++) {
            pre = pre * (11 - i);
            res += pre;
        }
        return res;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {return 1;}
        else if (n == 1) {return 10;}
        if (n>10) {
            n = 10;
        }
        int res = 1;
        for (int len = 1; len <= n; len ++) {
            boolean[] used = new boolean[10];
            int[] digits = new int[len + 1];
            int index = 0;
            res += dfs(len, index, digits, used);
        }
        return res;
    }

    public int dfs(int n, int index, int[] digits, boolean[] used) {
        if (index >= n) {
            return 1;
        }
        int startNum = 0;
        if (index == 0) {startNum = 1;}
        int res = 0;
        for (int i = startNum; i < 10; i ++) {
            if (!used[i]) {
                used[i] = true;
                digits[index] = i;
                res += dfs(n, index + 1, digits, used);
                used[i] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();
        for (int i = 0; i < 20; i ++) {
            System.out.println(i + ":" + test.countNumbersWithUniqueDigits(i) + ":" + test.countNumbersWithUniqueDigits2(i));
        }
    }
}