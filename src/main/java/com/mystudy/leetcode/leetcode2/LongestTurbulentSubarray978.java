package com.mystudy.leetcode.leetcode2;

public class LongestTurbulentSubarray978 {
    public int maxTurbulenceSize(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        int len = A.length;

        int[] bs = new int[len];
        int[] sb = new int[len];


        for (int i = 0; i < len ; i ++) {
            bs[i] = 1;
            sb[i] = 1;
        }
        int res = 1;
        for (int i = 1; i < len; i ++) {
            if (((i+1)&1)==0) {
                if (A[i] > A[i-1]) {
                    bs[i] = 1;
                    sb[i] = sb[i-1] + 1;
                }
                else if (A[i] < A[i-1]){
                    bs[i] = bs[i-1] + 1;
                    sb[i] = 1;
                }
                else {
                    bs[i] = 1;
                    sb[i] = 1;
                }
            }
            else {
                if (A[i] < A[i-1]) {
                    bs[i] = 1;
                    sb[i] = sb[i-1] + 1;
                }
                else if (A[i] > A[i-1]){
                    bs[i] = bs[i-1] + 1;
                    sb[i] = 1;
                }
                else {
                    bs[i] = 1;
                    sb[i] = 1;
                }
            }
            res = Math.max(res, bs[i]);
            res = Math.max(res, sb[i]);
        }
        return res;

    }

    public static void main(String...args) {
        int[] nums = {0,1,1,0,1,0,1,1,0,0};
        System.out.println(new LongestTurbulentSubarray978().maxTurbulenceSize(nums));
    }
}
