package com.mystudy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianyuzhi on 18/7/24.
 */
public class LengthofLongestFibonacciSubsequence873 {
    public int lenLongestFibSubseq(int[] A) {

        if (null ==A || A.length < 3) {
            return 0;
        }
        int len = A.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i ++) {
            set.add(A[i]);
        }
        int res  = 0;
        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++) {
                int a = A[i];
                int b = A[j];
                boolean first = true;
                int listLen = 0;
                while (set.contains(a+b)) {
                    if (first) {
                        listLen = 2;
                        first = false;
                    }
                    listLen ++;
                    int c = a + b;
                    a = b;
                    b = c;

                }
                res = Math.max(res, listLen);
            }
        }
        return res;
    }


    public static void main(String...args) {
        int[] list = {2,4,5,6,7,8,11,13,14,15,21,22,34};
        System.out.println(new LengthofLongestFibonacciSubsequence873().lenLongestFibSubseq(list));
    }

}
