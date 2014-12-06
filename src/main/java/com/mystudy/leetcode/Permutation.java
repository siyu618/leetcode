package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-2.
 */
public class Permutation {
    public static void perm(String str) {
        pem(str.toCharArray(), 0);

    }

    public static void pem(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(arr);
            return;
        }
        for (int i = index; i < arr.length; i ++) {
            if (arr[i] == arr[index]) {
                pem(arr, index + 1);
            } else {
                char tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
                pem(arr, index + 1);
                tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        perm("1123");
    }
}
