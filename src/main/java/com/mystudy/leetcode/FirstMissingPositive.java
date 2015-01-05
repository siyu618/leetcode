package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-4.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {return 1;}
        for (int i = 0; i < A.length; i ++) {
            int j = i;
            while (A[j] >= 1
                    && A[j] < A.length
                    && A[j] != j + 1
                    && A[A[j]-1]!=A[j]) {
                int tmp = A[A[j]-1];
                A[A[j]-1] = A[j];
                A[j] = tmp;
                j = i;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return A.length+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3,1,0,4,0};
        System.out.println(firstMissingPositive(arr));;
        int[] arr2   = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr2));;

    }

}
