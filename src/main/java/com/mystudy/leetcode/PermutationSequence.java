package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-7.
 */
public class PermutationSequence {
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;
    }
    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
    public boolean nextPermutation(int[] arr) {
        int len = arr.length;
        int maxPos = len - 1;
        while (maxPos >= 1 && arr[maxPos] <= arr[maxPos-1]) {
            maxPos--;
        }
        // if maxPos = 0, it does not have the next one
        if (maxPos > 0) {
            int i;
            for (i = len-1; i >=maxPos-1 && arr[maxPos-1] > arr[i]; i --) {

            }
            swap(arr, maxPos-1, i);
            reverse(arr, maxPos, len -1);


        }
        return true;
    }

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = i +1;
        }
        for (int i = 0; i < k-1; i ++) {
            nextPermutation(arr);
        }
        String res = "";
        for (int i: arr) {
            res += i;
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(5,2));
    }
}
