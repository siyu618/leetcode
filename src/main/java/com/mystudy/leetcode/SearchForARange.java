package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-11.
 */
public class SearchForARange {

    public int lowBound(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        while (left<right) {
            int mid = left + ((right-left)>>1);
            if (A[mid]<target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int upBound(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        while (left<right) {
            int mid = left + ((right-left)>>1);
            if (A[mid]<=target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (A[left] == target) {
            return left;
        }
        else {
            return left -1;
        }
    }

    public int[] searchRange(int[] A, int target) {
        if (null == A || A.length == 0 || A[0] > target || A[A.length -1] < target) {
            return new int[]{-1, -1};
        }
        int low = lowBound(A, target);
        int up = upBound(A, target);
        if (low > up) {
            return new int[]{-1, -1};
        }
        return new int[]{low, up};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int[] targets = {1, 5, 4, 7, 9, 10};
        for (int target : targets) {
            System.out.println(target);
            int[] res = new SearchForARange().searchRange(arr, target);
            for (int i : res) {
                System.out.println(i + " ");
            }
            System.out.println();
        }

    }

}
