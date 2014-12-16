package com.mystudy.leetcode;

import java.util.Stack;

/**
 * Created by yidianadmin on 14-12-6.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {return 0;}
        Stack<Integer> stack = new Stack<Integer>();
        int[] count = new int[s.length() + 1];
        count[0] = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            else {
                if (!stack.isEmpty()) {
                    int top = stack.pop();
                    int tmp = i - top + 1;
                    if (top>0) {
                        tmp += count[top - 1];
                    }
                    count[i] = tmp;
                    max = Math.max(max, tmp);
                }
                else {
                    count[i] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] arr = {")()())", "(()", ")"};
        for (String str : arr) {
            System.out.println(longestValidParentheses(str));
        }
    }
}
