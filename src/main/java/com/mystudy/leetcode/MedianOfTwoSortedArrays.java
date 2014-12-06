package com.mystudy.leetcode;
import java.math.*;

/**
 * Created by yidianadmin on 14-11-27.
 */
public class MedianOfTwoSortedArrays{
    public static double findMedianSortedArrays(int A[], int B[]) {
        int nA = A.length;
        int nB = B.length;
        if (nA > nB) {
            return findMedianSortedArrays(B, A);
        }
        // A [0, midA-1][midA,nA-1]
        // B [0, midB][midB+1,nB-1]
        int half = (nA + nB + 1) / 2;
        int left = 0;
        int right = nA;
        while (left < right) {
            int midA = (left + right) / 2;
            int midB = half - midA - 1;
            if (A[midA] < B[midB]) {
                left = midA + 1;
            } else {
                right = midA;
            }
        }
        int midA = left;
        int midB = half - midA - 1;

        int lMax = Math.max(midA > 0 ? A[midA-1] : Integer.MIN_VALUE, midB >= 0 ? B[midB] : Integer.MIN_VALUE);
        int rMin = Math.min(midA < nA ? A[midA] : Integer.MAX_VALUE, midB + 1 < nB ? B[midB+1] : Integer.MAX_VALUE);
        if ((nA + nB)% 2 == 1) {
            return lMax;
        }
        else {
            return (lMax + rMin) / 2.0;
        }
    }
    public static void main(String[] args) {
        int[] A = {1,3,5,9,11};
        int[] B = {2,3,7,9,11};
        System.out.println(findMedianSortedArrays(A, B));

        int[] A1 = {1,1};
        int[] B1 = {1,2};
        System.out.println(findMedianSortedArrays(A1, B1));

    }
}

