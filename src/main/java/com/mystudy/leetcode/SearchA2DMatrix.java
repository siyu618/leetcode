package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-11.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (matrix[mid][0] <= target) {
                low = mid+1;
            } /*else if (matrix[mid][0]  == target) {
                return true;
            } */else {
                high = mid;
            }
        }
        //if (matrix[low][0] == target) {return true;}
        if (low == 0) {return false;}
        low = low - 1;
        System.out.println("low:" + low);
        int left = 0;
        int right = matrix[left].length-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (matrix[low][mid] > target) {
                right = mid - 1;
            }
            else if (matrix[low][mid] == target) {
                return true;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[] arr = {-3, 1, 3, 4, 10, 16, 30, 33, 50, 55};
        for (int i : arr) {
            System.out.println(i + " : " + new SearchA2DMatrix().searchMatrix(matrix, i));
        }
    }
}
