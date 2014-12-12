package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-9.
 */
public class DivideTwoIntegers {
    public static long divide(int dividend, int divisor) {
        long res = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        while (a>=b) {
            long tb = b;
            long shift = 1;
            while (a >= (tb<<1)) {
                shift <<= 1;
                tb <<= 1;
            }
            a -= tb;
            res |= shift;
        }
        if ((dividend >= 0 && divisor < 0 ) || (dividend <= 0 && divisor > 0 )) {
            return -res;
        }
        if (res >= (long)Integer.MAX_VALUE+1) {
            res = Integer.MAX_VALUE;
        }
        return res;
    }
    public static long divide2(int dividend, int divisor) {
        long ans = 0;
        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        while (n >= d) {
            long a = d;
            long m = 1;
            while ((a << 1) < n) {
                a <<= 1;
                m <<= 1;
            }
            ans += m;
            n -= a;
        }
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0))
            return -ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(divide(0, 1));
        System.out.println(divide(-1010369383, -2147483648));
        System.out.println(divide(-5, 3));
        System.out.println(divide(-5, -3));
        System.out.println(divide(5, -3));
        System.out.println(divide(-5, -3));
    }
}
