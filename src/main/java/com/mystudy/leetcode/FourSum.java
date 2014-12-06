package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yidianadmin on 14-12-4.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < num.length-3; i ++) {
            if (i > 0 && num[i] == num[i-1]) {continue;}
            for (int j = num.length -1; j >= i+3; j --) {
                if (j < num.length-1 && num[j] == num[j+1]) {continue;}
                int half = num[i] + num[j];
                int m = i + 1;
                int n = j - 1;
                while (m < n) {
                    if (m > i+1 && num[m] == num[m-1]) {m++;continue;}
                    if (n < j-1 && num[n] == num[n+1]) {n --;continue;}
                    int anHalf = num[m] + num[n];
                    if (half + anHalf < target) {
                        m ++;
                    }
                    else if (half + anHalf > target) {
                        n --;
                    }
                    else {
                        res.add(Arrays.asList(new Integer[]{num[i], num[m],num[n], num[j]}));
                        m ++;
                        n --;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {-1,2,2,-5,0,-1,4};
        List<List<Integer>> res = new FourSum().fourSum(num, 3);
        for (List<Integer> lis: res) {
            for (Integer i : lis) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

    }

}
