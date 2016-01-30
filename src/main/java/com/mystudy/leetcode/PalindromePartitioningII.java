package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 15/11/17.
 */
public class PalindromePartitioningII {
    public boolean isPalindrome2(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {return false;}
            start ++;
            end --;
        }
        return true;
    }
    public int dfs(int[][] min, boolean[][] isPar,  String str, int i, int j) {
        if (min[i][j] != -1) return min[i][j];
        if (i == j || isPar[i][j]) {
            min[i][j] = 0;
            return 0;
        }
        int minNum = 100000000;
        for (int k = i; k < j; k ++)  {
            int tm = dfs(min, isPar, str, i,k)+dfs(min, isPar, str, k+1,j) + 1;
            minNum = Math.min(minNum, tm);

        }
        min[i][j] = minNum;
        return minNum;
    }

    public int minCut2(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int [][] arr = new int[len][len];
        boolean[][] isPar = new boolean[len][len];

        for (int i = 0; i <len;i ++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = -1;
                isPar[i][j] = isPalindrome2(s, i, j);
            }
        }
        return dfs(arr, isPar, s, 0, len-1);
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] isPair = new boolean[len][len];
        for (int i = 0; i < len; i ++) {isPair[i][i] = true;}
        int[] minCuts = new int[len+1];
        for (int i = len-1; i >=0 ; i --) {
            minCuts[i]  = Integer.MAX_VALUE;
            for (int j = i; j < len; j ++) {
                if ((s.charAt(i) == s.charAt(j)) && (j < i + 2 || isPair[i+1][j-1]) ){
                    isPair[i][j] = true;
                    minCuts[i] = Math.min(1+minCuts[j+1], minCuts[i]);
                }
            }
        }
        return minCuts[0]-1;
    }

    public static void main(String[] args) {
//        for (String str : Arrays.asList("", "ab", "ababababababababababababcbabababababababababababa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
//            System.out.println(str
//             + new PalindromePartitioningII().minCut(str));
//        }
    }
}
