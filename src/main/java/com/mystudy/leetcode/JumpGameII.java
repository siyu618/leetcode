package com.mystudy.leetcode;

import java.util.regex.Matcher;

/**
 * Created by yidianadmin on 15-1-20.
 */
public class JumpGameII {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {return -1;}
        if (A.length == 1 ) {return 0;}
        int steps = 0;
        int curMax = 0;
        int nextMax = 0;
        for (int i = 0; i < A.length; ) {
            while (i <= curMax && i < A.length) {
                nextMax = Math.max(nextMax, A[i] + i);
                if (nextMax >= A.length-1) {
                    steps += 1;
                    break;
                }
                i ++;
            }
            if (nextMax >= A.length-1) {break;}
            if (nextMax <= curMax) {return  -1;}
            steps += 1;
            curMax = nextMax;
        }
        return steps;
    }

    public int jump2(int[] A) {
        int[] minStep  = new int[A.length];
        for (int i = 0; i < minStep.length; i ++) {
            minStep[i] = -1;
        }
        minStep[0] = 0;
        for (int i = 0;i < A.length-1; i ++) {
            for (int j = Math.min(A.length-i-1, A[i]); j >= 1; j --) {
                if (minStep[i+j] == -1) {
                    minStep[i+j] = minStep[i] + 1;
                }
                else {
                    minStep[i+j] = Math.min(minStep[i]+1, minStep[i+j]);
                }
                if (i+j==minStep.length) return minStep[minStep.length-1];
            }
            if (minStep[minStep.length-1]!=-1) {
                break;
            }
        }
//        for (int i =0; i <minStep.length; i ++) {
//            System.out.print(" "+i + " : " + minStep[i]);
//        }
        return minStep[minStep.length-1];

    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(new JumpGameII().jump(arr));
        return;
    }
}
