package com.mystudy.leetcode.leetcode2;

import java.util.*;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0) {
            return 0;
        }
        int[] dp = new int[rows];
        int row = -1;
        for (List<Integer> list : triangle) {
            int[] dp2 = new int[rows];
            row ++;
            int col = -1;
            for (int num : list) {
                col ++;
                if (0 == row) {
                    dp2[col] = num;
                }
                else {
                    if (col == 0) {
                        dp2[col] = dp[col] + num;
                    }
                    else if (col == row) {
                        dp2[col] = dp[col-1] + num;
                    }
                    else {
                        dp2[col] = Math.min(dp[col-1], dp[col]) + num;
                    }
                }
            }
            dp = dp2;
        }
        int min = dp[0];
        for (int i = 0; i < rows; i ++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    public static void main(String... args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3,4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4,1,8,3));
        List<List<Integer>> lists = new ArrayList<>(Arrays.asList(list1, list2, list3, list4));
        System.out.println(new Triangle120().minimumTotal(lists));
    }
}
