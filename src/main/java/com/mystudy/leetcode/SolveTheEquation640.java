package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 17/7/26.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveTheEquation640 {
    class Pair {
        int xC = 0;
        int value = 0;
        public Pair(int xC, int value) {
            this.xC = xC;
            this.value= value;
        }
    }

    public String solveEquation(String equation) {
        String[] arr = equation.split("=");
        Pair left = process(arr[0]);
        Pair right = process(arr[1]);
        if (left.xC == right.xC) {
            if (left.value == right.value) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (right.value - left.value) / (left.xC - right.xC);
        }
    }

    private int parse(String str, int sign) {
        if (str.isEmpty())  {
            return sign;
        }
        else {
            return Integer.parseInt(str) * sign;
        }
    }

    private Pair process(String str) {
        int nC = 0;
        int num = 0;
        for (int i = 0; i < str.length(); ) {
            int j = i;
            if (str.charAt(j) == 'x') {
                nC++;
                i ++;
            } else {
                int start = i;
                int sign = 1;
                if (str.charAt(j) == '+' || str.charAt(j) == '-') {
                    if ( str.charAt(j) == '-') {
                        sign = -1;
                    }
                    j ++;
                    start ++;

                }

                while (j < str.length()
                        && str.charAt(j) >= '0'
                        && str.charAt(j) <= '9') {
                    j++;
                }
                if (j == str.length()) { //num
                    num += parse(str.substring(start, j), sign);
                    i = j;
                }
                else {
                    if (str.charAt(j) == 'x') { // x
                        nC += parse(str.substring(start, j), sign);
                        i = j + 1;
                    }
                    else {
                        num += parse(str.substring(start, j), sign);
                        i = j;
                    }
                }
            }
        }
        return new Pair(nC, num);
    }

    public static void main(String[] args) {
        SolveTheEquation640 solveTheEquation640 = new SolveTheEquation640();
        List<String> list = Arrays.asList("x+5-3+x=6+x-2", "x=x", "2x=x", "2x+3x-6x=x+2", "x=x+2");
        for (String str : list) {
            System.out.println(solveTheEquation640.solveEquation(str));
        }
    }
}
