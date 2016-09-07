package com.mystudy.leetcode;

import java.util.Stack;

/**
 * Created by tianyuzhi on 16/5/20.
 */
public class EvaluateReversePolishNotation {

    public boolean isOperhand(String str) {
        if ("+".equals(str)
                || "-".equals(str)
                || "*".equals(str)
                || "/".equals(str)) {
            return true;
        }
        return false;
    }

    public Integer cal(int a, int b, String op) {
        if ("+".equals(op)) {
            return a + b;
        }
        else if ("-".equals(op)) {
            return a - b;
        }
        else if ("*".equals(op)) {
            return a * b;
        }
        else if ("/".equals(op)) {
            return a / b;
        }
        else {
            return 0;
        }
    }


    public int evalRPN(String[] tokens) {
        if (null == tokens || tokens.length == 0) {
            return -1;
        }
        Stack<Integer> operatorStack = new Stack<>();
        for (String str : tokens) {
            if (isOperhand(str)) {
                int a = operatorStack.pop();
                int b = operatorStack.pop();
                int c = cal(b, a, str);
                operatorStack.push(c);
            }
            else {
                operatorStack.push(Integer.parseInt(str));
            }
        }
        return operatorStack.pop();

    }
}
