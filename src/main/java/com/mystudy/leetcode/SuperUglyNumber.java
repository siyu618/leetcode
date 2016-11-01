package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/11/1.
 */
public class SuperUglyNumber {
   static public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] smallIndex = new int[len];
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n ; i ++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j ++) {
                res[i] = Math.min(res[i], primes[j] * res[smallIndex[j]]);
            }

            for (int j = 0; j < len; j ++) {
                while (primes[j] * res[smallIndex[j]] <= res[i]) smallIndex[j] ++;
            }
        }
        return res[n-1];

    }

    public static void main(String[] args) {

//        int n = 12;
//        int[] arr = {2,7,13,19};
        int n = 500;
        int[] arr = {5,7,13,17,23,29,31,43,53,59,61,71,73,79,83,97,109,131,137,163,167,181,191,193,197,199,227,233,251,263};
        System.out.println(nthSuperUglyNumber(n, arr));
    }
}
