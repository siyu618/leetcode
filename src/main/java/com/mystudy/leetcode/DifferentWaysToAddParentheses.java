package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 15/10/10.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            res.add(0);
            return res;
        }
        String[] arr = input.split("-|\\*");
        List<String> list = new ArrayList<>(arr.length + 2);
        int len = input.length();
        int pre = 0;
        for (int i = 0; i < len; i ++) {
            char ch = input.charAt(i);
            boolean isEnd = false;
            if (ch == '-' || ch == '*' || ch=='+') {
                String str = input.substring(pre, i);
                list.add(str);
                list.add(ch + "");
                pre = i + 1;
            }
            else if (i == len - 1){
                String str = input.substring(pre,  len );
                list.add(str);
            }
        }
        arr = list.toArray(new String[0]);
       // System.out.println(list);

        return compute(arr, 0, arr.length-1);
    }

    public List<Integer> compute(String[] arr, int start , int end) {
        List<Integer> res = new ArrayList<>();
        if (start > end) {
            res.add(0);
            return res;
        }
        if (start == end) {
            res.add(Integer.parseInt(arr[start]));
            return res;
        }
        for (int i = start; i <= end; i ++) {
            if (!"*".equals(arr[i]) && !"-".equals(arr[i]) && !"+".equals(arr[i])) {
                continue;
            }
            List<Integer> leftList = compute(arr, start, i - 1);
            List<Integer> rightList = compute(arr, i+1, end);
            for (int left : leftList) {
                for (int right : rightList) {
                    int tm = 0 ;
                    if ("*".equals(arr[i])) {
                        tm = left * right;
                    }
                    else if ("-".equals(arr[i])){
                        tm = left - right;
                    }
                    else if ("+".equals(arr[i])){
                        tm = left + right;
                    }
                    res.add(tm);
                }
            }
        }
        Collections.sort(res);
        return res;

    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        for (String str : Arrays.asList("2-1-1", "2*3-4*5", "0+2")) {
            System.out.println(str + ": " + Arrays.asList(str.split("-|\\*")));
            System.out.println(differentWaysToAddParentheses.diffWaysToCompute(str));
        }
    }
}
