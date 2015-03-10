package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-3-10.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while ((n)!=0) {
            count ++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        int[] arr = {-1,2,0,11};
        for (int i : arr) {
            System.out.println(i + " " + numberOf1Bits.hammingWeight(i));
        }
    }
}
