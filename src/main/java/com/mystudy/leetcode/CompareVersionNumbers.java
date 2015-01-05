package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-3.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = Math.max(len1, len2);
        int[] v1 = new int[len];
        int[] v2 = new int[len];
        for (int i = 0; i < len; i ++) {
            if (i < len1) {
                v1[i] = Integer.parseInt(arr1[i]);
            }
            else {
                v1[i] = 0;
            }
            if (i < len2) {
                v2[i] = Integer.parseInt(arr2[i]);
            }
            else {
                v2[i] = 0;
            }
        }
        for (int i = 0; i < len; i ++) {
            if (v1[i]!=v2[i]) {
                if (v1[i] > v2[i]) {return 1;};
                if (v1[i] < v2[i]) {return -1;}
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("1.1", "1.1.0"));
    }
}
