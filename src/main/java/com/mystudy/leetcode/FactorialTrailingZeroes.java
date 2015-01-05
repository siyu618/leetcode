package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-3.
 */
public class FactorialTrailingZeroes {
    public int countFive(int n) {
        int count = 0;
        while (n>=5) {
            n/=5;
            count += n;
        }
        return count;
    }
    public int trailingZeroes(int n) {
        return countFive(n);
    }
}
