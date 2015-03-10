package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-3-10.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            if ((n&1) == 1) {
                res |= 1 << (31-i);
            }
            n >>= 1;
        }
        return res;

    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        int[] arr = {-1, 3, 43261596};
        for (int i : arr) {
            System.out.println(i + " " + reverseBits.reverseBits(i));
        }
    }


}
