package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 16/6/29.
 */
public class WaterAndJugProblem {

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        int min = Math.min(x,y);
        int max = Math.max(x,y);
        if (max == 0) {
            return false;
        }
        if (min == 0) {
            return z % max == 0;
        }

        if (x == y) {
            return z % x == 0;
        }
        List<Integer> avail = new ArrayList<>();
        avail.add(min);
        avail.add(max);
        int tmp = min;
        while (true) {
            tmp += min;
            if (tmp > max) {
                avail.add(tmp - max);
                break;
            }
            else {
                avail.add(max - tmp);
                avail.add(Math.abs(tmp-min));
            }
        }
        int[] dp = new int[z+1];
        dp[0] = 1;
        for (int i = 0; i < z; i ++) {
            if (dp[i] != 1) {
                continue;
            }
            for (int j = 0; j < avail.size();j ++) {
                if (i+avail.get(j) <= z) {
                    dp[i+avail.get(j)] = 1;
                }

            }
        }
        return dp[z] == 1;
    }

    public static void main(String[] args)
    {
        System.out.println(canMeasureWater(34,5,6));
    }
}
