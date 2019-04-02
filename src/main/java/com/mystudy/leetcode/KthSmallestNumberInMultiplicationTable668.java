package com.mystudy.leetcode;

public class KthSmallestNumberInMultiplicationTable668 {
    private int upbound(int i, int n, int x) {
        if (x < i) {
            return 0;
        }
        if (x > i * n) {
            return n;
        }
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + ((high-low+1)>>1);
            if (i * mid <= x) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int count(int m, int n, int x) {
        int cnt = 0;
        for (int i = 1; i <= m; i ++) {
            cnt += upbound(i, n, x);
        }
        return cnt;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 1 * 1;
        int high = m * n;
        while (low < high) {
            int mid = low + ((high-low)>>1);
            int cnt = count(m, n, mid);
            if (cnt < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String... args) {
        System.out.println(new KthSmallestNumberInMultiplicationTable668().findKthNumber(3, 3, 5));
    }
}
