package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-5.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length < 3) {return 0;}
        int[] lMax = new int[A.length];
        int[] rMax = new int[A.length];
        lMax[0] = A[0];
        rMax[A.length-1] = A[A.length-1];
        for (int i = 1, j = A.length-2; i<A.length && j>=0; i++, j--) {
            lMax[i] = Math.max(lMax[i-1], A[i]);
            rMax[j] = Math.max(rMax[j+1], A[j]);
        }
        int res = 0;
        for (int i = 0; i < A.length; i ++) {
            res += Math.min(lMax[i], rMax[i]) - A[i];
        }
        return res;

    }

    public int trap2(int[] A) {
        if (A == null || A.length < 3) {return 0;}
        int res = 0;
        int l = 0;
        int r = A.length -1;
        int left = 0;
        int right = 0;
        while (l<r && A[l] <= A[l+1]) {l++;}
        while (l<r && A[r-1] >= A[r]) {r--;}
        while (l<r) {
            left = A[l];
            right = A[r];
            if (left <= right) {
                while (l<r && left >= A[++l]) {res+=left-A[l];}
            }
            else {
                while (l<r && right >= A[--r]) {res+=right-A[r];}
            }
        }
        return res;
    }

}
