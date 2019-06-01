package com.mystudy.leetcode.leetcode2;


public class SearchA2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            int x = mid / col;
            int y = mid % col;
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String... args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(" : " + new SearchA2DMatrix74().searchMatrix(matrix, 3));

        int[] arr = {-3, 1, 3, 4, 10, 16, 30, 33, 50, 55};
        for (int i : arr) {
            System.out.println(i + " : " + new SearchA2DMatrix74().searchMatrix(matrix, i));
        }
    }
}
