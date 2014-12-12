package com.mystudy.leetcode;

import java.util.Stack;

/**
 * Created by yidianadmin on 14-12-6.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {return 0;}
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        boolean connected = false;
        int current = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (stack.isEmpty())  {
                stack.push(ch);
            }else {
                char top = stack.pop();
                if (top == '(' && ch == ')') {
                    if (connected) {
                        current += 2;
                        connected = true;
                    }
                    else {
                        connected = false;
                        current = 2;
                    }
                    max = Math.max(max, current);
                }
                else {
                    stack.push(top);
                    stack.push(ch);
                    current = 0;
                    connected = false;
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
