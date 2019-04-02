package com.mystudy.leetcode.leetcode2;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions1003 {
    public boolean isValid(String str) {
        if (null == str || str.isEmpty()) {
            return true;
        }
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < str.length(); i ++) {
            int a = str.charAt(i) - 'a';
            if (a == 0 || a == 1) {
                stack.push(a);
            }
            else if (a == 2) {
                if (stack.size() >= 2) {
                    int t1 = stack.pop();
                    int t2 = stack.pop();
                    if (t1 == 1 && t2 == 0) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "ababcc";
        System.out.println(new CheckIfWordIsValidAfterSubstitutions1003().isValid(str));
    }
}
