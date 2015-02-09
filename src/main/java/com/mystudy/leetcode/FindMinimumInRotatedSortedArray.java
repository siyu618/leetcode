package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-16.
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] num) {
        int left = 0;
        int right = num.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (num[mid] < num[right]) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return num[left];
    }


    public static void main(String[] args) {
        int[] num = {0,1,3,4,6,7};
        System.out.println(findMin(num));
        int[] num2 = {2,1};
        System.out.println(findMin(num2));
        int[] num3 = {2,4,6,-1,0};
        System.out.println(findMin(num3));


    }
}
