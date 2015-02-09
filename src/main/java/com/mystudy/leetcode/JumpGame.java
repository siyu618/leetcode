package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-26.
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {return false;}
        if (A.length == 1 ) {return true;}
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > max) {return false;}
            max = Math.max(max, i + A[i] );
        }
        return true;
    }
    public boolean canJump2(int[] A) {
        if (A == null || A.length == 0) {return false;}
        if (A.length == 1 ) {return true;}
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
            if (nextMax <= curMax) {return false;}
            steps += 1;
            curMax = nextMax;
        }
        return true;
    }
}
