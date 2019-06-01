package com.mystudy.leetcode.leetcode2;

public class MaxConsecutiveOnesIII1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int zeroCnt = 0;

        int len = A.length;
        int res = 0;
        while (right < len) {
            while (right < len && zeroCnt < K) {
                if (A[right] == 0 ) {
                    zeroCnt ++;
                }
                right ++;
            }
            while (right < len && A[right] == 1) {
                right ++;
            }
            res = Math.max(res, right - left);

            while (left < len && zeroCnt == K) {
                if (A[left] == 0) {
                    zeroCnt --;
                }
                left ++;
            }
            if (right == len) {
                break;
            }
        }
        return res;

    }

    public static void main(String ... args) {
        int[]  A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        System.out.println(new MaxConsecutiveOnesIII1004().longestOnes(A, K));
    }
}
